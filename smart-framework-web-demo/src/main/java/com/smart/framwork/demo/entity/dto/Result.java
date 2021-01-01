package com.smart.framwork.demo.entity.dto;

import lombok.Data;

/**
 * @author yangqian
 * @date 2021/1/1
 */
@Data
public class Result<T> {

    /**
     * 请求状态码
     */
    private int code;

    /**
     * 请求返回结果
     */
    private String msg;

    /**
     * 结果数据
     */
    private T data;

}
