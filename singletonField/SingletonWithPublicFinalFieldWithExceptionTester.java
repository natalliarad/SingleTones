package singletons.singletonField;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonWithPublicFinalFieldWithExceptionTester {
    public static void main(String[] args) {
        SingletonWithPublicFinalFieldWithException instance1 = SingletonWithPublicFinalFieldWithException.INSTANCE;
        SingletonWithPublicFinalFieldWithException instance2 = SingletonWithPublicFinalFieldWithException.INSTANCE;

        // check the hash key
        System.out.println("Instance 1 hash:" + instance1.hashCode()); //Instance 1 hash:1163157884
        System.out.println("Instance 2 hash:" + instance2.hashCode()); //Instance 2 hash:1163157884

        //Create 2nd instance using Java Reflection API.
        instance2 = null;

        try {
            Class<SingletonWithPublicFinalFieldWithException> classSingleton = SingletonWithPublicFinalFieldWithException.class;
            Constructor<SingletonWithPublicFinalFieldWithException> constructor = classSingleton.getDeclaredConstructor();
            constructor.setAccessible(true);
            instance2 = constructor.newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException ex) {
            ex.printStackTrace();
        }

        //check the hash key.
        System.out.println("Instance 1 hash:" + instance1.hashCode()); //Instance 1 hash:1163157884
        System.out.println("Instance 2 hash:" + instance2.hashCode());
        //at singletons.singletonField.SingletonWithPublicFinalFieldWithExceptionTester.main(SingletonWithPublicFinalFieldWithExceptionTester.java:22)
        //Caused by: java.lang.RuntimeException: Use SingletonWithPublicFinalFieldWithException.INSTANCE to get the single instance of this class.
    }
}
