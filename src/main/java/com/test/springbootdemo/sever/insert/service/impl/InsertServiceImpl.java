package com.test.springbootdemo.sever.insert.service.impl;

import com.test.springbootdemo.sever.insert.bean.User;
import com.test.springbootdemo.sever.insert.dao.test.InsertMapper;
import com.test.springbootdemo.sever.insert.dao.test2.InsertMapper2;
import com.test.springbootdemo.sever.insert.service.InsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertServiceImpl implements InsertService{

   @Autowired
    private InsertMapper insertMapper;
    @Autowired
    private InsertMapper2 insertMapper2;

    @Override
    public void add(User user) {
        insertMapper.add(user);
    }
    @Override
    public void add2(User user) {
        insertMapper2.add(user);
    }
}
