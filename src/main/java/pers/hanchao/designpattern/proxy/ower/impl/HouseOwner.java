package pers.hanchao.designpattern.proxy.ower.impl;

import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.proxy.ower.IHouseOwner;

/**
 * <p>房主</P>
 *
 * @author hanchao
 */
@Slf4j
public class HouseOwner implements IHouseOwner {
    /**
     * 房屋交易
     */
    @Override
    public void tradeHouse() {
        log.info("房屋交易");
    }
}
