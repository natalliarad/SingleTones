package singletons.singletonFactoryMehod;

/**
 * This class is implemented a singleton. This approach is based on keeping the constructor private
 * and exporting a public static factory method to provide access to the sole instance. The private
 * constructor is called only once. All calls to {@link SingletonWithStaticFactoryMethod#getInstance()}
 * return the same object reference, and no other SingletonWithStaticFactoryMethod instance
 * will ever be created.
 * <p>
 * To prevent Singleton failure while due to reflection it had to throw a run-time exception
 * in constructor, if the constructor is already initialized and some class want to initialize it again.
 * This problem occurs in the following class {@link SingletonWithStaticFactoryMethodTester}. Via
 * different implementation this issue is closed {@link SingletonWithStaticFactoryMethodWithExceptionTester}.
 * <p>
 * Part of this approach is described in Joshua Bloch's book "Effective Java" (p.17).
 */
public class SingletonWithStaticFactoryMethodWithException {

    private static final SingletonWithStaticFactoryMethodWithException INSTANCE = new SingletonWithStaticFactoryMethodWithException();

    private SingletonWithStaticFactoryMethodWithException() {
        if (INSTANCE != null) {
            throw new RuntimeException("Use SingletonWithStaticFactoryMethodWithException.getInstance to get the single instance of this class.");
        }
    }

    public static SingletonWithStaticFactoryMethodWithException getInstance() {
        return INSTANCE;
    }
}
