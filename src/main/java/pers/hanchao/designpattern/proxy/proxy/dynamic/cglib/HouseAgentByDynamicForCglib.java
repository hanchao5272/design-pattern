package pers.hanchao.designpattern.proxy.proxy.dynamic.cglib;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import pers.hanchao.designpattern.proxy.ower.impl.HouseOwner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <p></P>
 *
 * @author hanchao
 */
@Slf4j
public class HouseAgentByDynamicForCglib implements MethodInterceptor {
    /**
     * 被代理的对象：房主
     */
    private HouseOwner owner;

    public HouseAgentByDynamicForCglib(HouseOwner owner) {
        this.owner = owner;
    }

    /**
     * 对售房进行代理
     *
     * @param obj         代理对象实例
     * @param method      被代理的方法
     * @param args        参数
     * @param methodProxy 方法代理
     * @return 返回值
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws InvocationTargetException, IllegalAccessException {
        //前置操作
        log.info("中介替购房者完成筛选房屋...最终选定了一间房。");

        //售房
        Object result = method.invoke(owner, args);

        //后置操作
        log.info("中介替购房者完成与房主签订的售房合同。");

        return result;
    }
}
