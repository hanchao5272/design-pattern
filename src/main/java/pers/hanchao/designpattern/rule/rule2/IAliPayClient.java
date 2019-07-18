package pers.hanchao.designpattern.rule.rule2;

/**
 * <p>支付宝的抽象类</P>
 *
 * @author hanchao
 */
public interface IAliPayClient {
    /**
     * 连接
     */
    void connect();

    /**
     * 支付
     */
    void pay(Float money);
}
