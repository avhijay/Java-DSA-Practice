import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueExample {


    public static void main (String[]args) throws  InterruptedException{

        ConcurrentLinkedQueue<String>queue = new ConcurrentLinkedQueue<>();


        Runnable logger =()->{
            String logName = Thread.currentThread().getName();

            for(int i =0 ; i<=5;i++){
                String logs = logName+": "+i;
                queue.offer(logs); // for adding  in the queue and its non-blocking , never waits
                System.out.println(logName+"Generated: "+logs);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted : "+Thread.currentThread().getName());
                }


            }
        };


        Runnable user =()->{
            String userName = Thread.currentThread().getName();
            while (true){
                String logs = queue.poll(); // .poll()  remove and return head of the queue and if its empty , null is returned
                if (logs!=null){
                    System.out.println(userName + "Accepted: "+logs);
                }else{
                    if (Thread.activeCount()<=4){
                        break;
                    }
                }
            }


        };

 // each logger produces 6 logs , so by assigning 5 threads to that logger -> 30 logs generated
        Thread l1=new Thread(logger, "Log-1");
        Thread l2=new Thread(logger, "Log-2");
        Thread l3=new Thread(logger, "Log-3");
        Thread l4=new Thread(logger, "Log-4");
        Thread l5=new Thread(logger, "Log-5");



        Thread u1=new Thread(user,"User-1");
        Thread u2=new Thread(user,"User-2");
        Thread u3=new Thread(user,"User-3");



        l1.start();
        l2.start();
        l3.start();
        l4.start();
        l5.start();
        u1.start();
        u2.start();
        u3.start();

        l1.join();
        l2.join();
        l3.join();
        l4.join();

        l5.join();


        Thread.sleep(3000);
        System.out.println("Threads finished , current queue size = :"+queue.size());

    }


}
