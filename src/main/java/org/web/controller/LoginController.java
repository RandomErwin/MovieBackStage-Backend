package org.web.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.web.dao.UserDao;
import org.web.entity.Users;

@RestController
public class LoginController {

    private UserDao userDao;

    public LoginController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam String account,
                            @RequestParam String passwd,
                            HttpSession session){
        Users users = userDao.findByAccountAndPasswd(account, passwd);
        if(users != null){
            session.setAttribute("users", users);
            return "index";
        }
        return "login";
    }
}
