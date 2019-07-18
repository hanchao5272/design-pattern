package pers.hanchao.designpattern.rule.rule5.impl;

import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.rule.FormatUtil;
import pers.hanchao.designpattern.rule.rule5.Connectable;
import pers.hanchao.designpattern.rule.rule5.PayClient;

/**
 * <p>支付宝</P>
 *
 * @author hanchao
 */
@Slf4j
public class AliPayClient implements PayClient, Connectable {
    /**
     * 连接
     */
    @Override
    public void connect() {
        log.info("开始进行支付宝支付：");
        log.info("1.初始化支付宝客户端AlipayClient...");
        log.info("2.设置请求参数...");
        log.info("3.请求支付宝进行付款，并获取支付结果...");
        log.info("-------------------------------------");
    }

    /**
     * 支付
     */
    @Override
    public void pay(float money) {
        connect();
        log.info("4.通过支付宝支付了" + FormatUtil.format(money) + "元.");
    }
}
