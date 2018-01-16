package cn.itcast.springmvc.controller;


import cn.itcast.springmvc.pojo.User;
import cn.itcast.springmvc.pojo.UsersVO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: touGe
 * @Date: 2018-01-11
 * @Time: 16:30
 */
@Controller
@RequestMapping(value = "views2")
public class HelloController2 {

    @RequestMapping(value = "show01")
    public String text01(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        model.addAttribute("msg","request"+request+"<br />response"+response+"<br />session"+session);
        return "hello";
    }

    @RequestMapping(value = "show02")
    public String text02(ModelMap modelMap) throws Exception {
        modelMap.addAttribute("msg","寂寞任不休");
        return "hello";
    }

    @RequestMapping(value = "show03/{name}/{password}")
    public String text03(Model model,@PathVariable("name")String name,@PathVariable("password")Long password) throws Exception {
        model.addAttribute("msg","占位符测试");
        return "hello";
    }

    @RequestMapping(value = "show04")
    public String text04(Model model,@RequestParam(value = "name",required = true ,defaultValue = "xxx")String name) throws Exception {
        model.addAttribute("msg","name: "+name);
        return "hello";
    }

    @RequestMapping(value = "show05")
    public String text05(Model model,HttpServletRequest request) throws Exception {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("JSESSIONID".equals(cookie.getName())){
                System.out.println(cookie.getValue());
            }
        }
        return "hello";
    }

    @RequestMapping(value = "show06")
    public String text06(Model model,@CookieValue(value = "JSESSIONID") Cookie cookie) throws Exception {

        model.addAttribute("msg",cookie.getValue());
        return "hello";
    }

    @RequestMapping(value = "show07")
    @ResponseStatus(value = HttpStatus.OK)
    public void text07(Model model,@RequestParam("name")String name,@RequestParam("interests") String[] interests) throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append("name:"+name);
        sb.append("interests:[");
        for (String interest : interests) {
            sb.append(interest+" ");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    @RequestMapping(value = "show08")
    public String text08(Model model, User user,@RequestParam("name")String name) throws Exception {

        StringBuffer sb = new StringBuffer();
        sb.append(user);
        sb.append(name);
        model.addAttribute("msg",sb.toString());
        return "hello";
    }


    @RequestMapping(value = "show09")
    public String text09(UsersVO users, Model model) throws Exception {

        List<User> userList = toUserList();
        model.addAttribute("userList",userList);
        return "views/users";
    }

    public List<User> toUserList(){
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setId(i+"");
            user.setAge(i);
            user.setName("蛋蛋");
            user.setUserName("方正");
            userList.add(user);
        }
        return userList;
    }


    @RequestMapping(value = "show10")
    @ResponseBody
    public List<User> text10( Model model) throws Exception {
        List<User> userList = toUserList();
        User user = new User();
        return userList;
    }

    @RequestMapping(value = "show11")
    public String text11(@RequestBody User user, Model model) throws Exception {
        model.addAttribute("msg",user);
        return "hello";
    }

    @RequestMapping(value="show12")
    public String test12(Model model, @RequestParam("file")MultipartFile file)
            throws Exception {
        if (file!=null) {
            file.transferTo(new File("f:" + file.getOriginalFilename()));
        }
        return "redirect:/success.html";
    }

}
