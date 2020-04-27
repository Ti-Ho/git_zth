package com.zth.how2java.entity;

import java.io.Serializable;

/**
 * (Order_)实体类
 *
 * @author kai
 * @since 2020-04-23 01:52:27
 */
public class Order_ implements Serializable {
    private static final long serialVersionUID = 636390789303494218L;
    
    private Integer id;
    
    private String code;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}