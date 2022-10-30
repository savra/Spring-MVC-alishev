package com.hvdbs.springcourse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(required = false) String name,
                            @RequestParam(required = false) String surname,
                            Model model) {

        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam int a,
                             @RequestParam int b,
                             @RequestParam String action,
                             Model model) {

        switch (action.toUpperCase()) {
            case "MULTIPLICATION":
                model.addAttribute("result", a * b);
                break;
            case "ADDITION":
                model.addAttribute("result", a + b);
                break;
            case "SUBTRACTION":
                model.addAttribute("result", a - b);
                break;
            case "DIVISION":
                model.addAttribute("result", a / (double)b);
                break;
            default:
                model.addAttribute("result", "Action not found");
        }


        return "first/calculator";
    }
}
