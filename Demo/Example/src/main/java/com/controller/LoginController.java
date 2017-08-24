package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Alexhu on 2017/7/28.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String login() {

        return "/WEB-INF/pages/login/login.jsp";
    }
}
