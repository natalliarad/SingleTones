package singletons.singletonField;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonWithPublicFinalFieldTester {

    public static void main(String[] args) {
        SingletonWithPublicFinalField instance1 = SingletonWithPublicFinalField.INSTANCE;
        SingletonWithPublicFinalField instance2 = SingletonWithPublicFinalField.INSTANCE;

        // check the hash key
        System.out.println("Instance 1 hash:" + instance1.hashCode()); //Instance 1 hash:1163157884
        System.out.println("Instance 2 hash:" + instance2.hashCode()); //Instance 2 hash:1163157884

        //Create 2nd instance using Java Reflection API.
        instance2 = null;

        try {
            Class<SingletonWithPublicFinalField> classSingleton = SingletonWithPublicFinalField.class;
            Constructor<SingletonWithPublicFinalField> constructor = classSingleton.getDeclaredConstructor();
            constructor.setAccessible(true);
            instance2 = constructor.newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException ex) {
            ex.printStackTrace();
        }

        //check the hash key.
        System.out.println("Instance 1 hash:" + instance1.hashCode()); //Instance 1 hash:1163157884
        System.out.println("Instance 2 hash:" + instance2.hashCode()); //Instance 2 hash:1956725890
    }
}
