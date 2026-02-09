package ru.perm.v.dagger_rest;

import com.fasterxml.jackson.core.util.JacksonFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import dagger.Component;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import ru.perm.v.dagger_rest.hello.HelloWorld;
import ru.perm.v.dagger_rest.modules.HelloWorldModule;

import java.net.URI;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("=========================================");
        // If compilation fails, see README.md
        HelloWorldComponent daggerGeneratedComponent = DaggerMain_HelloWorldComponent.builder().build();

        HelloWorld helloWorld = daggerGeneratedComponent.helloWorld();
        System.out.println(helloWorld.getMessage());

        System.out.println("============Run REST API=================");
        final ResourceConfig config = new ResourceConfig();
        config.packages("ru.perm.v.dagger_rest");
        config.register(JacksonFeature.class);
        config.register(new AbstractBinder() {
            @Override
            protected void configure() {
                ObjectMapper mapper = new ObjectMapper();
//TODO: JavaTimeModule
//                mapper.registerModule(new JavaTimeModule());
                mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
                bind(mapper).to(ObjectMapper.class);
            }
        });

        // run REST API
        final HttpServer server = GrizzlyHttpServerFactory
                .createHttpServer(URI.create("http://localhost:8080/api/"), config);

        try {
            server.start();
            System.out.println("Jersey app started at http://localhost:8080/api/");
            System.out.println("Press CTRL+C to stop the server...");
            Thread.currentThread().join();
        } catch (Exception e) {
            System.err.println("Error starting server: " + e.getMessage());
        } finally {
            server.shutdownNow();
        }
    }

    // What do we need?
    @Component(modules = HelloWorldModule.class)
    interface HelloWorldComponent {
        HelloWorld helloWorld();
    }
}
