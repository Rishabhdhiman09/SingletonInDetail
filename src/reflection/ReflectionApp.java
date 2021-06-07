package reflection;

import clone.CloneViolation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class ReflectionApp {
    public static void main(String[] args)
            throws CloneNotSupportedException, InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, FileNotFoundException, IOException, ClassNotFoundException {


        ReflectionViolation rv = ReflectionViolation.getInstance();
        System.out.println(rv.hashCode());

        ReflectionViolation reflectionInstance = null;

        Constructor[] constructors = ReflectionViolation.class.getDeclaredConstructors();
        for (Constructor constructor: constructors){
            constructor.setAccessible(true);
            reflectionInstance = (ReflectionViolation) constructor.newInstance();


            System.out.println(reflectionInstance.hashCode());

            // Here also violating singleton pattern. To avoid this throw exeption from private constructor
        }



    }
}
