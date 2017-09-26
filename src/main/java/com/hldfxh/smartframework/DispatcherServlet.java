package com.hldfxh.smartframework;

import com.hldfxh.smartframework.annotation.Controller;
import com.hldfxh.smartframework.bean.Handler;
import com.hldfxh.smartframework.helper.BeanHelper;
import com.hldfxh.smartframework.helper.ClassHelper;
import com.hldfxh.smartframework.helper.ControllerHelper;
import com.hldfxh.smartframework.utils.ReflectionUtil;
import org.apache.commons.collections.map.HashedMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fanxuehui on 2017/9/24.
 */
public class DispatcherServlet extends HttpServlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        HelperLoader.init();

        ServletContext servletContext = servletConfig.getServletContext();

        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
        
        //todo
    }
    
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,IOException {
        String requestMethod = request.getMethod().toLowerCase();
        String requestPath = request.getPathInfo();

        Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);
        if (handler != null) {
            Class<?> controllerClass = handler.getControllerClass();
            Object controllerInstance = BeanHelper.getBean(controllerClass);

            Map<String, Object> paramMap = new HashMap();
            Enumeration<String> parameterNames = request.getParameterNames();//TODO 实现在哪里
            while (parameterNames.hasMoreElements()) {
                String paramName = parameterNames.nextElement();
                String paramValue = request.getParameter(paramName);
                paramMap.put(paramName,paramValue);
            }
            //todo 拼装参数 & =
            //invoke到handler的方法  --> result
            //result类型  View

        }

    }
    
}
