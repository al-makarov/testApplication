package com.magical.SinglePageAplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Основной контроллер для роутинга
 */
@Controller
public class AuthController {
    @GetMapping(value = {"/"})
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

}
