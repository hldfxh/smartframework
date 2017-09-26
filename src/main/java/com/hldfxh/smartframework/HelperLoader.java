package com.hldfxh.smartframework;

import com.hldfxh.smartframework.helper.BeanHelper;
import com.hldfxh.smartframework.helper.ClassHelper;
import com.hldfxh.smartframework.helper.ControllerHelper;
import com.hldfxh.smartframework.helper.IocHelper;
import com.hldfxh.smartframework.utils.ClassUtil;

/**
 * Created by fanxuehui on 2017/9/24.
 */
public final class HelperLoader {

    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName());
        }
    }
}
