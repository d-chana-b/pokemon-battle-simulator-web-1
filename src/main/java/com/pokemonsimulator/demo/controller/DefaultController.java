package com.pokemonsimulator.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {
    @GetMapping("/")
    public String home1() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "index";
    }

    // @GetMapping("/admin")
    // public String admin() {
    // return "/admin";
    // }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    // @GetMapping("/login")
    // public String login() {
    // return "/login";
    // }

    // @GetMapping("/403")
    // public String error403() {
    // return "/error/403";
    // }
}
