package pers.hanchao.designpattern.singleton;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/**
 * <p>枚举[推荐使用]</P>
 *
 * @author hanchao
 */
public enum Printer08 {

    /**
     * 唯一实例
     */
    INSTANCE;

    /**
     * 枚举的构造方法保证私有性：防止外部类创建实例
     */
    Printer08() {
        System.out.println("Connect to physical printer...");
        PrinterUtil.ACTUAL_COUNTER.increment();
    }

    /**
     * 对外统一的实例获取方法（在枚举实现的单例模式中，此方法可以省略，直接通过Printer08.INSTANCE获取对象实例）
     */
    public Printer08 getInstance() {
        PrinterUtil.CALL_COUNTER.increment();
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
            System.out.println("error!");
        }
        return this;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = PrinterUtil.getThreadPool();
        CountDownLatch latch = new CountDownLatch(1);

        for (int i = 0; i < PrinterUtil.MAX_THREAD; i++) {
            executorService.submit(() -> {
                //更简洁的写法：Printer08 instance = Printer08.INSTANCE;
                Printer08.INSTANCE.getInstance();
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
