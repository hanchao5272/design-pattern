package pers.hanchao.designpattern.decorator;

/**
 * <p>生日蛋糕接口</P>
 *
 * @author hanchao
 */
public interface ICake {

    /**
     * 展示制作过程
     */
    void showMakingProcess();

    /**
     * 总花费
     */
    float getCost();

    /**
     * 显示花费
     */
    void showCost();
}
