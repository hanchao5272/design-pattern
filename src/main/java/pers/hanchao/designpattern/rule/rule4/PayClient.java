package pers.hanchao.designpattern.rule.rule4;

/**
 * <p>支付的抽象类</P>
 *
 * @author hanchao
 */
public interface PayClient {
    /**
     * 连接
     */
    void connect();
    /**
     * 支付
     */
    void pay(Float money);
}
