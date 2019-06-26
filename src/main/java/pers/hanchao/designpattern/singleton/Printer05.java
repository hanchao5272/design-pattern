package pers.hanchao.designpattern.singleton;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

/**
 * <p>懒汉式(同步代码块,单重校验,线程不安全)[不能使用]</P>
 *
 * @author hanchao
 */
@Slf4j
public class Printer05 {

    /**
     * 私有构造函数：防止外部类创建实例
     */
    private Printer05() {
        log.info("Connect to physical printer...");
        PrinterUtil.ACTUAL_COUNTER.increment();
    }

    private static Printer05 INSTANCE;

    /**
     * 对外统一的实例获取方法
     */
    public static Printer05 getInstance() {
        //调用getInstance时再进行实例化，单重校验线程不安全
        if (null == INSTANCE) {
            synchronized (Printer05.class) {
                INSTANCE = new Printer05();
            }
        }
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
            log.error("error!");
        }
        PrinterUtil.CALL_COUNTER.increment();
        return INSTANCE;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = PrinterUtil.getThreadPool();
        CountDownLatch latch = new CountDownLatch(1);

        for (int i = 0; i < PrinterUtil.MAX_THREAD; i++) {
            executorService.submit(() -> {
                Printer05.getInstance();
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
