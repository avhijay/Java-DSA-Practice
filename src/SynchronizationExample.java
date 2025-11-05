public class SynchronizationExample {

    private int counter = 0;


    public synchronized void myMethod() {
        counter++;
    }


    public static void main(String[] args)  throws  InterruptedException{

        SynchronizationExample example = new SynchronizationExample();


        Thread t1 = new Thread(()->{
            for (int i = 0; i<100;i++) {
                example.myMethod();
            }
            System.out.println(Thread.currentThread().getName() +"Running "+"   current count :"+ example.counter);


        });



        Thread t2 = new Thread(()->{
           for(int j = 0 ; j<100; j++){
               example.myMethod();
           }

            System.out.println(Thread.currentThread().getName() +"Running "+"   current count :"+ example.counter);

        });


        t1.start();

        t2.start();
        System.out.println( Thread.currentThread().getName() + "WORKING");
        t1.join();
        t2.join();

        System.out.println("count "+ example.counter);

    }
}