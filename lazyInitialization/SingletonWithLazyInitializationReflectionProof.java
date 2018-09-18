package singletons.lazyInitialization;

/**
 * This class is implemented a singleton. This approach is based on keeping the constructor private
 * and exporting a public static factory method to provide access to the sole instance. The private
 * constructor is called only once. All calls to {@link SingletonWithLazyInitializationReflectionProof#getInstance()}
 * return the same object reference, and no other SingletonWithStaticFactoryMethod instance
 * will ever be created.
 * <p>
 * To avoid an instance creation even though client application might not need it now, initialization
 * of the new instance of the class is in getInstance() method. This method will check if there is
 * any instance of that class is already existed? If yes, method will return an old instance and
 * if not then it creates a new instance of the singleton class.
 * <p>
 * To prevent Singleton failure while due to reflection it had to throw a run-time exception
 * in constructor, if the constructor is already initialized and some class want to initialize it again
 * {@link SingletonWithLazyInitializationReflectionProofTester}.
 * <p>
 * This approach is described in Joshua Bloch's book "Effective Java" (p.333, 334).
 */
public class SingletonWithLazyInitializationReflectionProof {

    private static SingletonWithLazyInitializationReflectionProof singleton;

    private SingletonWithLazyInitializationReflectionProof() {

        if (singleton != null) {
            throw new RuntimeException("Use SingletonWithLazyInitializationReflectionProof.getInstance()" +
                    " method to get the single instance of this class.");
        }
    }

    public static SingletonWithLazyInitializationReflectionProof getInstance() {
        if (singleton == null) {
            singleton = new SingletonWithLazyInitializationReflectionProof();
        }

        return singleton;
    }
}
