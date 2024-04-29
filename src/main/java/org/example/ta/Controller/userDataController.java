package org.example.ta.Controller;


import org.example.ta.Model.UserData;
import org.example.ta.Service.userDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userDataController {

    @Autowired
    userDataService dataService;

    @CrossOrigin(origins ="*")
    @PostMapping(value = "/fillForm")
    public String fillForm(@RequestBody UserData data){
        return dataService.fillForm(data);
    }
}
