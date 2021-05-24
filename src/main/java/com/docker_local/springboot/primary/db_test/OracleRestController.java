package com.docker_local.springboot.primary.db_test;

import java.util.List;
import java.util.Map;

import com.docker_local.springboot.primary.oracle.OracleTestService;
import com.docker_local.springboot.primary.oracle.dao.OracleContentDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(path = "/oracle")
public class OracleRestController {
    
    @Autowired
    private OracleTestService service;
    
    @GetMapping("/all")
    public List<OracleContentDao> getAll(){
        return service.getAll();
    }

    @PostMapping("/add")
    public String add(@RequestBody Map<String, String> map){
        System.out.println("content:" +map.get("content"));
        service.add(map.get("content"));
        return "success";
    }
    
}
