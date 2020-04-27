package com.zth.how2java.dao;

import com.zth.how2java.entity.Order_;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Order_)表数据库访问层
 *
 * @author kai
 * @since 2020-04-23 01:52:32
 */
public interface Order_Dao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Order_ queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Order_> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param order_ 实例对象
     * @return 对象列表
     */
    List<Order_> queryAll(Order_ order_);

    /**
     * 新增数据
     *
     * @param order_ 实例对象
     * @return 影响行数
     */
    int insert(Order_ order_);

    /**
     * 修改数据
     *
     * @param order_ 实例对象
     * @return 影响行数
     */
    int update(Order_ order_);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}