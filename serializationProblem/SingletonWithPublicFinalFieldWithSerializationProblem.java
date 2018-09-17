package singletons.serializationProblem;

import java.io.Serializable;

/**
 * This class is implemented a singleton. This approach is based on keeping the constructor private
 * and exporting a public static final field to provide access to the sole instance.
 * <p>
 * Issue 1: If class {@link singletons.singletonField.SingletonWithPublicFinalField} implements Serializable,  this class would no
 * longer be a singleton.  Any readObject method (explicit or default) returns a newly created
 * instance - not the same instance that was created at class initialization time. The problem is
 * illustrated {@link SingletonWithPublicFinalFieldWithSerializationProblemTester}. The hash codes
 * of serialized and de-serialized object is not the same.
 * <p>
 * Issue 2: Instance is created even though client application might not be using it.
 * If Singleton class creates a database connection or a socket. This may cause the memory leak problem.
 * The solution is to create the new instance of the class, when needed.
 * <p>
 * This approach is described in Joshua Bloch's book "Effective Java" (p.359).
 */
public class SingletonWithPublicFinalFieldWithSerializationProblem implements Serializable {

    public static final SingletonWithPublicFinalFieldWithSerializationProblem INSTANCE = new SingletonWithPublicFinalFieldWithSerializationProblem();

    private SingletonWithPublicFinalFieldWithSerializationProblem() {

    }
}
