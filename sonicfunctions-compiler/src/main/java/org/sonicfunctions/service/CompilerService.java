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
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

/**
 * CompilerService
 */
@ApplicationScoped
public class CompilerService {

    private static final Logger LOGGER = LoggerFactory.getLogger("CompilerService");

    private Context context;

    private Engine engine;

    private Source sourceCode;

    public String eval() {
        LOGGER.info("Start JS script eval");
        return context.eval(sourceCode).asString();
    }

    void onStart(@Observes StartupEvent ev) {
        LOGGER.info("Iniciando JS");
        engine = Engine.create();

        sourceCode = Source.create("js",
                "olaMundoJs('Ola Mundo Js');function olaMundoJs(valor) {console.log(valor); return valor;}");

        context = Context.newBuilder().allowAllAccess(true).engine(engine).build();
        LOGGER.info("Js Inicializado");
    }

    void onStop(@Observes ShutdownEvent ev) {
        if (engine != null) {
            engine.close();
        }
    }

    //TODO
    public static void Test(String[] args) throws java.io.IOException {
		final Context context = Context.create("js");
		String s = "name + ': ' + size";
		if (args.length == 1) {
			s = args[0];
		}
		final Value lambda = context.eval("js",
            "(function(name, size) { return " + s + "})");
		try (Stream<Path> paths = Files.walk(Paths.get("."))) {
			paths.filter(Files::isRegularFile).forEach((Path p) -> {
				File f = p.toFile();
				Value v = lambda.execute(f.getName(), f.length());
				System.out.println(v);
			});
		}
	}




}