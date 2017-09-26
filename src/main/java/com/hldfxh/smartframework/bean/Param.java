package com.hldfxh.smartframework.bean;

import java.util.Map;

/**
 * Created by fanxuehui on 2017/9/24.
 */
public class Param {

    private Map<String,Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public Long getLong(String paramName) {
        return (Long)paramMap.get(paramName);
    }

    public Map<String, Object> getParamMap() {
        return paramMap;
    }
}
