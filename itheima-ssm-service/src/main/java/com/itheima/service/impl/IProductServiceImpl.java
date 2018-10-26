package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.IProductDao;
import com.itheima.domain.Orders;
import com.itheima.domain.Product;
import com.itheima.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class IProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao productDao;

    /**
     *查询所有
     * @return
     * @throws Exception
     */
    @Override
    public List <Product> findAllProduct(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        List <Product> product = productDao.findAllProduct();
        return product;
    }

    /**
     * 添加产品
     * @param product
     * @throws Exception
     */
    @Override
    public void saveProduct(Product product) throws Exception {
        productDao.saveProduct(product);
    }
}
