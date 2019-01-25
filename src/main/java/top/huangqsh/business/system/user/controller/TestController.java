package top.huangqsh.business.system.user.controller;

import top.huangqsh.business.system.user.entity.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/test")
public class TestController {

    @GetMapping("/getusers")
    public List<User> getUsers() {
        List<User> list = new ArrayList<>();
        list.add(new User());

        return list;
    }
}
