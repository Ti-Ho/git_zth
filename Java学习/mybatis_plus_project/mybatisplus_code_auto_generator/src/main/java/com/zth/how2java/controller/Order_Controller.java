package com.zth.how2java.controller;

import com.zth.how2java.entity.Order_;
import com.zth.how2java.service.Order_Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Order_)表控制层
 *
 * @author kai
 * @since 2020-04-23 01:52:35
 */
@RestController
@RequestMapping("order_")
public class Order_Controller {
    /**
     * 服务对象
     */
    @Resource
    private Order_Service order_Service;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Order_ selectOne(Integer id) {
        return this.order_Service.queryById(id);
    }

}