package com.mzy.neo4j.repository;

import com.mzy.neo4j.entity.FSRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author mzyupc@163.com
 * @date 2020/3/5 15:57
 */
public interface FSRelaRepository extends Neo4jRepository<FSRelation, Long> {

}
