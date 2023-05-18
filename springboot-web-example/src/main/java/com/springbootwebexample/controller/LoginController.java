package com.springbootwebexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String login(Model model, @RequestParam("username") String username,
                        @RequestParam("username") String password, HttpSession session){
        System.out.println(username+" "+password);
        if (!StringUtils.isEmpty(username) && password.equals("admin")) {
            session.setAttribute("loginUser", username);
            return "redirect:/main";
        }
        model.addAttribute("msg","用户名或者密码错误");
        return "index";
    }
}
