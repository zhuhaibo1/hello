package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import com.itheima.dao.IOrdersDao;
import com.itheima.domain.Orders;
import com.itheima.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service()
@Transactional
public class IOrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

//    根据id值查询订单详情
    @Override
    public Orders findById(String id) throws Exception {
        Orders orders = ordersDao.findByIdOrders(id);
        System.out.println("aaa");
        return orders;
    }

//    查询所有订单
    @Override
    public List<Orders> findAllOrders(int page,int size) throws Exception {
        //参数pageNum是页码值，pageSize代表的是每页显示的条数，语句必须写在读取数据需要分页语句之前
        PageHelper.startPage(page,size);
        List <Orders> orders = ordersDao.findAllOrders();
        return orders;
    }
}
