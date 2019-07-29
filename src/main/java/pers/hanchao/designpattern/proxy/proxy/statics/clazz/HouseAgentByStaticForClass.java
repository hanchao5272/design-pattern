package pers.hanchao.designpattern.proxy.proxy.statics.clazz;

import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.proxy.ower.impl.HouseOwner;

/**
 * <p>房屋中介：静态代理-代理对象是类</P>
 *
 * @author hanchao
 */
@Slf4j
public class HouseAgentByStaticForClass {

    /**
     * 被代理的对象：房主
     */
    private HouseOwner owner;

    public HouseAgentByStaticForClass(HouseOwner owner) {
        this.owner = owner;
    }

    /**
     * 房屋交易
     */
    public void sellHouse() {
        //前置操作
        log.info("中介替购房者完成筛选房屋...最终选定了一间房。");

        //售房
        owner.tradeHouse();

        //后置操作
        log.info("中介替购房者完成与房主签订的售房合同。");
    }
}
