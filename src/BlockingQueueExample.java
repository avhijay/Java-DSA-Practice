import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueExample {

    public static void main (String []args){

        BlockingQueue<String>myQueue = new LinkedBlockingQueue<>(4);    // producer wait when the queue is full and consumer waits when the queue is empty


        Runnable logs = ()->{
            try {
                String logName = "Job  : ";
                for (int i = 0; i < 3; i++) {
                    String finalLog = logName+i;
                    myQueue.put(finalLog); //blocks if full until space is available
                    System.out.println("Job posted :"+finalLog);
                    Thread.sleep(2000);
                }
            }catch (InterruptedException e ){
                System.out.println("log interrupted");
            }




        };




        Runnable user = ()->{
            try {
                while (true) {
                    String result = myQueue.take();  // blocks if empty until an element appears ; interruptible
                    System.out.println("user took :" + result);
                    Thread.sleep(1000);
                }
            }
            catch(InterruptedException e){
                System.out.println("User interrupted");
            }


        };



Thread job1 = new Thread(logs,"LOG-1");
        Thread job2 = new Thread(logs,"LOG-2");
                Thread job3 = new Thread(logs,"LOG-3");

Thread users = new Thread(user,"User-1");


job1.start();
job2.start();
job3.start();
users.start();


    }

}
