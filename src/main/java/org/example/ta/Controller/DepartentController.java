package org.example.ta.Controller;



import org.example.ta.Model.User;
import org.example.ta.Model.UserData;
import org.example.ta.Repository.IUserDao;
import org.example.ta.Service.DepartmentService;
import org.example.ta.Service.userDataService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartentController {

    @Autowired
    IUserDao userDao;

    @Autowired
    DepartmentService dpService;

    @Autowired
    userDataService dataService;

    //List Of All Users For TA's
    @CrossOrigin(origins ="*")
    @GetMapping(value = "/AllUsers")
    public List<User> getUser(){
        return userDao.findAll();
    }

    //List Of Users For Administrator & Instructor
    @CrossOrigin(origins ="*")
    @GetMapping(value = "/selected/userType/{userType}")
    public List<User> getUserByType(@PathVariable String userType){
        return dpService.getUserByType(userType);
    }

    @CrossOrigin(origins ="*")
    @GetMapping(value = "/check")
    public String getUserCheck(){
        return "Hello";
    }

    //AssignTask
    @CrossOrigin(origins ="*")
    @PostMapping(value = "/assignTask")
    public String assignTask (@RequestBody String assignData) throws JSONException {
        return dataService.assignTask(assignData);
    }

    //AssignTaskDone
    @CrossOrigin(origins ="*")
    @PostMapping(value = "/assignTaskDone")
    public String assignTaskDone (@RequestBody String taskDone) throws JSONException {
        return dataService.assignTaskDone(taskDone);
    }

    //Forward Or Rejected
    @CrossOrigin(origins ="*")
    @PostMapping(value = "/forwardOrRejected")
    public String forwardOrRejected(@RequestBody String forwardData) throws JSONException {
        return dataService.forwardOrRejected(forwardData);
    }

    //Commented By Instructor
    @CrossOrigin(origins ="*")
    @PostMapping(value = "/addComment")
    public String commented(@RequestBody String comment) throws JSONException {
        return dataService.commented(comment);
    }

    //Selected Or Rejected
    @CrossOrigin(origins ="*")
    @PostMapping(value = "/selectedOrRejected")
    public String selectReject (@RequestBody String selection) throws JSONException {
        return dataService.selectReject(selection);
    }

    //Accept Or Reject Offer
    @CrossOrigin(origins ="*")
    @PostMapping(value = "/acceptOrRejectOffer")
    public String acceptReject (@RequestBody String offer) throws JSONException {
        return dataService.acceptReject(offer);
    }

    //Get All Applicants
    @CrossOrigin(origins ="*")
    @GetMapping(value = "/getAllApplicant")
    public List<UserData> getAllApplicants(){
        return dataService.getAllApplicants();
    }
}
