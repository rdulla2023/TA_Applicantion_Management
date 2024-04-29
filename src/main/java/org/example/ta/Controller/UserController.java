package org.example.ta.Controller;


import org.example.ta.DTO.SignInInput;
import org.example.ta.Model.User;
import org.example.ta.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @CrossOrigin(origins ="*")
    @PostMapping(value = "/signUp")
    public User signUp(@RequestBody User user){
        return userService.signUp(user);
    }

    @CrossOrigin(origins ="*")
    @PostMapping(value = "/signIn")
    public User signIn(@RequestBody SignInInput sign){
        return userService.signIn(sign);
    }

    @CrossOrigin(origins ="*")
    @GetMapping(value = "/")
    public String check(){
        return "working";
    }
}
