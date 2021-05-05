public class Lucky {
    static SmartInt X = new SmartInt(0);
    static SmartInt count = new SmartInt(0);

    static class LuckyThread extends Thread {
        @Override
        public void run() {
            while (X.getValue() < 999999) {
                int x = X.incrementValue();
                if ((x % 10) + (x / 10) % 10 + (x / 100) % 10 == (x / 1000)
                        % 10 + (x / 10000) % 10 + (x / 100000) % 10) {
                    System.out.println(x);
                    count.incrementValue();
                }
            }
        }
    }

    public static void executeLucky(String[] args) throws InterruptedException {
        Thread t1 = new LuckyThread();
        Thread t2 = new LuckyThread();
        Thread t3 = new LuckyThread();
        long before = System.currentTimeMillis();
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        long after = System.currentTimeMillis();
        System.out.println("Spent time: " + (after-before) + " ms.");
        System.out.println("Total: " + count.getValue());
    }
}