package kr.co.spring_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
=======

>>>>>>> d86e514 (Resolve merge conflict)
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
<<<<<<< HEAD
        return "home"; // home.html 반환
    }

    @GetMapping("/list")
    public String list() {
        return "list"; // list.html 반환
    }

}
=======

        return "home";
    }
}
>>>>>>> d86e514 (Resolve merge conflict)
