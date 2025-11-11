import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueMethodsExample {

    public static void main (String []args)  throws  InterruptedException {

        BlockingQueue<String> newQueue= new LinkedBlockingQueue<>(3);


        Runnable company = ()->{
            String name = Thread.currentThread().getName();

try{
    for (int i =0; i<9;i++){
        String job = name+": Job "+i;
        if (newQueue.offer(job,200, TimeUnit.MICROSECONDS)){
            System.out.println(name+"Posted :"+job);
        }else{
            System.out.println("couldn't add to queue , still full ");
        }

        System.out.println("Capacity remaining :"+newQueue.remainingCapacity());
        Thread.sleep(600);
    }
}catch(InterruptedException e){
    System.out.println("Thread interrupted : "+e);

}


        };




        Runnable user = ()->{
            String  name = Thread.currentThread().getName();
            ArrayList<String>forSwap= new ArrayList<>();

            try {
                while (true) {

                    String job = newQueue.poll(3, TimeUnit.MICROSECONDS);
                    if (job != null) {
                        System.out.println(name + "took : " + job);


                        String peeking = newQueue.peek();
                        System.out.println("After peeking next job : " + peeking);


                        if (new Random().nextBoolean()) {
                            newQueue.drainTo(forSwap, 3);

                            if (!forSwap.isEmpty()) {
                                System.out.println(name + "Drained -> " + forSwap);
                                forSwap.clear();
                            }

                        }
                        Thread.sleep(2000);

                    } else {
                        System.out.println("Found no Job for : 3 secs");

                        if (newQueue.isEmpty()) {
                            break;
                        }

                    }
                    System.out.println("After every operation queue size   : " + newQueue.size());
                    System.out.println("After every operation queue contains :" + newQueue.remainingCapacity() + " :Items ");

                }



            }catch (InterruptedException e){
                System.out.println("Thread interrupted ");
            }


        };


        Thread c1 = new Thread(company,"Company-1");

        Thread c2 = new Thread(company,"Company-2");

        Thread u1 = new Thread(user,"User-1");
        c2.start();
        c1.start();
        u1.start();
        c1.join();
        c2.join();


        Thread.sleep(5000);
        u1.interrupt();

        System.out.println("Final queue size : "+newQueue.size());





    }




}
