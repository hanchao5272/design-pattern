package pers.hanchao.designpattern.rule.rule1;

import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.rule.FormatUtil;

/**
 * <p>支付宝类</P>
 *
 * @author hanchao
 */
@Slf4j
public class AliPayClient {
    /**
     * 连接支付宝
     */
    private void connect() {
        log.info("开始进行支付宝支付：");
        log.info("1.初始化支付宝客户端...");
        log.info("2.设置请求参数...");
        log.info("3.请求支付宝进行付款，并获取支付结果...");
        log.info("-------------------------------------");
    }

    /**
     * 支付(日志显示2位小数)
     */
    public void pay(float money) {
        connect();
        log.info("4.通过支付宝支付了" + FormatUtil.format(money) + "元.");
    }
}
