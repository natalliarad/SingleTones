package singletons.singletonFactoryMehod;

/**
 * This class is implemented a singleton. This approach is based on keeping the constructor private
 * and exporting a public static factory method to provide access to the sole instance. The private
 * constructor is called only once. All calls to {@link SingletonWithStaticFactoryMethod#getInstance()}
 * return the same object reference, and no other SingletonWithStaticFactoryMethod instance
 * will ever be created.
 * <p>
 * Advantages:
 * <ul>
 * <li> 1.  It gives the flexibility whether the class is a singleton without changing its API.
 * The factory method returns the sole instance, but it could be modified (f.e. to return a separate
 * instance for each thread that invokes it.</li>
 * <li> 2.  A generic singleton factory can be written if application requires it.</li>
 * <li> 3.  A method reference can be used as a supplier, for example {@link SingletonWithStaticFactoryMethod::instance}
 * is a Supplier<SingletonWithStaticFactoryMethod>.</li>
 * </ul>
 * <p>
 * Issue 1: a privileged client can invoke the private constructor reflectively with the aid
 * of the AccessibleObject.setAccessible method. This problem occurs in the following class
 * {@link SingletonWithStaticFactoryMethodTester}: with the help of reflection it was possible to create
 * two entity entities (the hash code of the created objects differs).The solution is described in class
 * {@link SingletonWithStaticFactoryMethodWithException}.
 * <p>
 * Issue 2: Instance is created even though client application might not be using it.
 * If Singleton class creates a database connection or a socket. This may cause the memory leak problem.
 * The solution is to create the new instance of the class, when needed.
 * <p>
 * This approach is described in Joshua Bloch's book "Effective Java" (p.17).
 */
class SingletonWithStaticFactoryMethod {

    private static final SingletonWithStaticFactoryMethod INSTANCE = new SingletonWithStaticFactoryMethod();

    private SingletonWithStaticFactoryMethod() {

    }

    public static SingletonWithStaticFactoryMethod getInstance() {
        return INSTANCE;
    }
}
