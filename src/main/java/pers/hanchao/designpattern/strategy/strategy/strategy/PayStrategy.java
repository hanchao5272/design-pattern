package pers.hanchao.designpattern.strategy.strategy.strategy;

/**
 * <p>支付策略</P>
 *
 * @author hanchao
 */
public interface PayStrategy {
    /**
     * 支付
     *
     * @param cost 支付金额
     */
    void pay(Float cost);
}
