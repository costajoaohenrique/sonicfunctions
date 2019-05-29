package com.sonicfunctions.register.thorntail.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.sonicfunctions.register.thorntail.domain.Function;

/**
 * RegisterService Interface
 */
public interface RegisterService {

    public void saveFunction (@NotNull @Valid Function function);
}