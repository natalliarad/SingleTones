package singletons.singletonThreadSafe;

/**
 * This class is implemented a singleton. This approach is based on keeping the constructor private
 * and exporting a public static factory method to provide access to the sole instance. The private
 * constructor is called only once. All calls to
 * {@link SingletonWithStaticFactoryMethodSynchronizedGetInstance#getInstance()}
 * return the same object reference, and no other SingletonWithStaticFactoryMethod instance
 * will ever be created.
 * <p>
 * To avoid an instance creation even though client application might not need it now, initialization
 * of the new instance of the class is in getInstance() method. This method will check if there is
 * any instance of that class is already existed? If yes, method will return an old instance and
 * if not then it creates a new instance of the singleton class.
 * <p>
 * To prevent Singleton failure while due to reflection it had to throw a run-time exception
 * in constructor, if the constructor is already initialized and some class want to initialize it again.
 * <p>
 * To achieve Thread Safety, {@link SingletonWithStaticFactoryMethodSynchronizedGetInstance#getInstance()}
 * is synchronized, the second thread will have to wait until the getInstance() method is completed
 * for the first thread.
 * <p>
 * Disadvantages:
 * <ul>
 * <li>Slow performance because of locking overhead.</li>
 * <li>Unnecessary synchronization that is not required when the instance variable is already
 * initialized.</li>
 * </ul>
 * <p>
 * This approach is described in Joshua Bloch's book "Effective Java" (p.317).
 */
public class SingletonWithStaticFactoryMethodSynchronizedGetInstance {

    private static SingletonWithStaticFactoryMethodSynchronizedGetInstance singleton;

    private SingletonWithStaticFactoryMethodSynchronizedGetInstance() {
        if (singleton != null) {
            throw new RuntimeException("Use SingletonWithLazyInitializationReflectionProof.getInstance()" +
                    " method to get the single instance of this class.");
        }
    }

    public static synchronized SingletonWithStaticFactoryMethodSynchronizedGetInstance getInstance() {
        if (singleton == null) {
            singleton = new SingletonWithStaticFactoryMethodSynchronizedGetInstance();
        }

        return singleton;
    }
}
