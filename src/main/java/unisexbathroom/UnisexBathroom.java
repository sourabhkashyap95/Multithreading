package unisexbathroom;
import java.util.concurrent.Semaphore;

/*A bathroom is being designed for the use of both males and females in an office but requires the following constraints to be maintained:

        There cannot be men and women in the bathroom at the same time.
        There should never be more than three employees in the bathroom simultaneously.*/

public class UnisexBathroom {

    static String WOMEN = "women";
    static String MEN = "men";
    static String NONE = "none";

    String isUsedBy = NONE;
    int empsInBathroom =0;
    Semaphore maxEmps = new Semaphore(3);

    void useBathroom(String name) throws InterruptedException {
        System.out.println(name + " using  bathroom. Current employees in bathroom : " + empsInBathroom);
        Thread.sleep(1000);
        System.out.println(name + " done using bathroom");
    }


    void maleUseBathroom(String name) throws InterruptedException {
        synchronized (this) {
            while(isUsedBy.equals(WOMEN)){
                wait();
            }
            ++empsInBathroom;
            isUsedBy=MEN;
            maxEmps.acquire();
        }
        useBathroom(name);
        maxEmps.release();
        synchronized (this){
            --empsInBathroom;
            if(empsInBathroom ==0) isUsedBy=NONE;
            this.notifyAll();
        }

    }

    void femaleUseBathroom(String name) throws InterruptedException {
        synchronized (this){
            while (isUsedBy.equals(MEN)){
                wait();
            }
            ++empsInBathroom;
            isUsedBy=WOMEN;
            maxEmps.acquire();
        }
        useBathroom(name);
        maxEmps.release();
        synchronized (this){
            --empsInBathroom;
            if(empsInBathroom ==0) isUsedBy=NONE;
            this.notifyAll();
        }
    }
}

