package org.sonicfunctions.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Function
 */
@Entity
public class SFunction extends PanacheEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String sourceBody;

    private Long idUser;

    @OneToMany(mappedBy = "function",cascade = CascadeType.PERSIST)
    private List<SParameter> parameters = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Language language;

    public enum Language {
        JS, PYTHON;
    }

    public List<SParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<SParameter> parameters) {
        this.parameters = parameters;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSourceBody() {
        return sourceBody;
    }

    public void setSourceBody(String sourceBody) {
        this.sourceBody = sourceBody;
    }

    public static SFunction ofJS(String name, String sourceBody, Long idUser) {
        SFunction f = new SFunction();
        f.setName(name);
        f.setSourceBody(sourceBody);
        f.setIdUser(idUser);
        f.setLanguage(Language.JS);
        return f;
    }

    public SFunction addParam(String name, SParameter.Type type){
        SParameter param = SParameter.of(name,type);
        param.setFunction(this);
        parameters.add(param);
        return this;
    }

}