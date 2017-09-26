package com.hldfxh.smartframework.helper;

import com.hldfxh.smartframework.annotation.Action;
import com.hldfxh.smartframework.bean.Handler;
import com.hldfxh.smartframework.bean.Request;
import com.hldfxh.smartframework.utils.CollectionUtil;
import com.sun.deploy.util.ArrayUtil;

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
                if (ArrayUtil.isNotEmpty(methods)) {
                    for (Method method : methods) {
                        if (method.isAnnotationPresent(Action.class)) {
                            Action annotation = method.getAnnotation(Action.class);
                            String mapping = annotation.value();
                            //@Action("post:/customer_create")
                            if (mapping.matches("\\w+:/\\w*")) {
                                String[] array = mapping.split(":");
                                if (ArrayUtil.isNotEmpty(array) && array.length == 2) {
                                    String requestMethod = array[0];
                                    String requestPath = array[1];
                                    Request request = new Request(requestMethod,requestPath);
                                    Handler handler = new Handler(cls,method);
                                    ACTION_MAP.put(request,handler);
                                }
                            }
                        }
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
