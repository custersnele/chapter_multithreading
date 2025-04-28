package be.pxl.ja.asynchronous;

public class Computation1 {

        public static void main(String[] args) throws InterruptedException {
            int x = 1337;
            Result result = new Result();
            long time = System.currentTimeMillis();
            Thread t1 = new Thread(() -> { result.left = f(x); } );
            Thread t2 = new Thread(() -> { result.right = g(x); });
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            System.out.println(result.left + result.right);
            System.out.println(System.currentTimeMillis() - time);
        }

    private static int g(int x) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return x * 3;
    }

    private static int f(int x) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return x * 2;
    }

    private static class Result {
            private int left;
            private int right;
        }
}
