import java.sql.SQLOutput;
import java.util.concurrent.locks.ReentrantLock;



    public class ReentrantLockExample{




        private int counter = 0;
        private final ReentrantLock myLock = new ReentrantLock();

        public void increment() {
            myLock.lock();
            try {
                counter++;
                System.out.println("For current Thread :" + Thread.currentThread().getName() + "Counter  :" + counter);
            } finally {  // finally block guarantees that the lock would open even if some exception ocuurs .
                myLock.unlock();
            }
        }


        public static void main (String [] args ){
            ReentrantLockExample myLocking = new ReentrantLockExample();

            Thread myThread1 = new Thread(()->
            {

                for (int i = 0 ; i<5;i++){
                    myLocking.increment();
                }
                System.out.println("Working :"+Thread.currentThread().getName());
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }


            },"Thread1");



            Thread myThread2 = new Thread(()->
            {
                for (int j = 0 ; j<5;j++){
                    myLocking.increment();
                }
                System.out.println("Working :"+Thread.currentThread().getName());

                try{
                    Thread.sleep(1000);
            }catch(InterruptedException e){}


            },"Thread2");


            myThread1.start();
            myThread2.start();

        }


    }
