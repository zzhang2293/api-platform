package com.yupi.project.model.dto.interfaceinfo;


import lombok.Data;

import java.io.Serializable;

/**
 * 创建请求
 *
 * @TableName product
 */
@Data
public class InterfaceInfoAddRequest implements Serializable {
    /**
     * 用户名
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 借口地址
     */
    private String url;

    /**
     * 请求头
     */
    private String requestHeader;

    /**
     * 相应头
     */
    private String responseHeader;

    /**
     * 请求参数
     */
    private String requestParams;


    /**
     * 请求类型
     */
    private String method;

}