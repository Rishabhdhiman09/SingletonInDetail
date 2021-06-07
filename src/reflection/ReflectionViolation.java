package reflection;

import clone.MyClone;

public class ReflectionViolation extends MyClone {

    static ReflectionViolation obj1;


    private ReflectionViolation(){
        if (obj1 != null){
            throw new IllegalStateException();
        }
    }

    public static synchronized ReflectionViolation getInstance(){

        if (obj1 == null){
            obj1 = new ReflectionViolation();
        }
        return obj1;

    }
}