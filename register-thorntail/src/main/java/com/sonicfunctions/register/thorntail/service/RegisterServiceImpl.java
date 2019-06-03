package com.sonicfunctions.register.thorntail.service;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.sonicfunctions.register.thorntail.domain.Function;
import com.sonicfunctions.register.thorntail.repository.FunctionRepository;

import org.jnosql.artemis.Database;
import org.jnosql.artemis.DatabaseType;

/**
 * RegisterServiceImpl
 */
public class RegisterServiceImpl implements RegisterService {

    @Inject
    @Database(DatabaseType.DOCUMENT)
    private FunctionRepository repository;

    @Override
    public String saveFunction(@NotNull @Valid Function function) {
        function = repository.save(function);
        return String.valueOf(function.getId());
    }

    @Override
    public Function getFunctionByName(@NotNull String name) {
        return repository.findByName(name);
    }

}