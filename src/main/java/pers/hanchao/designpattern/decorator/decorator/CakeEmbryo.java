package pers.hanchao.designpattern.decorator.decorator;

import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.decorator.ICake;

/**
 * <p>蛋糕胚</P>
 *
 * @author hnchao
 */
@Slf4j
public class CakeEmbryo implements ICake {
    /**
     * 展示制作过程
     */
    @Override
    public void showMakingProcess() {
        log.info("选取一个蛋糕胚...");
    }

    /**
     * 显示总花费
     */
    @Override
    public float getCost() {
        return 30f;
    }

    /**
     * 显示花费
     */
    @Override
    public void showCost() {
        log.info("总价：{}", getCost());
    }
}
