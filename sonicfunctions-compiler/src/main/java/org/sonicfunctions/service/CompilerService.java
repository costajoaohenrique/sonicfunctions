package org.sonicfunctions.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Engine;
import org.graalvm.polyglot.PolyglotException;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonicfunctions.domain.ResultCompiler;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

/**
 * CompilerService
 */
@ApplicationScoped
public class CompilerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompilerService.class);

    private Context context;

    private Engine engine;

    public ResultCompiler eval(String source) {
        LOGGER.info("Evaluation source");
        try {
            context.eval(Source.create("js",source));
            return ResultCompiler.ofValid();
        } catch (PolyglotException e) {
           LOGGER.error("Erro in eval source", e);
           return ResultCompiler.ofInvalid(e.getMessage());
        }
    }

    public Value evalForExecute(String source) {
        LOGGER.info("Evaluation source for execute");
        return context.eval(Source.create("js",source));
    }

    void onStart(@Observes StartupEvent ev) {
        LOGGER.info("Initializing Context and Engine");
        engine = Engine.create();
        context = Context.newBuilder().allowAllAccess(true).engine(engine).build();
        LOGGER.info("Context and Engine Initialized");
    }

    void onStop(@Observes ShutdownEvent ev) {
        if (engine != null) {
            engine.close();
        }
        if (context != null) {
            context.close();
        }
    }

    // TODO
    public static void Test(String[] args) throws java.io.IOException {
        final Context context = Context.create("js");
        String s = "name + ': ' + size";
        if (args.length == 1) {
            s = args[0];
        }
        final Value lambda = context.eval("js", "(function(name, size) { return " + s + "})");
        try (Stream<Path> paths = Files.walk(Paths.get("."))) {
            paths.filter(Files::isRegularFile).forEach((Path p) -> {
                File f = p.toFile();
                Value v = lambda.execute(f.getName(), f.length());
                System.out.println(v);
            });
        }
    }

}