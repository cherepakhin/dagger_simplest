package demo;

import dagger.Component;

public class Main {

    // What do we need?
    @Component(modules = HelloWorldModule.class)
    interface HelloWorldComponent {
        HelloWorld helloWorld();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("=========================================");
        // If compilation fails, see README.md
        HelloWorldComponent daggerGeneratedComponent = DaggerMain_HelloWorldComponent.builder().build();

        HelloWorld helloWorld = daggerGeneratedComponent.helloWorld();
        System.out.println(helloWorld.getMessage());
    }
}
