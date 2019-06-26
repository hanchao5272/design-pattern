package pers.hanchao.designpattern.singleton;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/**
 * <p>懒汉式(同步代码块,双重校验,线程安全)[推荐使用]</P>
 *
 * @author hanchao
 */
@Slf4j
public class Printer06 {

    /**
     * 私有构造函数：防止外部类创建实例
     */
    private Printer06() {
        log.info("Connect to physical printer...");
        PrinterUtil.ACTUAL_COUNTER.increment();
    }

    private static Printer06 INSTANCE;

    /**
     * 对外统一的实例获取方法
     */
    public static Printer06 getInstance() {
        //调用getInstance时再进行实例化，单重校验线程不安全，资源争夺
        if (null == INSTANCE) {
            synchronized (Printer06.class) {
                if (null == INSTANCE) {
                    INSTANCE = new Printer06();
                }
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
                Printer06.getInstance();
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
