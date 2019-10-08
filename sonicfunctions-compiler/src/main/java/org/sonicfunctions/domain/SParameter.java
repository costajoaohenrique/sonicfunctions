package org.sonicfunctions.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Function
 */
@Entity
public class SParameter extends PanacheEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long idParameter;

    private String name;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "idFunction", insertable = true, updatable = true),
        @JoinColumn(name = "idParameter", insertable = true, updatable = true)
      })
    private SFunction function;

    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type {
        INT, STRING, DECIMAL, BOOLEAN;
    }

    public SFunction getFunction() {
        return function;
    }

    public Long getIdParameter() {
        return idParameter;
    }

    public void setIdParameter(Long idParameter) {
        this.idParameter = idParameter;
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