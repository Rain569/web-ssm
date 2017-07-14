package com.heitian.ssm.controller;

import com.heitian.ssm.dao.StudentMapper;
import com.heitian.ssm.model.Student;
import com.heitian.ssm.model.User;
import com.heitian.ssm.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @Resource
    private StudentMapper studentMapper;
 //项目： http://blog.csdn.net/gallenzhang/article/details/51932152
    //bbbccc
    /**
    * @date:2017/7/14 18:45
    * @author:312171aa
    * @description:
    */
    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest request, Model model){
        log.info("查询所有用户信息");
        User user = userService.getUserById(1L);
        log.info("查询所有用户信息"+user.getUserEmail());
      //  int i = studentMapper.deleteByPrimaryKey("s001");
        List<Student> userList = studentMapper.selectAllStudent();
     //  List<User> userList = userService.getAllUser();
        System.out.println("查询所有用户信息");
        model.addAttribute("userList",userList);
        return "showUser";
    }

}
