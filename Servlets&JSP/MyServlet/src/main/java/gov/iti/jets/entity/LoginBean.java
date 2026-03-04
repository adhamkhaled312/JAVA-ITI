package gov.iti.jets.entity;

import gov.iti.jets.dao.UserDao;

public class LoginBean {
    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean validate(){
        UserDao dao = new UserDao();
        return dao.login(username, password) != null;
    }
}
