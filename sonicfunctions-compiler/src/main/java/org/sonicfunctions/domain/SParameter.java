package org.sonicfunctions.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class SParameter extends PanacheEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    @ManyToOne
    private SFunction function;

    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type {
        INT, STRING, DECIMAL, BOOLEAN;
    }

    public SFunction getFunction() {
        return function;
    }

    public void setFunction(SFunction function) {
        this.function = function;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public static SParameter of(String name, Type type) {
        SParameter sp = new SParameter();
        sp.setName(name);
        sp.setType(type);
        return sp;
    }

}