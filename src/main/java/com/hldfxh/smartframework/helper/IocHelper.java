package com.hldfxh.smartframework.helper;


import com.hldfxh.smartframework.annotation.Inject;
import com.hldfxh.smartframework.utils.CollectionUtil;
import com.hldfxh.smartframework.utils.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by fanxuehui on 2017/9/23.
 */
public final class IocHelper {

    /*static {
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)) {
            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                Field[] beanFields = beanClass.getDeclaredFields();
                if (CollectionUtil.isNotEmpty(beanFields)) {
                    for (Field beanField : beanFields) {
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance != null) {
                                ReflectionUtil.setField(beanInstance,beanField,beanFieldClass);
                            }
                        }
                    }
                }

            }
        }
    }*/

}
