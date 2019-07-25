package pers.hanchao.designpattern.decorator.decorator.decorator;

import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.decorator.ICake;

/**
 * <p>水果</P>
 *
 * @author hanchao
 */
@Slf4j
public class FruitDecorator extends AbstractCakeDecorator {

    private String fruit;

    private float cost;

    public FruitDecorator(ICake cake, String fruit, float cost) {
        super(cake);
        this.fruit = fruit;
        this.cost = cost;
    }

    /**
     * 展示制作过程
     */
    @Override
    public void showMakingProcess() {
        super.getCake().showMakingProcess();
        log.info("摆放" + fruit + "...");
    }

    /**
     * 显示总花费
     */
    @Override
    public float getCost() {
        return super.getCake().getCost() + cost;
    }
}
