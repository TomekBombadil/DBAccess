package pl.coderslab.entity;

import pl.coderslab.workshop2.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class UserDao {

    private static final String DB_NAME = "workshop2";
    private static final String CREATE_USER_QUERY = "insert into users (email, username, password) values (?,?,?);";
    private static final String UPDATE_USER_QUERY = "update users set email=?, username=?, password=? where id=?;";
    private static final String DELETE_USER_BY_ID_QUERY = "delete from users where id=?;";
    private static final String SELECT_USER_BY_ID_QUERY = "select id, email, username, password from users where id=?;";
    private static final String SELECT_ALL_USERS_QUERY = "select id, email, username, password from users;";

    public User create(User user){
        try(Connection conn = DBUtil.getConnection(DB_NAME)){
            PreparedStatement stmt = conn.prepareStatement(CREATE_USER_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getUserName());
            stmt.setString(3, hashPassword(user.getPassword()));
            int recCount = stmt.executeUpdate();
            System.out.println("Dodano " + recCount + " rekord");
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                user.setId(rs.getLong(1));
            }
        }
        catch(SQLException se){
            se.printStackTrace();
            return null;
        }
        return user;
    }

    public User read(long id){
        User selectedUser = null;
        try(Connection conn = DBUtil.getConnection(DB_NAME)){

            PreparedStatement stmt = conn.prepareStatement(SELECT_USER_BY_ID_QUERY);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                selectedUser = new User();
                selectedUser.setId(rs.getLong("id"));
                selectedUser.setEmail(rs.getString("email"));
                selectedUser.setUserName(rs.getString("username"));
                selectedUser.setPassword(rs.getString("password"));
            }
        }
        catch(SQLException se){
            se.getStackTrace();
            return selectedUser;
        }
        return selectedUser;
    }

    public void update(User user){
        try(Connection conn = DBUtil.getConnection("workshop2")){
            PreparedStatement stmt = conn.prepareStatement(UPDATE_USER_QUERY);
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getUserName());
            stmt.setString(3, hashPassword(user.getPassword()));
            stmt.setLong(4, user.getId());
            int recCount = stmt.executeUpdate();
            System.out.println("Zmieniono " + recCount + " rekord");
        }
        catch(SQLException se){
            se.printStackTrace();
        }
    }

    public void delete(long id){
        try(Connection conn = DBUtil.getConnection("workshop2")){
            PreparedStatement stmt = conn.prepareStatement(DELETE_USER_BY_ID_QUERY);
            stmt.setLong(1, id);
            int recCount = stmt.executeUpdate();
            System.out.println("Usunięto " + recCount + " rekord");
        }
        catch(SQLException se){
            se.printStackTrace();
        }
    }

    public User[] findAll(){
        User[] foundUsers = new User[0];
        try(Connection conn = DBUtil.getConnection("workshop2")){
            PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_USERS_QUERY);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                User readUser = new User();
                readUser.setId(rs.getLong("id"));
                readUser.setEmail(rs.getString("email"));
                readUser.setUserName(rs.getString("username"));
                readUser.setPassword(rs.getString("password"));
                foundUsers = addUserToArray(readUser, foundUsers);
            }
        }
        catch(SQLException se){
            se.printStackTrace();
            return foundUsers;
        }
        return foundUsers;
    }

    private String hashPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    private User[] addUserToArray(User user, User[] users){
        User[] newUsers = Arrays.copyOf(users, users.length+1);
        newUsers[newUsers.length-1] = user;
        return newUsers;
    }
}
