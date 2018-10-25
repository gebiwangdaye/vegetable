package com.gbwdy.vegetable.controller;

import com.gbwdy.vegetable.service.UserService;
import com.gbwdy.vegetable.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @author gebiwangdaye
 * @date 2018/7/8
 */
@Controller
public class LoginController {

    @Resource
    UserService userService;
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,@RequestParam("password") String password){

        User user =  userService.findUser(username,password);
        if(user != null){
            return "addVegetable";
        }
        return "index";
    }
    @RequestMapping("/temp")
    public String temp(){

        return "login";
    }
}
