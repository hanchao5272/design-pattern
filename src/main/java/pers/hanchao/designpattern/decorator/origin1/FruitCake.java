package pers.hanchao.designpattern.decorator.origin1;

import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.decorator.ICake;

/**
 * <p>实现方式1：每种蛋糕一个子类：水果蛋糕</P>
 * 每多一种蛋糕，就需要多实现一个类，如果有几百种蛋糕，就需要实现几百个类。
 *
 * @author hanchao
 */
@Slf4j
public class FruitCake implements ICake {

    /**
     * 展示制作过程
     */
    @Override
    public void showMakingProcess() {
        log.info("选取一个蛋糕胚...");
        log.info("包裹一层奶油...");
        log.info("摆放6片菠萝...");
        log.info("摆放6颗草莓...");
    }

    /**
     * 计算总花费
     */
    @Override
    public float getCost() {
        return 320.99f;
    }

    /**
     * 显示花费
     */
    @Override
    public void showCost() {
        log.info("总价：{}", 320.99f);
    }
}
