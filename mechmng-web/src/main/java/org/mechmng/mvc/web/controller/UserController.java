/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.mechmng.mvc.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author HuHui
 * @version $Id: HelloController.java, v 0.1 2016年5月22日 上午11:34:48 HuHui Exp $
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/showUser")
    public String toShowUser(HttpServletRequest request, Model model) {
        return "showUser";
    }
}
