public class Pr1 {

    private static Object object = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                ping("PING");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                ping("PONG");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
    }

    public static void ping(String s) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            synchronized (object) {
                object.notify();
                System.out.println(s);
                object.wait();

            }
        }
    }

}
