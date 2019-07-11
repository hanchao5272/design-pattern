package pers.hanchao.designpattern.decorator.decorator.decorator;

import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.decorator.ICake;

/**
 * <p>奶油</P>
 *
 * @author hancha
 */
@Slf4j
public class CreamDecorator extends AbstractCakeDecorator {

    public CreamDecorator(ICake cake) {
        super(cake);
    }

    /**
     * 展示制作过程
     */
    @Override
    public void showMakingProcess() {
        super.getCake().showMakingProcess();
        log.info("包裹一层奶油...");
    }

    /**
     * 显示总花费
     */
    @Override
    public float getCost() {
        return super.getCake().getCost() + 12f;
    }
}
