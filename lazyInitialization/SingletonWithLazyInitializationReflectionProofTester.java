package singletons.lazyInitialization;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonWithLazyInitializationReflectionProofTester {
    public static void main(String[] args) {
        SingletonWithLazyInitializationReflectionProof instance1 = SingletonWithLazyInitializationReflectionProof.getInstance();
        SingletonWithLazyInitializationReflectionProof instance2 = SingletonWithLazyInitializationReflectionProof.getInstance();

        System.out.println("Instance 1 hash:" + instance1.hashCode()); //Instance 1 hash:1163157884
        System.out.println("Instance 2 hash:" + instance2.hashCode()); //Instance 2 hash:1163157884

        instance2 = null;
        try {
            Class<SingletonWithLazyInitializationReflectionProof> clazz = SingletonWithLazyInitializationReflectionProof.class;
            Constructor<SingletonWithLazyInitializationReflectionProof> cons = clazz.getDeclaredConstructor();
            cons.setAccessible(true);
            instance2 = cons.newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        System.out.println("Instance 1 hash:" + instance1.hashCode()); //Instance 1 hash:1163157884
        System.out.println("Instance 2 hash:" + instance2.hashCode());
        //at singletons.lazyInitialization.SingletonWithLazyInitializationReflectionProofTester.main(SingletonWithLazyInitializationReflectionProofTester.java:19)
        //Caused by: java.lang.RuntimeException: Use SingletonWithLazyInitializationReflectionProof.getInstance() method to get the single instance of this class.
    }
}
