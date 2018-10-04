package com.magical.SinglePageAplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloController {
    @RequestMapping("/")
    @GetMapping(value = {"/", "/index"})
    String index() {
        return "index";
    }
}
