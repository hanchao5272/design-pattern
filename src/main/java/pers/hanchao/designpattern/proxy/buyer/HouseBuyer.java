package pers.hanchao.designpattern.proxy.buyer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import pers.hanchao.designpattern.proxy.ower.IHouseOwner;
import pers.hanchao.designpattern.proxy.ower.impl.HouseOwner;
import pers.hanchao.designpattern.proxy.proxy.dynamic.cglib.HouseAgentByDynamicForCglib;
import pers.hanchao.designpattern.proxy.proxy.dynamic.jdk.HouseAgentByDynamicForJdk;
import pers.hanchao.designpattern.proxy.proxy.statics.clazz.HouseAgentByStaticForClass;
import pers.hanchao.designpattern.proxy.proxy.statics.interfaces.HouseAgentByStaticForInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * <p>购房者</P>
 *
 * @author hanchao
 */
@Slf4j
public class HouseBuyer {
    /**
     * 直接找房主购房
     */
    public void buyHouseDirectly() {
        log.info("购房者花费大量时间用于筛选房屋...最终选定了一间房。");
        new HouseOwner().tradeHouse();
        log.info("购房者与房主签订售房合同。");
    }

    /**
     * 找中介买房：静态代理-代理对象:类
     */
    public void buyHouseByStaticProxyForClass() {
        //被代理对象：房主类
        HouseOwner owner = new HouseOwner();

        //代理对象
        HouseAgentByStaticForClass houseAgent = new HouseAgentByStaticForClass(owner);

        //买房
        houseAgent.sellHouse();
    }

    /**
     * 找中介买房：静态代理-代理对象:接口
     */
    public void buyHouseByStaticProxyForInterface() {
        //被代理对象：房主接口
        IHouseOwner iHouseOwner = new HouseOwner();

        //定义代理对象
        IHouseOwner houseAgent = new HouseAgentByStaticForInterface(iHouseOwner);

        //买房
        houseAgent.tradeHouse();
    }

    /**
     * 找中介买房：JDK动态代理-代理对象:接口
     */
    public void buyHouseByDynamicProxyForJdk() {
        //被代理的对象：房主接口
        IHouseOwner owner = new HouseOwner();

        //被代理对象的类加载器
        ClassLoader classLoader = IHouseOwner.class.getClassLoader();

        //被代理的接口的类型
        Class[] classes = {IHouseOwner.class};

        //代理时的调用处理器：房租中介
        InvocationHandler proxyHandler = new HouseAgentByDynamicForJdk(owner);

        //代理对象
        IHouseOwner proxy = (IHouseOwner) Proxy.newProxyInstance(classLoader, classes, proxyHandler);

        //代理售房
        proxy.tradeHouse();
    }

    /**
     * 找中介买房：CGLIB动态代理-代理对象:类
     */
    public void buyHouseByDynamicProxyForCglib() {
        //被代理的对象：房主
        HouseOwner owner = new HouseOwner();

        //CGLIB增强的代理类
        Enhancer enhancer = new Enhancer();

        //被代理对象的类型
        enhancer.setSuperclass(HouseOwner.class);

        //定义代理时的方法解释器
        MethodInterceptor methodInterceptor = new HouseAgentByDynamicForCglib(owner);

        //以回调方式设置代理行为
        enhancer.setCallback(methodInterceptor);

        //创建代理对象
        HouseOwner roomMarket = (HouseOwner) enhancer.create();

        //代理售房
        roomMarket.tradeHouse();
    }
}
