package com.sonicfunctions.register.thorntail.config;

import java.util.Collections;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.sonicfunctions.register.thorntail.domain.Function;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jnosql.diana.api.Settings;
import org.jnosql.diana.api.document.DocumentCollectionManagerFactory;
import org.jnosql.diana.api.document.DocumentConfiguration;
import org.jnosql.diana.mongodb.document.MongoDBDocumentConfiguration;

/**
 * DocumentCollectionManagerProducer
 */
@ApplicationScoped
public class DocumentCollectionManagerProducer {

    @Inject
    @ConfigProperty(name = "database.collections")
    private String collections;

    @Inject
    @ConfigProperty(name = "database.key")
    private String key;

    @Inject
    @ConfigProperty(name = "database.name")
    private String nameDatabase;

    private DocumentConfiguration configuration;

    private DocumentCollectionManagerFactory managerFactory;


    @PostConstruct
    public void init(){
        configuration = new MongoDBDocumentConfiguration();
        Map<String, Object> settings = Collections.singletonMap(key, nameDatabase);
        managerFactory = configuration.get(Settings.of(settings));
    }


}