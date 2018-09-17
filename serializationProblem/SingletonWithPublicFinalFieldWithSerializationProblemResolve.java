package singletons.serializationProblem;

import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * This class is implemented a singleton. This approach is based on keeping the constructor private
 * and exporting a public static final field to provide access to the sole instance.
 * <p>
 * To resolve issue of implementing Serializable ({@link SingletonWithPublicFinalFieldWithSerializationProblem}),
 * the method {@link #readResolve()} is implemented to substitute another instance for the one
 * created by {@link ObjectInputStream#readObject()}. After the moment of the deserialization this method is
 * invoked on the newly created object. This method ignores the deserialized object, returning
 * the instance that was created when the class was initialized. Therefore, all instance fields should
 * be declared transient to avoid a possible rewrite this method in the subclass.
 * <p>
 * This approach is described in Joshua Bloch's book "Effective Java" (p.359).
 */
public class SingletonWithPublicFinalFieldWithSerializationProblemResolve implements Serializable {

    public static final SingletonWithPublicFinalFieldWithSerializationProblemResolve INSTANCE = new SingletonWithPublicFinalFieldWithSerializationProblemResolve();

    private SingletonWithPublicFinalFieldWithSerializationProblemResolve() {

    }

    private Object readResolve() {
        return INSTANCE;
    }
}
