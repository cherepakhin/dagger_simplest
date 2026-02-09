package ru.perm.v.dagger_rest;

import dagger.Module;
import dagger.Provides;

@Module // How do we make what is needed? (Except classes with @Inject constructor)
public class HelloWorldModule {
    @Provides
    HelloWorld provideHelloWorld() {
        return () -> "Hello World";
    }
}
