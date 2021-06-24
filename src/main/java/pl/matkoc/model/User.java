package pl.matkoc.model;

import org.mindrot.jbcrypt.BCrypt;

public class User {

    private int id_user;
    private String userName;
    private String email;
    private String password;
    private int id_group;

    public void hashPassword(String password){
        this.password = BCrypt.hashpw(password,BCrypt.gensalt());
    }

    public User(String userName, String email, String password, int group_id) {
        if(group_id < 0){
            throw new NullPointerException("Id nie może być mniejsze od zera.");
        }
        if(userName.isEmpty() || userName.isBlank()){
            throw new IllegalArgumentException("Nazwa nie może być pusta.");
        }
        if(email.isBlank() || email.isEmpty()){
            throw new IllegalArgumentException("Email nie może być pusty.");
        }
        this.userName = userName;
        this.email = email;
        this.id_group = group_id;
        this.hashPassword(password);
    }

    public User() {};

    public int getId() {
        return id_user;
    }

    public void setId(int id_user) {
        if(id_user < 0){
            throw new IllegalArgumentException("Id nie może być mniesze od zera.");
        }
        this.id_user = id_user;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if(userName.isEmpty() || userName.isBlank()){
            throw new IllegalArgumentException("Nazwa nie może być pusta.");
        }
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email.isBlank() || email.isBlank()){
            throw new IllegalArgumentException("Email nie może być pusty.");
        }
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public int getGroupId() {
        return id_group;
    }

    public void setGroupId(int group_id) {
        if(group_id < 0){
            throw new NullPointerException("Id nie może być mniejsze od zera.");
        }
        this.id_group = group_id;
    }

    public void setPassword(String password) {
        if(password.isBlank() || password.isEmpty()){
            throw new IllegalArgumentException("Hasło nie może być puste.");
        }
        this.password = BCrypt.hashpw(password,BCrypt.gensalt());
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %s: %d"
                ,getId(),getUserName(),getEmail(),"Id grupy",id_group);
    }
}