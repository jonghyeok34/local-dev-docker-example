package com.docker_local.springboot.second.mysql;

import java.util.ArrayList;
import java.util.List;

import com.docker_local.springboot.primary.db_test.dto.DbContent;

import com.docker_local.springboot.second.mysql.dao.MySqlContentDao;
import com.docker_local.springboot.second.mysql.repository.MysqlContentDaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MySqlTestService {

    @Autowired
    private MysqlContentDaoRepository repo;


    public void add(String content) {
        
        MySqlContentDao contentDao = new MySqlContentDao();
        contentDao.setContent(content);
        repo.save(contentDao);
        
    }

    public void delete(Long id) {
        
        MySqlContentDao contentDao = repo.findById(id).get();
        repo.delete(contentDao);
        
    }
    public void update(Long id, String content) {
        MySqlContentDao contentDao = repo.findById(id).get();
        contentDao.setContent(content);
        repo.save(contentDao);
        
    }
    public DbContent get(Long id) {
        MySqlContentDao contentDao = repo.findById(id).get();
        return contentDao;
    }

    public List<MySqlContentDao> getAll() {
        List<MySqlContentDao> dbContents =  new ArrayList<MySqlContentDao>();
        repo.findAll().iterator().forEachRemaining(dbContents::add);
        return dbContents;
    }
    
}
