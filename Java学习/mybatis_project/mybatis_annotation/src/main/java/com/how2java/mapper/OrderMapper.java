package com.how2java.mapper;

import com.how2java.pojo.Order;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Kai
 * @date 2020/4/20 10:52
 */
public interface OrderMapper {
    @Select("select * from order_")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "orderItems", javaType = List.class, column = "id",
                    many = @Many(select = "com.how2java.mapper.OrderItemMapper.listByOrder"))
    })
    public List<Order> list();
}
