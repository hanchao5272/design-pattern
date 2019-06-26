package pers.hanchao.designpattern.singleton;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/**
 * <p>枚举(简洁版)[推荐使用]</P>
 *
 * @author hanchao
 */
public enum Printer09 {

    /**
     * 唯一实例
     */
    INSTANCE;

    /**
     * 枚举的构造方法保证私有性：防止外部类创建实例
     */
    Printer09() {
        System.out.println("Connect to physical printer...");
        PrinterUtil.ACTUAL_COUNTER.increment();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = PrinterUtil.getThreadPool();
        CountDownLatch latch = new CountDownLatch(1);

        for (int i = 0; i < PrinterUtil.MAX_THREAD; i++) {
            executorService.submit(() -> {
                Printer09 instance = Printer09.INSTANCE;
                PrinterUtil.CALL_COUNTER.increment();
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    System.out.println("Error !");
                }
            });
        }
        latch.countDown();

        executorService.shutdown();
        Thread.sleep(1000L);

        System.out.println("在1s内，调用getInstance次数：" + PrinterUtil.CALL_COUNTER.sum());
        System.out.println("在1s内，实际实例化的对象个数：" + PrinterUtil.ACTUAL_COUNTER.sum());
    }
}
