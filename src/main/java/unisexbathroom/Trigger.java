package unisexbathroom;

public class Trigger {
    public static void main(String[] args) throws InterruptedException {
        final UnisexBathroom bathroom = new UnisexBathroom();
        Thread female1 = new Thread(new Runnable() {
            public void run() {
                try {
                    bathroom.femaleUseBathroom("Lisa");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread female2 = new Thread(new Runnable() {
            public void run() {
                try {
                    bathroom.femaleUseBathroom("Mona");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread female3 = new Thread(new Runnable() {
            public void run() {
                try {
                    bathroom.femaleUseBathroom("Karen");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread female4 = new Thread(new Runnable() {
            public void run() {
                try {
                    bathroom.femaleUseBathroom("Joe");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread female5 = new Thread(new Runnable() {
            public void run() {
                try {
                    bathroom.femaleUseBathroom("Rachel");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread male1 = new Thread(new Runnable() {
            public void run() {
                try {
                    bathroom.maleUseBathroom("Smith");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread male2 = new Thread(new Runnable() {
            public void run() {
                try {
                    bathroom.maleUseBathroom("Henry");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread male3 = new Thread(new Runnable() {
            public void run() {
                try {
                    bathroom.maleUseBathroom("Boyan");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread male4 = new Thread(new Runnable() {
            public void run() {
                try {
                    bathroom.maleUseBathroom("Carl");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        male1.start();
        male2.start();
        male3.start();
        male4.start();
        female2.start();
        female3.start();
        female4.start();
        female5.start();
        female1.start();


        male3.join();
        male4.join();
        male2.join();
        male1.join();
        female1.join();
        female2.join();
        female3.join();
        female5.join();
        female4.join();


    }
}
