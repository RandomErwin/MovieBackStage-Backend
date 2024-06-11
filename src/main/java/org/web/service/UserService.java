package org.web.service;

import org.springframework.stereotype.Service;
import org.web.dao.UserDao;
import org.web.dto.Result;
import org.web.entity.Users;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    public Result createUser(Users users){
        System.out.println(users); //印出User的資料 => 查看傳輸內容
        userDao.save(users);
        return new Result(200, "success");
    }

    public Result updateUser(Users users){
        userDao.save(users);
        return new Result(200, "success");
    }

    public Result deleteUser(Integer userId){
        userDao.deleteById(userId);
        return new Result(200, "success");
    }

    public Result getUser(Integer userId){
        // 避免找不到user、缺少值、為null的情況發生
        Optional<Users> uesrsOptional = userDao.findById(userId);
        if(uesrsOptional.isPresent()){
            return new Result(200, uesrsOptional.get());
        }else {
            return new Result(9999, "no data");
        }
    }

    public Result findAll(){
        List<Users> users =  userDao.findAll();
        return new Result(200, users);
    }

    public Result test(Users users){
        List<Users> list = userDao.findByEmailJPQL(users.getEmail());
        return new Result(200,list);
    }

}
