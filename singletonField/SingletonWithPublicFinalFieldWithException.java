package singletons.singletonField;

/**
 * This class is implemented a singleton. This approach is based on keeping the constructor private
 * and exporting a public static final field to provide access to the sole instance. The private
 * constructor is called only once, to initialize the public static final field
 * SingletonWithPublicFinalField.INSTANCE.
 * <p>
 * Advantages:
 * <ul>
 * <li> 1.  It is clear that the class is a singleton: the public static field is final,
 * so it will always contain the same object reference. </li>
 * <li> 2.  It’s simpler than adding a public static factory method</li>
 * </ul>
 * <p>
 * To prevent Singleton failure while due to reflection it had to throw a run-time exception
 * in constructor, if the constructor is already initialized and some class want to initialize it again.
 * This problem occurs in the following class {@link SingletonWithPublicFinalFieldTester}. Now this
 * issue is closed {@link SingletonWithPublicFinalFieldWithException}.
 * <p>
 * Part of this approach is described in Joshua Bloch's book "Effective Java" (p.17).
 */
public class SingletonWithPublicFinalFieldWithException {

    public static final SingletonWithPublicFinalFieldWithException INSTANCE = new SingletonWithPublicFinalFieldWithException();

    private SingletonWithPublicFinalFieldWithException() {
        if (INSTANCE != null) {
            throw new RuntimeException("Use SingletonWithPublicFinalFieldWithException.INSTANCE to get the single instance of this class.");
        }
    }
}
