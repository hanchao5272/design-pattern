package pers.hanchao.designpattern.adapter.power.impl;

import pers.hanchao.designpattern.adapter.power.V5Power;

/**
 * <p>充电宝</P>
 *
 * @author hanchao
 */
public class PortableBatteryPower implements V5Power {

    @Override
    public String getName() {
        return "充电宝";
    }

    @Override
    public Integer getVoltage() {
        return 5;
    }
}
