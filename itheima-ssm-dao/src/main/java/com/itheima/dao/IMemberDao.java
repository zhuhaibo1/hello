package com.itheima.dao;

import com.itheima.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface IMemberDao {
//    findByIdOrders
    @Select("select * from member where id=#{id}")
    Member findById(String id) throws Exception;
}
