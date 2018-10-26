package com.itheima.service;

import com.itheima.domain.Syslog;

import java.util.List;

public interface SyslogService {
//    保存日志信息到数据库
   void save(Syslog syslog) throws Exception;

    //    查询所有日志信息
    List<Syslog> findAll(int page,int size) throws Exception;
}
