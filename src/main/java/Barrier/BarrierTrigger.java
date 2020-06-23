package Barrier;

public class BarrierTrigger {
    public static void main(String[] args) throws InterruptedException {
        final Barrier barrier = new Barrier(3);

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    barrier.await();
                    System.out.println("Thread1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {

                try {
                    barrier.await();
                    Thread.sleep(2000);
                    System.out.println("Thread2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            public void run() {
                try {
                    barrier.await();
                    Thread.sleep(4000);
                    System.out.println("Thread3");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t4 = new Thread(new Runnable() {
            public void run() {
                try {
                    barrier.await();
                    System.out.println("Thread4");
                    Thread.sleep(1000);
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
        //t4.start();


        t1.join();
        t2.join();
        t3.join();
        //t4.join();
    }
}
