package com.mzy.neo4j.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;

/**
 * @author mzyupc@163.com
 * @date 2020/3/5 15:54
 *
 * 父子关系
 */
@RelationshipEntity(type = "儿子")
@Getter
@Setter
@NoArgsConstructor
public class FSRelation {

    @Id
    @GeneratedValue
    private Long id;

    private String relaName;

    @StartNode
    private Pig father;

    @EndNode
    private Pig son;

}
