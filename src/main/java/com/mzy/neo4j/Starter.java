package com.mzy.neo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

/**
 * @author mzyupc@163.com
 * @date 2020/3/5 14:51‚
 */
@SpringBootApplication
// EnableNeo4jRepositories 可以指定neo4jRepository 的包路径
@EnableNeo4jRepositories
public class Starter {
    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);
    }
}
