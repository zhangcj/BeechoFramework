package com.beechoframework.web.render;

import com.beechoframework.web.Beecho;
import com.beechoframework.web.BeechoContext;
import com.beechoframework.web.Const;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by Administrator on 2017/7/14.
 */
public class JspRender implements Render {

    public void render(String view, Writer writer) {

        String viewPath = this.getViewPath(view);

        HttpServletRequest servletRequest = BeechoContext.instance().getRequest().getRaw();
        HttpServletResponse servletResponse = BeechoContext.instance().getResponse().getRaw();
        try {
            servletRequest.getRequestDispatcher(viewPath).forward(servletRequest, servletResponse);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String getViewPath(String view) {
        Beecho mario = Beecho.instance();
        String viewPrfix = mario.getConf(Const.VIEW_PREFIX_FIELD);
        String viewSuffix = mario.getConf(Const.VIEW_SUFFIX_FIELD);

        if (null == viewSuffix || viewSuffix.equals("")) {
            viewSuffix = Const.VIEW_SUFFIX;
        }
        if (null == viewPrfix || viewPrfix.equals("")) {
            viewPrfix = Const.VIEW_PREFIX;
        }
        String viewPath = viewPrfix + "/" + view;
        if (!view.endsWith(viewSuffix)) {
            viewPath += viewSuffix;
        }
        return viewPath.replaceAll("[/]+", "/");
    }
}