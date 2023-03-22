package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @RequestMapping("/hello")
    String hello(String username, Model model, HttpSession session)
    {
        model.addAttribute("username", username);
        session.setAttribute("username", username);
        return "hello";
    }

    @RequestMapping("/getuser")
    String GetUser(Model model, HttpSession session)
    {
        String username = (String)session.getAttribute("username");
        model.addAttribute("username", username);
        return "hello";
    }

    @RequestMapping("/logout")
    String Logout(HttpSession session)
    {
        session.invalidate(); //销毁会话
        return "hello";
    }

}
