import java.util.concurrent.locks.ReentrantLock;

public class WaitNotifyExample {

    private static final Object LOCK = new Object();
    private static boolean ready = false;







    public static void main (String[]args){
        Thread myThread1 = new Thread(()->{

            synchronized (LOCK){
                System.out.println("Thread is working  : "+Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                }catch (InterruptedException e){}
                ready=true;
                System.out.println("THREAD process finished : ");
                LOCK.notify();
                }

        });



        Thread  myThread2 = new Thread(()->{

            synchronized (LOCK){
                while (!ready){
                    try {
                        System.out.println("Waiting for THREAD to finish :  CurrentThread"+Thread.currentThread().getName());
                        LOCK.wait();

                    }catch (InterruptedException e){}
                }
                System.out.println("Thread Working :"+Thread.currentThread().getName());

            }


        });

        myThread1.start();
        myThread2.start();





    }



}

//EXPLANATION REFERENCE->

//Thread enters the block → lock acquired.
//
//Condition ready == false, so wait() called.
//
//Thread releases lock and sleeps.
//
//Another thread can now acquire the same lock and change ready → true.
//
//That other thread calls notify().
//
//The waiting thread wakes up, re-acquires the lock, then checks while (!ready) again.
//
//Condition is now true → proceeds.
