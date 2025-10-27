
    public class MyThread {

        public static void main(String[] args) {
//RUNNABLE METHOD
            Runnable job = () -> {
                System.out.println("Thread from " + Thread.currentThread().getName());
            };


            Thread worker = new Thread(job, "Coach-1");

            worker.start();


            System.out.println("Thread from :" + Thread.currentThread().getName());

// sleep method
            Thread run = new Thread(() -> {
                System.out.println("sleeping example :" + Thread.currentThread().getName());

                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    System.out.println("Thread sleep interrupted " + e);
                }
                System.out.println("Thread after sleep " + Thread.currentThread().getName());

            });
            run.start();


            //INTERRUPT METHOD
            Thread t3 = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Thread.sleep(6000);
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName());
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Thread.stopped"+Thread.currentThread().getName());


            });
            t3.start();
            try {


                Thread.sleep(2000);
            }catch (InterruptedException e){
                System.out.printf("Thread interrupted "+Thread.currentThread().getName());
            }
            System.out.println("Main is interrupting "+t3.getName());
            t3.interrupt();
            try {
                t3.join();
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted while waiting for "+Thread.currentThread().getName());

            }

        }

    }