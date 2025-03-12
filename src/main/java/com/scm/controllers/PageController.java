package com.scm.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class PageController {

    @Autowired
    private UserService userService;

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

    // contact route 
    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    // Login route 
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    // Signup route 
    @RequestMapping("/register")
    public String register(Model model){
        // defoult data also you can add
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        return "register";
    }

    // prosesing register
    @RequestMapping(value = "/do-register", method=RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult, HttpSession session) {
        // fetch form data

        // validate form data
        if(rBindingResult.hasErrors()){
            return "register";
        }

        // save to database
        // User user = User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .profilePic("https://img.freepik.com/free-vector/blue-circle-with-white-user_78370-4707.jpg")
        // .build();

        User user = new User();
        user.setUserId(UUID.randomUUID().toString()); 
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("https://img.freepik.com/free-vector/blue-circle-with-white-user_78370-4707.jpg");

        User savedUser = userService.saveUser(user);

        // user service

        // message : registration succsesfull

        Message message=Message.builder().content("Register Succesful").type(MessageType.green).build();

        session.setAttribute("message",message);
        //redirecct another page
        return "redirect:/register";
    }
    
}
