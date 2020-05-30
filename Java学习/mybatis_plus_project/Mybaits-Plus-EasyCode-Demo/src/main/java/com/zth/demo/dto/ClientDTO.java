package com.zth.demo.dto;


import java.io.Serializable;
import lombok.Data;

/**
 * (Client)表实体类
 *
 * @author kai
 * @since 2020-05-20 10:35:09
 */
@Data
@SuppressWarnings("serial")
public class ClientDTO implements Serializable {
  
    
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