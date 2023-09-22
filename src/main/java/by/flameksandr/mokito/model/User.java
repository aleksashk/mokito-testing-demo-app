package by.flameksandr.mokito.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String username;
    private String role;

    public User(String username) {
        this.username = username;
    }

    public User(String username, String role) {
        this.username = username;
        this.role = role;
    }
}
