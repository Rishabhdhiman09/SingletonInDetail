package clone;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;


public class CloneApp {
    public static void main(String[] args)
            throws CloneNotSupportedException, InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, FileNotFoundException, IOException, ClassNotFoundException {


        CloneViolation instance1 = CloneViolation.getInstance();
        CloneViolation instance2 = (CloneViolation) instance1.clone();


        // These two print different hashCodes. Wierd!. To prevent it from clone use clone() method in CloneViolation class
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());



    }
}
