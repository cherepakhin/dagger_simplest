package ru.perm.v.dagger_rest.modules;

import dagger.Module;
import dagger.Provides;
import ru.perm.v.dagger_rest.hello.HelloWorld;

@Module // How do we make what is needed? (Except classes with @Inject constructor)
public class HelloWorldModule {
    @Provides
    HelloWorld provideHelloWorld() {
        return () -> "Hello World";
    }
}
