package com.dailycodebuffer.springbootdemo.models.users;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Roles {

    private Integer Id;
    private String name;
    private String description;

    public Roles(String name) {
        this.name = name;
    }

    public Roles(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
