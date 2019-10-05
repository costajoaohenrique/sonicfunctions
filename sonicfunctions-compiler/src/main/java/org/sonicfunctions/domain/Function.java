package org.sonicfunctions.domain;

/**
 * Function
 */
public class Function {

    private Long id;

    private String name;

    private String sourceBody;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}