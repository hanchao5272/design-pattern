package pers.hanchao.designpattern.singleton;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/**
 * <p>饿汉式(静态变量初始化)[推荐使用]</P>
 *
 * @author hanchao
 */
@Slf4j
public class Printer01 {

    /**
     * 私有构造函数：防止外部类创建实例
     */
    private Printer01() {
        log.info("Connect to physical printer...");
        PrinterUtil.ACTUAL_COUNTER.increment();
    }

    /**
     * 类初始化时调用私有构造函数，完成对象实例化
     */
    private static Printer01 INSTANCE = new Printer01();

    /**
     * 对外统一的实例获取方法
     */
    public static Printer01 getInstance() {
        PrinterUtil.CALL_COUNTER.increment();
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
            log.error("error!");
        }
        return INSTANCE;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = PrinterUtil.getThreadPool();
        CountDownLatch latch = new CountDownLatch(1);

        for (int i = 0; i < PrinterUtil.MAX_THREAD; i++) {
            executorService.submit(() -> {
                Printer01.getInstance();
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
