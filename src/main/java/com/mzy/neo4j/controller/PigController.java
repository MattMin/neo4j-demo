package com.mzy.neo4j.controller;

import com.alibaba.fastjson.JSONObject;
import com.mzy.neo4j.entity.Pig;
import com.mzy.neo4j.repository.FSRelaRepository;
import com.mzy.neo4j.repository.PigRepository;
import com.mzy.neo4j.service.PigNeo4jService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author mzyupc@163.com
 * @date 2020/3/5 13:46
 */
@RestController
public class PigController {
    @Autowired
    private PigNeo4jService service;

    @Autowired
    private PigRepository repository;

    @GetMapping("getAll")
    public String getAll(){
        List<Pig> pigsByRela = service.getAllPigs();
        return JSONObject.toJSONString(pigsByRela);
    }

    @GetMapping("name/{name}")
    public String getByName(@PathVariable String name){
        return JSONObject.toJSONString(repository.findByName(name));
    }

    @GetMapping("getAllFSRela")
    public String getAllFSRela(){
        return JSONObject.toJSONString(service.getAllFSRela());
    }

    @GetMapping("getPeiqiBro")
    public String getPeiqiBro(){
        return JSONObject.toJSONString(repository.findPeiqiBro());
    }

    @GetMapping("sessionQuery")
    public String SessionQuery(){
        service.SessionQuery();
        return "ok";
    }

    @GetMapping("sessionQuery2")
    public String SessionQuery2(){
        service.SessionQuery2();
        return "ok";
    }

    @GetMapping("sessionQuery3")
    public String SessionQuery3(){
        return "" + service.SessionQuery3();
    }
}
