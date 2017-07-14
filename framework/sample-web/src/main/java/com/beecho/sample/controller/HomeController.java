package com.beecho.sample.controller;

import com.beechoframework.web.wrapper.Request;
import com.beechoframework.web.wrapper.Response;

/**
 * Created by Administrator on 2017/7/14.
 */
public class HomeController {

    public void index(Request request, Response response) {
        request.attr("framewrok", "BeechoFramework");
        response.render("index");
    }
}
