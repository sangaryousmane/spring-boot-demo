package com.dailycodebuffer.springbootdemo.models.users;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Users {

    private Integer Id;
    private String email;
    private String firstname;
    private String lastName;
    private String password;
    private boolean enabled;
    private String photos;

}
