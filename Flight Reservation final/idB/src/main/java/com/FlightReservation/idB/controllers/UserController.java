package com.FlightReservation.idB.controllers;

import com.FlightReservation.idB.entities.User;
import com.FlightReservation.idB.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/showReg")
    public String showUserRegistration() {
        return "registerUser";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping(value = "registerUser", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelMap) {
        User user = userRepository.findByEmail(email);
        if(user.getPassword().equals(password)) {
            return "findFlights";
        } else {
            modelMap.addAttribute("msg", "Login failed, please try again.");
        }
        return "login";
    }
}