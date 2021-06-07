package clone;

public class CloneViolation extends MyClone{

// By extending MyClone now we can clone CloneViolate class and create one more instance of the same

    static CloneViolation obj1;


////    This clone() method below prevents violating Singleton pattern
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
/////


    private CloneViolation(){

    }

    public static synchronized CloneViolation getInstance(){

        if (obj1 == null){
            obj1 = new CloneViolation();
        }
        return obj1;

    }
}