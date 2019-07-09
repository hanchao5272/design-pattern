package pers.hanchao.designpattern.adapter.adapter;

import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.adapter.power.V220Power;
import pers.hanchao.designpattern.adapter.power.V5Power;

/**
 * <p>USB接口转换器</P>
 * <p>
 * 1.实现适配目标对象V5Power
 *
 * @author hanchao
 */
@Slf4j
public class V220ToV5Adapter implements V5Power {
    /**
     * 2.以组合的方式持有被适配对象v220Power
     */
    private V220Power v220Power;

    /**
     * 3.在构造时初始化被适配对象v220Power
     */
    public V220ToV5Adapter(V220Power v220Power) {
        this.v220Power = v220Power;
    }

    /**
     * 重写V5Power的方法，完成V220到V5的转换过程
     */
    @Override
    public String getName() {
        return " 电源适配器 ==> " + v220Power.getName();
    }

    /**
     * 重写V5Power的方法，完成V220到V5的转换过程
     */
    @Override
    public Integer getVoltage() {
        log.info("原始电压为：" + v220Power.getVoltage());
        log.info("进行电压转换：" + v220Power.getVoltage() + " --> " + 5);
        log.info("转换之后的电源为：5");
        return 5;
    }
}
