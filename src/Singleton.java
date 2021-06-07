public class Singleton {
    public static void main(String[] args) {

//        SingletonWay2 obj1 = SingletonWay2.getInstance();
//        SingletonWay2 obj2 = SingletonWay2.getInstance();
//        System.out.println(obj1.hashCode());
//        System.out.println(obj2.hashCode());

        // This can print different hashcodes sometime. DRAWBACK
//        Runnable r1 = () -> {
//            System.out.println(SingletonWay2.getInstance().hashCode());
//        };
//
//        Runnable r2 = () -> {
//            System.out.println(SingletonWay2.getInstance().hashCode());
//        };
//        new Thread(r1).start();
//        new Thread(r2).start();

        SingletonWay5 a = SingletonWay5.INSTANCE;
        System.out.println(a.hashCode());



    }
}


// Basic singleton example
class SingletonWay1{
    static SingletonWay1 obj1 = new SingletonWay1();

    private SingletonWay1(){

    }

    public static SingletonWay1 getInstance(){
        return obj1;
    }
}
// In above case object of class is created when the class is loaded. It is called eager instance creation




class SingletonWay2{
    static SingletonWay2 obj1;

    private SingletonWay2(){

    }

    public static SingletonWay2 getInstance(){

        if (obj1 == null){
            obj1 = new SingletonWay2();
        }
        return obj1;

    }
}
// Example of lazy instance creation. instance created only when getInstance is called
// DRAWBACK:
//Right now we have only one thread i.e. 'main', what is we have two threads t1, t2 and each calling getInstance() at same time,
//if that happens, the if condition will be true for both and that result in two objects creation



class SingletonWay3{
    static SingletonWay3 obj1;

    private SingletonWay3(){

    }

    public static synchronized SingletonWay3 getInstance(){

        if (obj1 == null){
            obj1 = new SingletonWay3();
        }
        return obj1;

    }
}

// Above code will create just single instance irrespective of number of threads trying to create instance
//DRAWBACK: But suppose if getinstance() method have lot of functionality included, it might affect performance due to synchronization




//SOLUTION : {DOUBLE CHECKED LOCKING} --> It says instead of creating synchronized methods, use synchronized blocks
class SingletonWay4{
    static SingletonWay4 obj1;

    private SingletonWay4(){

    }

    public static SingletonWay4 getInstance(){

        if (obj1 == null){
            synchronized (SingletonWay4.class){
                if (obj1 == null){
                    obj1 = new SingletonWay4();
                }
            }

        }
        return obj1;

    }
}


//Using ENUM --> It is itself thread safe

enum SingletonWay5{
    INSTANCE;
}


/////////////////////////////Violating Singleton with reflection API, deserialization, clone method/////////////////////////////