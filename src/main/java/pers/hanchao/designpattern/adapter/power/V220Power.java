package pers.hanchao.designpattern.adapter.power;

/**
 * <p>220V的电源</P>
 *
 * @author hanchao
 */
public interface V220Power {
    /**
     * 获取名称
     */
    String getName();

    /**
     * 获取电压
     */
    Integer getVoltage();
}
