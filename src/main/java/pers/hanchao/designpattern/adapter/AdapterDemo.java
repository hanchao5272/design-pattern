package pers.hanchao.designpattern.adapter;

import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.adapter.adapter.V220ToV5Adapter;
import pers.hanchao.designpattern.adapter.power.V220Power;
import pers.hanchao.designpattern.adapter.power.V5Power;
import pers.hanchao.designpattern.adapter.power.impl.HouseholdPower;
import pers.hanchao.designpattern.adapter.power.impl.PortableBatteryPower;

/**
 * <p>适配器模式示例</P>
 *
 * @author hanchao
 */
@Slf4j
public class AdapterDemo {

    public static void main(String[] args) {
        //首先，需要一部手机
        Phone phone = new Phone();

        log.info("如果有充电宝，则直接用它充电");
        V5Power v5Power = new PortableBatteryPower();
        phone.batteryCharge(v5Power);

        System.out.println();
        log.info("如果只有家用电源，则需要通过电源适配器进行转换");
        V220Power v220Power = new HouseholdPower();
        v5Power = new V220ToV5Adapter(v220Power);
        phone.batteryCharge(v5Power);
    }
}
