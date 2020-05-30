package com.zth.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zth.demo.dao.ClientDao;
import com.zth.demo.entity.Client;
import com.zth.demo.service.ClientService;
import org.springframework.stereotype.Service;

/**
 * (Client)表服务实现类
 *
 * @author kai
 * @since 2020-05-20 10:35:09
 */
@Service("clientService")
public class ClientServiceImpl extends ServiceImpl<ClientDao, Client> implements ClientService {

}