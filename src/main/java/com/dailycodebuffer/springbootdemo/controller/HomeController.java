package com.dailycodebuffer.springbootdemo.controller;

import com.dailycodebuffer.springbootdemo.entities.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @GetMapping("/")
    public String hello() {
        return "<b>Hello brother, I am Ous!</b>";
    }

    @GetMapping("/user")
    public User user() {
        User user = new User();
        user.setId("1");
        user.setName("Ousmane");
        user.setEmailId("ousmane@gmail.com");
        return user;
    }

    // Mimicking path variable
    @GetMapping("/user/{id}/{id2}")
    public String pathVariable(@PathVariable String id,
                               @PathVariable(name = "id2", required = false) String name) {
        return "The path variable 1 is: " +
                id + " and the second is: " + name;
    }

    // Mimicking request parameter
    @GetMapping("/requestParam")
    public String requestParams(@RequestParam String name,
                                @RequestParam(name = "email",
                                        required = false, defaultValue = "unavailable") String emailId){
        return "Hello, your name is: " + name + " and email id is: "+ emailId;
    }

}


// Path variables are mandatory and request parameters aren't