package pers.hanchao.designpattern.singleton;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * <p>工具类：测试相关</P>
 *
 * @author hanchao
 */
public class PrinterUtil {
    /**
     * 测试相关：调用getInstance方法次数统计
     */
    public static LongAdder CALL_COUNTER = new LongAdder();

    /**
     * 测试相关：对象实例化次数统计
     */
    public static LongAdder ACTUAL_COUNTER = new LongAdder();

    /**
     * 测试相关：线程池
     */
    public static ExecutorService getThreadPool() {
        return new ThreadPoolExecutor(0, 1024,
                6L, TimeUnit.SECONDS,
                new SynchronousQueue<>(), new ThreadFactory() {
            private AtomicInteger threadNumber = new AtomicInteger(1);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "design-pattern-thread-" + threadNumber.getAndIncrement());
            }
        });
    }

    /**
     * 测试相关：最大线程量
     */

    public static Integer MAX_THREAD = 1000;
}
