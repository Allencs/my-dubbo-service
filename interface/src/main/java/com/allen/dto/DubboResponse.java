package com.allen.dto;

import java.io.Serializable;

/**
 * @Author: allen
 * @Date: 2022/2/28 2:45 下午
 * @Description:
 */
public class DubboResponse implements Serializable {
    String code;
    Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DubboResponse{" +
                "code='" + code + '\'' +
                ", data=" + data +
                '}';
    }
}
