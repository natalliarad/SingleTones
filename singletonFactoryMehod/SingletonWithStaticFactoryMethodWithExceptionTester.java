package singletons.singletonFactoryMehod;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonWithStaticFactoryMethodWithExceptionTester {

    public static void main(String[] args) {
        SingletonWithStaticFactoryMethodWithException instance1 = SingletonWithStaticFactoryMethodWithException.getInstance();
        SingletonWithStaticFactoryMethodWithException instance2 = SingletonWithStaticFactoryMethodWithException.getInstance();

        // check the hash key
        System.out.println("Instance 1 hash:" + instance1.hashCode()); //Instance 1 hash:1163157884
        System.out.println("Instance 2 hash:" + instance2.hashCode()); //Instance 2 hash:1163157884

        //Create 2nd instance using Java Reflection API.
        instance2 = null;

        try {
            Class<SingletonWithStaticFactoryMethodWithException> classSingleton = SingletonWithStaticFactoryMethodWithException.class;
            Constructor<SingletonWithStaticFactoryMethodWithException> constructor = classSingleton.getDeclaredConstructor();
            constructor.setAccessible(true);
            instance2 = constructor.newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException ex) {
            ex.printStackTrace();
        }

        //check the hash key.
        System.out.println("Instance 1 hash:" + instance1.hashCode()); //Instance 1 hash:1163157884
        System.out.println("Instance 2 hash:" + instance2.hashCode());
        //at singletons.singletonFactoryMehod.SingletonWithStaticFactoryMethodWithExceptionTester.main(SingletonWithStaticFactoryMethodWithExceptionTester.java:22)
        //Caused by: java.lang.RuntimeException: Use SingletonWithStaticFactoryMethodWithException.getInstance to get the single instance of this class.
    }
}
