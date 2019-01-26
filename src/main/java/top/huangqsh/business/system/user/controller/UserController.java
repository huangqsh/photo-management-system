package top.huangqsh.business.system.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.huangqsh.business.system.user.entity.User;
import top.huangqsh.business.system.user.service.UserService;
import top.huangqsh.core.base.BaseResult;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login/")
    public BaseResult<User> login(HttpServletRequest request, String userName, String password) {
        return null;
    }

    @GetMapping("/logout")
    public BaseResult<String> logout(String userName){
        return  null;
    }
}
