package com.langg.web;

import com.langg.domain.User;
import com.langg.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * web控制层
 *
 * @author zh
 * @date 2019/11/13 17:26
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user")
public class WebController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String name, @RequestParam String password, HttpSession session) {
        User byId = userService.login(name, password);

        if (ObjectUtils.isEmpty(byId)) {
            return "登陆失败";
        }

        session.setAttribute(session.getId(), byId);

        return "登陆成功";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.removeAttribute(session.getId());
        return "登出成功";
    }

    @GetMapping(value = "/findById")
    public User findById(@RequestParam Long id) {
        return userService.findById(id);
    }
}
