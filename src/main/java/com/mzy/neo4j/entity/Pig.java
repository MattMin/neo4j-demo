package com.mzy.neo4j.entity;

import lombok.*;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author mzyupc@163.com
 * @date 2020/3/5 11:33
 *
 * 对应库中的Label
 */
@NodeEntity
@NoArgsConstructor
@Getter
@Setter
public class Pig {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer age;
}
