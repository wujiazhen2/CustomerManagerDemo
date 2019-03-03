package com.qworldr.customer.controller;

import com.qworldr.customer.bean.UserEntitiy;
import com.qworldr.customer.query.QueryParam;
import com.qworldr.customer.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



/**
 * @author wujiazhen
 * @date 2019/2/24
 */
@RestController
@RequiresUser
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequiresGuest
    @RequestMapping("/login")
    public ResponseEntity<UserEntitiy> login(String phone, String password) {
        Subject subject = SecurityUtils.getSubject();//获取当前对象
        AuthenticationToken token = new UsernamePasswordToken(phone, password);
        UserEntitiy loginUser;
        try {
            subject.login(token);
            loginUser = (UserEntitiy) subject.getPrincipal();
        } catch (UnknownAccountException | IncorrectCredentialsException e) {//用户名不存在发生该异常,密码不正确发生该异常
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(loginUser);
    }

    @RequiresPermissions("admin")
    @RequestMapping("/register")
    public ResponseEntity<Integer> register(@RequestBody UserEntitiy userEntitiy) {
        userService.save(userEntitiy);
        return ResponseEntity.ok(userEntitiy.getId());
    }

    @RequestMapping("/changePassword")
    public ResponseEntity changePassword(String newPassword){

        return ResponseEntity.ok().build();
    }
    @RequiresPermissions("admin")
    @RequestMapping("/updateUser")
    public ResponseEntity updateUser(@RequestBody UserEntitiy userEntitiy){
        userService.update(userEntitiy);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/list")
    public ResponseEntity<List<UserEntitiy>> list(@RequestBody QueryParam queryParam) {
        List<UserEntitiy> list = userService.list(queryParam);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<UserEntitiy> get(@PathVariable int id) {
        UserEntitiy list = userService.get(id);
        return ResponseEntity.ok(list);
    }

    @RequestMapping("/delete")
    public ResponseEntity delete(@RequestBody ArrayList<Integer> id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

}
