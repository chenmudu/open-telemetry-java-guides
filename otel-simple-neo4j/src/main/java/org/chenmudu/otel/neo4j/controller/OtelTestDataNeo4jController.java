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
package org.chenmudu.otel.neo4j.controller;

import lombok.extern.slf4j.Slf4j;
import org.chenmudu.otel.neo4j.entity.DeptEntity;
import org.chenmudu.otel.neo4j.repository.DeptRepository;
import org.chenmudu.otel.neo4j.repository.RelationShipRepository;
import org.chenmudu.otel.neo4j.ship.RelationShip;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Optional;

/**
 *
 * @author chenmudu@gmail.com   2021/1/15 23:19
 */
@Slf4j
@RestController
public class OtelTestDataNeo4jController {

    @Resource
    private DeptRepository         deptRepository;
    @Resource
    private RelationShipRepository relationShipRepository;

    @GetMapping("/dataNeo4j")
    public String dataNeo4j() {
        DeptEntity ceo = DeptEntity.builder().name("CEO").build();
        DeptEntity tech = DeptEntity.builder().name("Tech").build();
        DeptEntity design = DeptEntity.builder().name("Design").build();
        DeptEntity techChen = DeptEntity.builder().name("T_Zhang").build();
        DeptEntity techLi = DeptEntity.builder().name("T_Li").build();
        DeptEntity designWang = DeptEntity.builder().name("D_Wang").build();

        deptRepository.saveAll(Arrays.asList(ceo, tech, design, techChen, techLi, designWang));
        log.info("OtelTestDataNeo4jController dataNeo4j save all node!");

        RelationShip ceo2Tech = RelationShip.builder().startNode(ceo).endNode(tech).build();
        RelationShip ceo2Design = RelationShip.builder().startNode(ceo).endNode(design).build();

        RelationShip tech2Chen = RelationShip.builder().startNode(tech).endNode(techChen).build();
        RelationShip tech2Li = RelationShip.builder().startNode(tech).endNode(techLi).build();

        RelationShip design2Wang = RelationShip.builder().startNode(design).endNode(designWang)
            .build();
        relationShipRepository.saveAll(Arrays.asList(ceo2Tech, ceo2Design, tech2Chen, tech2Li,
            design2Wang));

        Optional<RelationShip> shipOptional = relationShipRepository.findById(tech2Chen.getId());

        return shipOptional.orElse(null).toString();
    }

}
