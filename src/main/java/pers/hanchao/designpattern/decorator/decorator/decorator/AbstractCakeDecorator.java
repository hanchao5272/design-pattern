package pers.hanchao.designpattern.decorator.decorator.decorator;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.decorator.ICake;

/**
 * <p>蛋糕装饰品</P>
 *
 * @author hanchao
 */
@Slf4j
public abstract class AbstractCakeDecorator implements ICake {
    /**
     * 包含一个蛋糕对象
     */
    @Getter
    private ICake cake;

    public AbstractCakeDecorator(ICake cake) {
        this.cake = cake;
    }

    /**
     * 展示制作过程
     */
    @Override
    public abstract void showMakingProcess();

    /**
     * 总花费
     */
    @Override
    public abstract float getCost();

    /**
     * 显示花费
     */
    @Override
    public void showCost() {
        log.info("总价：{}", getCost());
    }
}
