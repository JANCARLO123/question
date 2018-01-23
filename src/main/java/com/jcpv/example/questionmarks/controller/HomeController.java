package com.jcpv.example.questionmarks.controller;
;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Created by jancarlo on 10/01/18.
 */

@Slf4j
@Controller
public class HomeController {

    //private static final Logger log = LoggerFactory.getLogger(HomeController.class);
    @Value("${messages.home:default-value}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String welcome(Model model) {
         log.info("Spring Boot Thymeleaf Configuration Example");
        model.addAttribute("message", message);
        return "home";
    }

}