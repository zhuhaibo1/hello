package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.ISyslogDao;
import com.itheima.domain.Syslog;
import com.itheima.service.SyslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SyslogServiceImpl implements SyslogService {

    @Autowired
    private ISyslogDao syslogDao;

//    保存日志信息到数据库
    @Override
    public void save(Syslog syslog) throws Exception {
        syslogDao.save(syslog);
    }

//    查询所有日志信息
    @Override
    public List<Syslog> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        List<Syslog> list=syslogDao.findAll();
        return list;
    }
}
