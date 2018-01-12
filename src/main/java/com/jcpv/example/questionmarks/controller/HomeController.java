package com.jcpv.example.questionmarks.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Created by jancarlo on 10/01/18.
 */

@Log
@Controller
public class HomeController {


    @Value("${messages.home:default-value}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String welcome(Model model) {
       // log.info("Spring Boot Thymeleaf Configuration Example");
        model.addAttribute("message", message);
        return "home";
    }

}