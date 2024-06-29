package org.web.controller;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.web.dao.UserDao;
import org.web.dto.Result;
import org.web.entity.Users;
import org.web.form.UserForm;
import org.web.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/createUser")
    public Result createUser(@RequestBody Users users){
        return userService.createUser(users);
    }

    @PutMapping("/updateUser")
    public Result updateUser(@RequestBody Users users){
        return userService.updateUser(users);
    }

    @DeleteMapping("/deleteUser/{id}")
    public Result deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);
    }

    @GetMapping("/getUser/{id}")
    public Result getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }

    @GetMapping("/getAll")
    public Result findAll(){
        return userService.findAll();
    }

    // 需要拿到驗證結果
    // Spring Validation就是屬於伺服器端的驗證
    @PostMapping("/register")
    public String register(@Valid UserForm userForm, BindingResult result){
        System.out.println(userForm);
        // BindingResult => Error method: hasErrors()
        if(result.hasErrors()){
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors){
                System.out.println(fieldError.getField() + ":" + fieldError.getDefaultMessage() + ":" + fieldError.getCode());
            }
            // 直接返回註冊頁面
            return "register";
        }
        // 在 Controller層，將 userForm 轉換成 User
        Users users = userForm.convertToUser();
        userDao.save(users);
        return "register";
    }

}
