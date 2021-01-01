package com.smart.framwork.demo.controller;

import com.smart.framwork.demo.controller.frontend.MainPageController;
import com.smart.framwork.demo.controller.superadmin.HeadLineOperationController;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1、拦截所有请求
 * 2、解析所有请求
 * 3、派发给对应的Controller里面的方法进行处理
 *
 * @author yangqian
 * @date 2021/1/1
 */
@Slf4j
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 1、获取当前请求路径
        System.out.println("request path is : " + req.getServletPath());
        // 获取当前请求的方法
        System.out.println("request method is : " + req.getMethod());
        // 2、请求转发
        if (req.getServletPath().equals("/fronted/getnaminpageinfo") && req.getMethod().equals("GET")) {
            new MainPageController().getMainPageInfo(req, resp);
        } else if (req.getServletPath().equals("/superadmin/addheadline") && req.getMethod().equals("GET")) {
            new HeadLineOperationController().addHeadLine(req, resp);
        }
    }
}
