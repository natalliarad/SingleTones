package singletons.singletonThreadSafe;

import singletons.singletonFactoryMehod.SingletonWithStaticFactoryMethod;

public class SingletonThreadSafeProblemTester {

    /**
     * I could not simulate such a situation. But theoretically if this code would run many times,
     * we will see sometimes both the threads creates different instances with different hash codes.
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            SingletonWithStaticFactoryMethod instance1 = SingletonWithStaticFactoryMethod.getInstance();
            System.out.println("Instance 1 hash:" + instance1.hashCode());
        });

        Thread t2 = new Thread(() -> {
            SingletonWithStaticFactoryMethod instance2 = SingletonWithStaticFactoryMethod.getInstance();
            System.out.println("Instance 2 hash:" + instance2.hashCode());
        });

        t1.start();
        t2.start();
    }
}
