package pers.hanchao.designpattern.factory.abstractfactory.factory;


import pers.hanchao.designpattern.factory.simple.telephone.Phone;

/**
 * <p>抽象手机工厂</P>
 *
 * @author hanhao
 */
public abstract class AbstractPhoneFactory {
    /**
     * 制造手机
     *
     * @return 手机
     */
    public abstract Phone producePhone();
}
