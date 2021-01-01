package com.smart.framwork.demo.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author yangqian
 * @date 2021/1/1
 */
@Data
public class HeadLine {
    private Long lineId;
    private String lineName;
    private  String lineLink;
    private String lineImg;
    private Integer priority;
    private Integer enableStatus;
    private Date createTime;
    private Date lastEditTime;
}
