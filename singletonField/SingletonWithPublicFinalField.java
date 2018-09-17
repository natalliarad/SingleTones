package singletons.singletonField;

/**
 * This class is implemented a singleton. This approach is based on keeping the constructor private
 * and exporting a public static final field to provide access to the sole instance. The private
 * constructor is called only once, to initialize the public static final field
 * SingletonWithPublicFinalField.INSTANCE.
 *
 * <p>
 * Advantages:
 * <ul>
 * <li> 1.  It is clear that the class is a singleton: the public static field is final,
 * so it will always contain the same object reference. </li>
 * <li> 2.  It’s simpler than adding a public static factory method</li>
 * </ul>
 * <p>
 * Issue 1 : a privileged client can invoke the private constructor reflectively with the aid
 * of the AccessibleObject.setAccessible method. This problem occurs in the following class
 * {@link SingletonWithPublicFinalFieldTester}: with the help of reflection it was possible to create
 * two entity entities (the hash code of the created objects differs).The solution is described in class
 * {@link SingletonWithPublicFinalFieldWithException}.
 * <p>
 * Issue 2: Instance is created even though client application might not be using it.
 * If Singleton class creates a database connection or a socket. This may cause the memory leak problem.
 * The solution is to create the new instance of the class, when needed.
 * <p>
 * This approach is described in Joshua Bloch's book "Effective Java" (p.17).
 */
public class SingletonWithPublicFinalField {

    public static final SingletonWithPublicFinalField INSTANCE = new SingletonWithPublicFinalField();

    private SingletonWithPublicFinalField() {

    }
}
