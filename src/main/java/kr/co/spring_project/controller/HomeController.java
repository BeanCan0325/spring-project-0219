package kr.co.spring_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home"; // home.html 반환
    }

    @GetMapping("/list")
    public String list() {
        return "list"; // list.html 반환
    }

}
