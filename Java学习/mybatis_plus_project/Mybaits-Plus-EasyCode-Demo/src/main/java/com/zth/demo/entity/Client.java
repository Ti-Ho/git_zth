package com.zth.demo.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * (Client)表实体类
 *
 * @author kai
 * @since 2020-05-20 10:35:07
 */
@Data
@SuppressWarnings("serial")
public class Client extends Model<Client> {
  @TableId(type = IdType.AUTO)
    
    private String number;
    
    private String idNumber;
    
    private String time;
    
    private String type;
    
    private String department;
    
    private String phone;
    
    private String address;
    
    private String postCode;
    
    private String email;


}