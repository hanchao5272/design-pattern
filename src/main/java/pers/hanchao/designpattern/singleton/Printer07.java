package pers.hanchao.designpattern.singleton;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/**
 * <p>内部类[推荐使用]</P>
 *
 * @author hanchao
 */
@Slf4j
public class Printer07 {

    /**
     * 私有构造函数：防止外部类创建实例
     */
    private Printer07() {
        log.info("Connect to physical printer...");
        PrinterUtil.ACTUAL_COUNTER.increment();
    }

    /**
     * 将唯一实例放在静态内部类的静态变量中。静态内部类的静态变量在外部类被加载时不会立即实例化，
     * 只有在调用getInstance方法时才会加载静态内部类，进而完成静态内部类的静态变量的初始化。
     */
    private static class PrinterUtil07Holder {
        private static Printer07 INSTANCE = new Printer07();
    }

    /**
     * 对外统一的实例获取方法
     */
    public static Printer07 getInstance() {
        PrinterUtil.CALL_COUNTER.increment();
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
            log.error("error!");
        }
        return PrinterUtil07Holder.INSTANCE;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = PrinterUtil.getThreadPool();
        CountDownLatch latch = new CountDownLatch(1);

        for (int i = 0; i < PrinterUtil.MAX_THREAD; i++) {
            executorService.submit(() -> {
                Printer07.getInstance();
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    log.error("Error !");
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
