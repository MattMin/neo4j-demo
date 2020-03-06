package com.mzy.neo4j.repository;

import com.mzy.neo4j.entity.Pig;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

/**
 * @author mzyupc@163.com
 * @date 2020/3/5 12:07
 */
public interface PigRepository extends Neo4jRepository<Pig, Long> {
    List<Pig> findByName(String name);

    @Query("match (p:Pig{name:'佩奇'})-[:弟弟]-(p1) return p1")
    List<Pig> findPeiqiBro();


}
