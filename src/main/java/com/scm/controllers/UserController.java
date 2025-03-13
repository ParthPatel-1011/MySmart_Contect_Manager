package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/user")
public class UserController {

    // user dashbord page
    @RequestMapping(value = "/dashbord")
    public String userDashbord() {
        return "user/dashbord";
    }

    // user profile page

    @RequestMapping(value = "/profile")
    public String userProfile() {
        return "user/profile";
    }
    

    // user add contect page

    // user view contect page

    // user edit contect page

    // user ddelet contact page

    // user search contact page

}
