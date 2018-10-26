package com.itheima.service;

import com.itheima.domain.Product;

import java.util.List;

public interface IProductService {
    /**
     * 查询所有
     * @return
     * @throws Exception
     */
    List<Product> findAllProduct(int page,int size) throws  Exception;

//    添加订单
    void saveProduct(Product product) throws Exception;
}
