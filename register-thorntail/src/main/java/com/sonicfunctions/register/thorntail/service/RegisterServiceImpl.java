package com.sonicfunctions.register.thorntail.service;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.sonicfunctions.register.thorntail.domain.Function;
import com.sonicfunctions.register.thorntail.repository.FunctionRepository;

import org.jnosql.artemis.DatabaseQualifier;

/**
 * RegisterServiceImpl
 */
public class RegisterServiceImpl implements RegisterService {

    @Override
    public String saveFunction(@NotNull @Valid Function function) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            FunctionRepository repository = container.select(FunctionRepository.class).select(DatabaseQualifier.ofDocument()).get();
            function = repository.save(function);
            return String.valueOf(function.getId());
        }
    }

    @Override
    public Function getFunctionByName(@NotNull String name) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            FunctionRepository repository = container.select(FunctionRepository.class).select(DatabaseQualifier.ofDocument()).get();
            return repository.findByName(name);
        }
    }

    
}