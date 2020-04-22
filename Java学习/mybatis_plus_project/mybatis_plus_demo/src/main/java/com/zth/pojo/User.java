package com.zth.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Kai
 * @date 2020/4/21 17:02
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    // 对应数据库的主键 （uuid、自增id、雪花算法、redis、zookeeper）
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;

    @Version//乐观锁注解
    private Integer version;

    //字段添加填充内容
    @TableField(fill = FieldFill.INSERT)  //插入时更新
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE) //插入以及更新时更新
    private Date updateTime;

    @TableLogic //逻辑删除
    private int deleted;
}
