package pers.hanchao.designpattern.adapter.power.impl;

import pers.hanchao.designpattern.adapter.power.V220Power;

/**
 * <p>家用电源</P>
 *
 * @author hanchao
 */
public class HouseholdPower implements V220Power {

    @Override
    public String getName() {
        return "家用电源";
    }

    @Override
    public Integer getVoltage() {
        return 220;
    }
}
