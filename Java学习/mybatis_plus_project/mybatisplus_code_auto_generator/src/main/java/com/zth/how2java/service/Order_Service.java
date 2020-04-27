package com.zth.how2java.service;

import com.zth.how2java.entity.Order_;
import java.util.List;

/**
 * (Order_)表服务接口
 *
 * @author kai
 * @since 2020-04-23 01:52:33
 */
public interface Order_Service {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Order_ queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Order_> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param order_ 实例对象
     * @return 实例对象
     */
    Order_ insert(Order_ order_);

    /**
     * 修改数据
     *
     * @param order_ 实例对象
     * @return 实例对象
     */
    Order_ update(Order_ order_);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}