package pers.hanchao.designpattern.proxy;

import pers.hanchao.designpattern.proxy.buyer.HouseBuyer;

/**
 * <p>代理模式测试程序</P>
 *
 * @author hanchao
 */
public class ProxyDemo {

    public static void main(String[] args) {
        HouseBuyer houseBuyer = new HouseBuyer();
        System.out.println("------------------------------------------------------------------------------------------");

        //直接找房主购房
        houseBuyer.buyHouseDirectly();
        System.out.println("------------------------------------------------------------------------------------------");

        //找中介买房：静态代理-代理对象:接口
        houseBuyer.buyHouseByStaticProxyForInterface();
        System.out.println("------------------------------------------------------------------------------------------");

        //找中介买房：静态代理-代理对象:类
        houseBuyer.buyHouseByStaticProxyForClass();
        System.out.println("------------------------------------------------------------------------------------------");

        //找中介买房：JDK动态代理-代理对象:接口
        houseBuyer.buyHouseByDynamicProxyForJdk();
        System.out.println("------------------------------------------------------------------------------------------");

        //找中介买房：CGLIB动态代理-代理对象:类
        houseBuyer.buyHouseByDynamicProxyForCglib();
        System.out.println("------------------------------------------------------------------------------------------");
    }
}
