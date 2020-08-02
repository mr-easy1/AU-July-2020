class Singleton {
     // static variable single_instance of type Singleton 
    private  static Singleton instance=null;
    public int val;
    private Singleton() {
         // private constructor restricted to this class itself 
        val=100;
    }
    
    public static Singleton getInstance() {
         if (instance == null) {
             //thread safe
        synchronized (Singleton.class) {
            if (instance == null) {
                //dual checking
                instance = new Singleton(); }
        }
    }
        return instance;
    }
}

 class Test {
    public static void main(String args[])
    {

        Singleton x = Singleton.getInstance();
        Singleton y = Singleton.getInstance();
        Singleton z = Singleton.getInstance();

      
        //Every value will be 100
        System.out.println("String from x is " + x.val); 
        System.out.println("String from y is " + y.val);
        System.out.println("String from z is " + z.val);
        System.out.println("\n");

       x.val=200;
        //Every value will be 200
        System.out.println("String from x is " + x.val);
        System.out.println("String from y is " + y.val);
        System.out.println("String from z is " + z.val);
    }
}