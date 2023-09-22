package by.flameksandr.mokito.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String username;
    private String role;

    public User(String username, String role) {
        this.username = username;
        this.role = role;
    }
}
