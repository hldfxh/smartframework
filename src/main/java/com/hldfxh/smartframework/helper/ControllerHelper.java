package com.hldfxh.smartframework.helper;

import com.hldfxh.smartframework.annotation.Action;
import com.hldfxh.smartframework.bean.Handler;
import com.hldfxh.smartframework.bean.Request;
import com.hldfxh.smartframework.utils.CollectionUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by fanxuehui on 2017/9/23.
 */
public final class ControllerHelper {

    public static final Map<Request,Handler> ACTION_MAP = new HashMap<Request,Handler>();

    static {
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if (CollectionUtil.isNotEmpty(controllerClassSet)) {
            for (Class<?> cls : controllerClassSet) {
                Method[] methods = cls.getDeclaredMethods();
                //判空
                for (Method method : methods) {
                    if (method.isAnnotationPresent(Action.class)) {
                        method.getAnnotation(Action.class);
                    }
                }
            }
        }
    }

    public static Handler getHandler(String requestMethod,String requestPath) {
        Request request = new Request(requestMethod,requestPath);
        return ACTION_MAP.get(request);
    }

}
