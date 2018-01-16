package cn.itcast.springmvc.controller;

import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: touGe
 * @Date: 2018-01-13
 * @Time: 17:21
 */
public class MyHandlerExceptionResolver implements HandlerExceptionResolver{


    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        ModelAndView modelAndView = new ModelAndView();

        if (ex instanceof MaxUploadSizeExceededException){
            modelAndView.setViewName("hello");
            modelAndView.addObject("msg","你上传的文件太大，请重新上传");
        }
        return modelAndView;
    }
}
