package cn.itcast.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: touGe
 * @Date: 2018-01-11
 * @Time: 16:30
 */
@Controller
@RequestMapping(value = "views")
public class HelloController{

    @RequestMapping(value = "hello/{userName}/{password}")
    public ModelAndView handleRequest(@PathVariable("userName")String userName,@PathVariable("password")int password) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg",userName+"/"+password);
        return mv;
    }

    @RequestMapping(value = "show1",method = RequestMethod.POST)
    public ModelAndView show1() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg","post请求");
        return mv;
    }

    @RequestMapping(value="show2", method={RequestMethod.POST, RequestMethod.DELETE})
    public ModelAndView show2() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg","多种请求");
        return mv;
    }
    @RequestMapping(value="show3", params = "!itcast",method = RequestMethod.POST)
    public ModelAndView show3() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg","多种请求");
        return mv;
    }

    @RequestMapping(value = "show5")
    public String text01(){

        return "hello";
    }

    @RequestMapping("show6")
    public String text02(Model model){
        model.addAttribute("msg","shabi");

        return "hello";
    }

    @GetMapping(value = "show7")
    public String text03(Model model){
        model.addAttribute("msg","shabi");

        return "hello";
    }

    @PostMapping(value = "show8")
    public String text04(Model model){
        model.addAttribute("msg","shabi");

        return "hello";
    }

    @PostMapping(value = "show9")
    public String text05(Model model){
        model.addAttribute("msg","shabi");

        return "hello";
    }
}
