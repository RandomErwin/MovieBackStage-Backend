package org.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.web.annotation.PermissionAnnotation;
import org.web.dao.UserDao;
import org.web.entity.Users;
import org.web.util.JwtUtil;

import java.util.Optional;

@RestController
@RequestMapping("/permission")
public class LoginController {

    private UserDao userDao;

    @Autowired
    private JwtUtil jwtUtil;

    public LoginController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping("/login")
    @PermissionAnnotation()
    public ResponseEntity<String> loginPost(@RequestBody Users users,
                                            HttpServletRequest request) {
        Optional<Users> optionalUsers = userDao.findByAccountAndPasswd(users.getAccount(), users.getPasswd());

        if(optionalUsers.isPresent()){
            Users users1 = optionalUsers.get();
            String token = jwtUtil.generateToken(
                    users1.getId(),
                    users1.getAccount()
            );
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("查無權限");
        }
    }
}
