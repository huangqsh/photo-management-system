package top.huangqsh.business.system.user.controller;

import top.huangqsh.core.base.BaseResult;
import top.huangqsh.business.system.user.entity.User;
import top.huangqsh.core.enums.ResultEnum;
import top.huangqsh.core.exception.GlobalException;
import top.huangqsh.business.system.user.service.UserService;
import top.huangqsh.core.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getuser/{id}")
    public BaseResult<User> getUser(@PathVariable("id") String userName) {
        User u = userService.getUserById(userName);
        return ResultUtil.success(u);
    }

    @PostMapping("/insertuser/{username}")
    public BaseResult<Integer> insertUser(@PathVariable("username") String username) {
        User user = new User();
        user.setUsername(username);
        userService.insertUser(user);
        return ResultUtil.success();
    }

    @DeleteMapping("/deleteuser/{id}")
    public BaseResult<Integer> deleteUser(@PathVariable("id") Integer id) {
        if (id == null || id < 1) {
            throw new GlobalException(ResultEnum.PARAMETER_ERROR);
        } else {
            userService.deleteUser(id);
            return ResultUtil.success();
        }
    }

    @PutMapping("/updateuser")
    public BaseResult<Integer> updateUser(User user) {
        if (user == null || user.getUserId() == null || user.getUserId() < 1) {
            throw new GlobalException(ResultEnum.PARAMETER_ERROR);
        } else {
            userService.updateUser(user);
            return ResultUtil.success();
        }
    }
}
