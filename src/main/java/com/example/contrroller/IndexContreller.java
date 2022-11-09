package com.example.contrroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


//在templates目录下的所有页面，只能通过controller来跳转！
@Controller
public class IndexContreller {

    @RequestMapping("/login")
    public String index(Model model){

        return "login";
    }
}
