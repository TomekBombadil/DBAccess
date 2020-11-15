package pl.coderslab.entity;

import pl.coderslab.entity.UserDao;

public class User {

    private long id = -9999;
    private String email;
    private String userName;
    private String password;

    public User(){

    }

    public User(String email, String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.setPassword(password, true);
    }

    public User(long id, String email, String userName, String password) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.setPassword(password, true);
    }

    public long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password, boolean hashed) {
        if(hashed == true){
            this.password = UserDao.hashPassword(password);
        }
        else{
            this.password = password;
        }
    }


    public String toString(){
        return "Id: " + getId() + ", Email: " + getEmail() + ", Username: " + getUserName();
    }
}

