package pers.hanchao.designpattern.rule.rule5;

/**
 * <p>支付的抽象类</P>
 *
 * @author hanchao
 */
public interface PayClient {
    /**
     * 支付
     */
    void pay(float money);
}
