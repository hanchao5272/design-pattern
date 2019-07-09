package pers.hanchao.designpattern.adapter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.adapter.power.V5Power;

/**
 * <p>手机</P>
 *
 * @author hanchao
 */
@Slf4j
public class Phone {
    /**
     * 充电
     */
    public void batteryCharge(V5Power v5Power) {
        log.info("1.连接电源 ==> " + v5Power.getName());
        log.info("2.当前电压 : " + v5Power.getVoltage());
        log.info("3.进行充电 ... ");
    }
}
