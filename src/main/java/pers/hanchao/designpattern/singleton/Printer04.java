package pers.hanchao.designpattern.singleton;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

/**
 * <p>懒汉式(同步方法保证,线程安全,资源争夺)</P>
 *
 * @author hanchao
 */
@Slf4j
public class Printer04 {

    /**
     * 私有构造函数：防止外部类创建实例
     */
    private Printer04() {
        log.info("Connect to physical printer...");
        PrinterUtil.ACTUAL_COUNTER.increment();
    }

    private static Printer04 INSTANCE;

    /**
     * 对外统一的实例获取方法(同步方法)
     */
    public static synchronized Printer04 getInstance() {
        //调用getInstance时再进行实例化，但是并没有考虑并发情况
        if (null == INSTANCE) {
            INSTANCE = new Printer04();
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
                Printer04.getInstance();
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
