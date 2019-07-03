package pers.hanchao.designpattern.strategy.strategy.strategy.impl;

import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.strategy.strategy.strategy.PayStrategy;

/**
 * <p>银联支付策略</P>
 *
 * @author hanchao
 */
@Slf4j
public class UnionPayStrategy implements PayStrategy {
    @Override
    public void pay(Float cost) {
        log.info("通过银联支付了" + cost + "元.");
    }
}
