package pers.hanchao.designpattern.factory.multfactorymethods;

import pers.hanchao.designpattern.factory.simple.telephone.Phone;

/**
 * <p>2.多个工厂方法模式</P>
 *
 * @author hanchao
 */
public class MultiFactoryMethodsDemo {

    /**
     * 多个工厂方法模式: 每种对象分别编写专用的创建方法，根据调用的创建方法的不同，产生不同的对象。
     * - 简称：工厂方法模式。
     * - 优点：容错率高，因为每种对象都有专用的创建方法，无需传入类型等参数，只要调用正确的创建方法就不会出错。
     * - 优点：耦合度低，每增减一种产品，只需要增减一个创建方法，不会影响其他对象的创建方法。
     * - 缺点：扩展性差，每增减一种产品，都需要修改工厂类，违背了设计模式的开放-封闭原则（OCP，对扩展开放，对修改关闭）。
     * - 造成以上缺点的关键在于：所有对象的创建方法都存在于唯一的一个工厂中。
     * - 为了解决以上问题，尝试创建多个工厂类，增加新的产品，则增加新的工厂和新的工厂方法。如此形成了：抽象工厂模式。
     */
    public static void main(String[] args) {
        //某客户下了一笔大单子，要求生产2台苹果手机和1台安卓手机
        //于是手机工厂开始了生产

        //先来一台苹果手机
        Phone phone = PhoneFactory.produceApplePhone();
        //测试一下
        phone.callTest();

        //再来一台苹果手机
        phone = PhoneFactory.produceApplePhone();
        //测试一下
        phone.callTest();

        //再来一台安卓手机
        phone = PhoneFactory.produceAndroidPhone();
        //测试一下
        phone.callTest();
    }
}
