package com.itheima.service;

import com.itheima.domain.Orders;

import java.util.List;

public interface IOrdersService {

//      查询所有订单
      Orders findById(String id) throws Exception;

//      根据id值查询订单详情
      List<Orders> findAllOrders(int page,int siza) throws Exception;
}
