package pl.coderslab.entity;

public class User {

    private long id = -9999;
    private String email;
    private String userName;
    private String password;

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

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString(){
        return "Id: " + getId() + ", Email: " + getEmail() + ", Username: " + getUserName();
    }
}

