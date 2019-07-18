package pers.hanchao.designpattern.rule.rule4.impl;

import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.rule.FormatUtil;
import pers.hanchao.designpattern.rule.rule4.PayClient;

/**
 * <p>微信支付</P>
 *
 * @author hanchao
 */
@Slf4j
public class WeChatPayClient implements PayClient {
    /**
     * 连接
     */
    @Override
    public void connect() {
        //do nothing
    }

    /**
     * 支付
     */
    @Override
    public void pay(Float money) {
        log.info("开始进行微信支付：");
        log.info("1.设置请求参数...");
        log.info("2.发送HTTP请求微信付款地址进行支付...");
        log.info("3.进行微信支付回调，并获取支付结果...");
        log.info("-------------------------------------");
        log.info("4.通过微信支付了" + FormatUtil.format(money) + "元.");
    }
}
