package com.sonicfunctions.register.thorntail.repository;

import java.util.List;

import com.sonicfunctions.register.thorntail.domain.Function;

import org.jnosql.artemis.Repository;

/**
 * FunctionRepository
 */
public interface FunctionRepository extends Repository<Function, Long> {

    List<Function> findByName(String name);

}