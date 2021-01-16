/**
 * MIT License
 * <p>
 * Copyright (c) 2020 chenmudu (陈晨)
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 */
package org.chenmudu.otel.neo4j.ship;

import lombok.Builder;
import lombok.Data;
import org.chenmudu.otel.neo4j.entity.DeptEntity;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 *
 * @author chenmudu@gmail.com   2021/1/15 23:34
 */
@RelationshipEntity(type = "relationShip")
@Data
@Builder
public class RelationShip {

    @Id
    @GeneratedValue
    private Long       id;

    @StartNode
    private DeptEntity startNode; // parent node.

    @EndNode
    private DeptEntity endNode;  //end node.
}
