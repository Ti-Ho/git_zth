package com.zth.how2java.service.impl;

import com.zth.how2java.entity.Order_;
import com.zth.how2java.dao.Order_Dao;
import com.zth.how2java.service.Order_Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Order_)表服务实现类
 *
 * @author kai
 * @since 2020-04-23 01:52:34
 */
@Service("order_Service")
public class Order_ServiceImpl implements Order_Service {
    @Resource
    private Order_Dao order_Dao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Order_ queryById(Integer id) {
        return this.order_Dao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Order_> queryAllByLimit(int offset, int limit) {
        return this.order_Dao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param order_ 实例对象
     * @return 实例对象
     */
    @Override
    public Order_ insert(Order_ order_) {
        this.order_Dao.insert(order_);
        return order_;
    }

    /**
     * 修改数据
     *
     * @param order_ 实例对象
     * @return 实例对象
     */
    @Override
    public Order_ update(Order_ order_) {
        this.order_Dao.update(order_);
        return this.queryById(order_.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.order_Dao.deleteById(id) > 0;
    }
}