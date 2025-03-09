package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model){
        System.out.println("Home page handeler");
        model.addAttribute("name", "Substring");
        model.addAttribute("youtubeChannel", "PsaPro");
        model.addAttribute("githubRepo", "https://github.com/ParthPatel-1011/");
        return "home";
    }

    // about route
    @RequestMapping("/about")
    public String aboutPage(){
        return "about";
    }

    // services route 
    @RequestMapping("/services")
    public String servicesPage(){
        return "services";
    }
}
