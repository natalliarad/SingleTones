package singletons.serializationProblem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SingletonWithPublicFinalFieldWithSerializationProblemResolveTester {

    public static void main(String[] args) {
        String filename = "file.ser";
        SingletonWithPublicFinalFieldWithSerializationProblemResolve instance1 = SingletonWithPublicFinalFieldWithSerializationProblemResolve.INSTANCE;
        SingletonWithPublicFinalFieldWithSerializationProblemResolve instance2 = SingletonWithPublicFinalFieldWithSerializationProblemResolve.INSTANCE;

        // check the hash key
        System.out.println("Instance 1 hash:" + instance1.hashCode()); //Instance 1 hash:1163157884
        System.out.println("Instance 2 hash:" + instance2.hashCode()); //Instance 2 hash:1163157884

        // Serialization
        try {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(instance1);

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        instance2 = null;
        // Deserialization
        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            instance2 = (SingletonWithPublicFinalFieldWithSerializationProblemResolve) in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }

        //check the hash key.
        System.out.println("Instance 1 hash:" + instance1.hashCode()); //Instance 1 hash:1163157884
        System.out.println("Instance 2 hash:" + instance2.hashCode()); //Instance 2 hash:1163157884
    }
}
