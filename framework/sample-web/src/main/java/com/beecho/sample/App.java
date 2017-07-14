package com.beecho.sample;

import com.beecho.sample.controller.HomeController;
import com.beechoframework.web.Beecho;
import com.beechoframework.web.Bootstrap;

/**
 * Created by Administrator on 2017/7/14.
 */
public class App implements Bootstrap {
    public void init(Beecho beecho) {
        HomeController home = new HomeController();
        beecho.addRoute("/", "index", home);
    }
}
