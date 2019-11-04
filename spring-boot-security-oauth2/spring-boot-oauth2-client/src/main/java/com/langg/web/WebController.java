package com.langg.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * web控制层
 *
 * @author zh
 * @date 2019/11/4 14:51
 * @since 1.0.0
 */
@Controller
public class WebController {

    @RequestMapping("/securedPage")
    public String securedPage(Model model, Principal principal) {
        return "securedPage";
    }

    /**
     * 启动server、client后浏览器输入ip:8082
     * @param model
     * @param principal
     * @return
     */
    @RequestMapping("/")
    public String index(Model model, Principal principal) {
        return "index";
    }
}
