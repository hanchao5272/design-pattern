package pers.hanchao.designpattern.decorator.origin1;

import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.decorator.ICake;

/**
 * <p>实现方式1：每种蛋糕一个子类：奶油蛋糕</P>
 * 每多一种蛋糕，就需要多实现一个类，如果有几百种蛋糕，就需要实现几百个类。
 *
 * @author hanchao
 */
@Slf4j
public class CreamCake implements ICake {
    /**
     * 展示制作过程
     */
    @Override
    public void showMakingProcess() {
        log.info("选取一个蛋糕胚...");
        log.info("包裹一层奶油...");
    }

    /**
     * 显示总花费
     */
    @Override
    public float getCost() {
        return 120.99f;
    }

    /**
     * 显示花费
     */
    @Override
    public void showCost() {
        log.info("总价：{}", 120.99f);
    }
}
