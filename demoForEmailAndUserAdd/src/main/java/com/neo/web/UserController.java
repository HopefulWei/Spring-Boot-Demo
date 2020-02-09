package com.neo.web;

import com.neo.model.User;
import com.neo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {

    @Resource
    UserService userService;


    @RequestMapping("/")
    public String index() {
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<User> users=userService.getUserList();
        model.addAttribute("users", users);
        return "user/list";
    }
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "user/login";
    }

    @RequestMapping("/login")
    public String login(User user) {
        System.out.println(user.getUserName());
        boolean result=userService.Login(user.getUserName(),user.getPassword());
        System.out.println(result);
        if(result){
            return "user/welcome";
        }else{
           return  "user/login";
        }
    }
    @RequestMapping("/welcome")
    public String welcome() {
        return "user/welcome";
    }


    @RequestMapping("/toAdd")
    public String toAdd() {
        return "user/userAdd";
    }

    @RequestMapping("/add")
    public String add(User user) {
        userService.addUserRedis(user.getUserName(),user.getPassword());
        userService.save(user);
        return "redirect:/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model,Long id) {
        User user=userService.findUserById(id);
        model.addAttribute("user", user);
        userService.deleteUserRedis(user.getUserName());
        return "user/userEdit";
    }

    @RequestMapping("/edit")
    public String edit(User user) {
        userService.edit(user);
        userService.addUserRedis(user.getUserName(),user.getPassword());
        return "redirect:/list";
    }


    @RequestMapping("/delete")
    public String delete(Long id) {
        User user=userService.findUserById(id);
        userService.delete(id);
        userService.deleteUserRedis(user.getUserName());
        return "redirect:/list";
    }
}
