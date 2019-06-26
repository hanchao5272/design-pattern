package pers.hanchao.designpattern.singleton;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/**
 * <p>饿汉式(静态代码块初始化)[推荐使用]</P>
 *
 * @author hanchao
 */
@Slf4j
public class Printer02 {

    /**
     * 私有构造函数：防止外部类创建实例
     */
    private Printer02() {
        log.info("Connect to physical printer...");
        PrinterUtil.ACTUAL_COUNTER.increment();
    }

    private static Printer02 INSTANCE;

    /**
     * 类初始化时调用私有构造函数，完成对象实例化
     */
    static {
        //静态代码块写法的优点：可以进行更多的操作
        log.info("Do more thing...");
        INSTANCE = new Printer02();
    }

    /**
     * 对外统一的实例获取方法
     */
    public static Printer02 getInstance() {
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
                Printer02.getInstance();
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
