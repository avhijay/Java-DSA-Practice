import com.sun.jdi.Value;

import java.security.Key;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

    public static  void main (String []args ){

        ConcurrentHashMap<String,String> myMap = new ConcurrentHashMap<>();

        myMap.put("A","A's key ");
        myMap.put("C","C's key");




        Thread T1 = new Thread(()->{

            for (int i =0 ; i<5;i++) {
                myMap.put("A" + i, String.valueOf(i));

                System.out.println("Thread1 added : " + "A" + i);

               try {
                   Thread.sleep(2000);
               }catch(InterruptedException e){
                   System.out.println("Thread interrupted :"+e.getLocalizedMessage()+"  "+Thread.currentThread().getName());
               }
            }
            System.out.println(Thread.currentThread().getName()+" : Finishing work ");
        },"T1");


        Thread T2 = new Thread(()->{
            for (int i =10 ; i<15;i++) {
                myMap.put("B" + i,  String.valueOf(i));

                System.out.println( "Thread2 added : "+"B"+i);


                try {
                    Thread.sleep(2000);
                }catch(InterruptedException e){
                    System.out.println("Thread interrupted :"+e.getLocalizedMessage()+"  "+Thread.currentThread().getName());
                }

            }
            System.out.println(Thread.currentThread().getName()+" : Finishing work ");

        },"T2");



        Thread reading = new Thread(()->{
        for (Map.Entry<String,String> entries : myMap.entrySet()) {
            System.out.println("Key: " + entries.getKey() + "  ||  Value: " + entries.getValue());

            System.out.println("   ");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Thread" + Thread.currentThread().getName() + " interrupted :");
            }
        }
            System.out.println(Thread.currentThread().getName()+" : Finishing work ");





        },"ReadingThread");

        T1.start();
        T2.start();
        reading.start();





    }
}
