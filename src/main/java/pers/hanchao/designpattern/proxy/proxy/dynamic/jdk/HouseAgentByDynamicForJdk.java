package pers.hanchao.designpattern.proxy.proxy.dynamic.jdk;

import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.proxy.ower.IHouseOwner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <p>动态代理：房屋中介</P>
 *
 * @author hanchao
 */
@Slf4j
public class HouseAgentByDynamicForJdk implements InvocationHandler {
    /**
     * 被代理的对象：房主
     */
    private IHouseOwner owner;

    public HouseAgentByDynamicForJdk(IHouseOwner owner) {
        this.owner = owner;
    }

    /**
     * 对售房进行代理
     *
     * @param proxy  代理对象实例
     * @param method 被代理的方法
     * @param args   参数
     * @return 返回值
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //前置操作
        log.info("中介替购房者完成筛选房屋...最终选定了一间房。");

        //售房
        Object result = method.invoke(owner, args);

        //后置操作
        log.info("中介替购房者完成与房主签订的售房合同。");

        return result;
    }
}
