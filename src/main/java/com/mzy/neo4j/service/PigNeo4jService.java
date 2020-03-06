package com.mzy.neo4j.service;

import com.alibaba.fastjson.JSONObject;
import com.mzy.neo4j.entity.FSRelation;
import com.mzy.neo4j.entity.Pig;
import com.mzy.neo4j.repository.FSRelaRepository;
import com.mzy.neo4j.repository.PigRepository;
import org.neo4j.driver.internal.InternalPath;
import org.neo4j.driver.types.Path;
import org.neo4j.ogm.model.Result;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author mzyupc@163.com
 * @date 2020/3/5 12:09
 */
@Service
public class PigNeo4jService {
    @Autowired
    private PigRepository pigRepository;
    @Autowired
    private FSRelaRepository fsRelaRepository;
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * 使用spring data neo4j repository 进行简单查询
     *
     * @return
     */
    public List<Pig> getAllPigs(){
        Iterable<Pig> all = pigRepository.findAll();
        Iterator<Pig> iterator = all.iterator();

        List<Pig> result = new ArrayList<>();
        while(iterator.hasNext()){
            result.add(iterator.next());
        }

        return result;
    }

    /**
     * 使用spring data neo4j repository 进行简单查询
     *
     * @return
     */
    public List<FSRelation> getAllFSRela(){
        Iterable<FSRelation> all = fsRelaRepository.findAll();
        Iterator<FSRelation> iterator = all.iterator();

        List<FSRelation> result = new ArrayList<>();
        while(iterator.hasNext()){
            result.add(iterator.next());
        }

        return result;
    }

    /**
     * 查询结果为复杂结构
     */
    public void SessionQuery(){
        Session session = sessionFactory.openSession();
        String cmdSql = "MATCH n = ((a:Pig{name:'猪爷爷'})-[*..3]->(b:Pig{name:'佩奇'})) return n";
        session.beginTransaction();
        Result result = session.query(cmdSql, new HashMap<>());
        Iterator<Map<String, Object>> iterator = result.iterator();
        while (iterator.hasNext()){
            Map<String, Object> next = iterator.next();
            for (Object value : next.values()) {
                InternalPath.SelfContainedSegment[] segments = (InternalPath.SelfContainedSegment[]) value;
                for (Path.Segment segment : segments) {
                    System.out.print(String.format("(%s)-[%s]->(%s)->", segment.start().get("name"), segment.relationship().type(),  segment.end().get("name")));
                }
            }

            System.out.println();
        }

    }

    /**
     * 查询结果为简单集合
     */
    public void SessionQuery2(){
        Session session = sessionFactory.openSession();
        String cmdSql = "MATCH (a:Pig{name:'猪爸爸'})-[:儿子]->(b) return b";
        session.beginTransaction();
        Iterable<Pig> result = session.query(Pig.class, cmdSql, new HashMap<>());
        Iterator<Pig> iterator = result.iterator();
        while (iterator.hasNext()){
            Pig pig = iterator.next();
            System.out.println(JSONObject.toJSONString(pig));
        }
    }

    /**
     * 查询结果为单个对象
     */
    public Integer SessionQuery3(){
        Session session = sessionFactory.openSession();
        String cmdSql = "MATCH (a:Pig{name:'猪爸爸'})-[:儿子]->(b) return count(b)";
        session.beginTransaction();
        Integer count = session.queryForObject(Integer.class, cmdSql, new HashMap<>());
        return count;
    }

}
