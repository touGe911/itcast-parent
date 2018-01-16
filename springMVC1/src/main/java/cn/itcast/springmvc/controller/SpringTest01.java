package cn.itcast.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: touGe
 * @Date: 2018-01-11
 * @Time: 20:49
 */
@Controller
@RequestMapping("shabi")
public class SpringTest01 {
    public ModelAndView show1(){
        ModelAndView mv = new ModelAndView();

        return mv;
    }


}
