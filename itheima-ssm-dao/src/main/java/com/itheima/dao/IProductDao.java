package com.itheima.dao;

import com.itheima.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductDao {
//    findAllOrders
    @Select("select * from product where id=#{id}")
    Product findById(String id) throws Exception;

//    查询所有产品
    @Select("select * from product")
    List<Product> findAllProduct() throws Exception;

//    添加产品
    @Insert("insert into product" +
            "(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) " +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void saveProduct(Product product) ;
}
