package pers.hanchao.designpattern.factory.simple;

import pers.hanchao.designpattern.factory.simple.telephone.Phone;

/**
 * <p>1.简单工厂模式</P>
 *
 * @author hanchao
 */
public class SimpleFactoryDemo {

    /**
     * 简单工厂：一般情况下，创建对象的方法需要传入代表类型的参数type，然后再通过if-else或者switch语句根据type创建对应的对象。
     * - 通常提供的创建对象的方法是静态的，所以简单工厂也称之为静态工厂
     * - 优点：可复用高，所有对象的创建都通过同名的方法创建。
     * - 缺点：容错率低，如果传入的类型参数type因为粗心写错，则创建的产品会与预期不符。
     * - 缺点：耦合度高，每增减一种产品，都需要对创建所有对象的共用方法进行修改。
     * - 缺点：扩展性差，每增减一种产品，都需要修改工厂类，违背了设计模式的开放-封闭原则（OCP，对扩展开放，对修改关闭）。
     * - 造成以上缺点的关键在于：所有对象的创建都依赖于唯一的一个工厂方法。
     * - 为了解决以上问题，尝试将每种对象的创建方法都抽取成单独的工厂方法。如此形成了：多个工厂方法模式
     */
    public static void main(String[] args) {
        //某客户下了一笔大单子，要求制造2台苹果手机和1台安卓手机
        //于是手机工厂开始了制造

        //先来一台苹果手机
        Phone phone = PhoneFactory.producePhone(PhoneFactory.TYPE_APPLE);
        //测试一下
        phone.callTest();

        //再来一台苹果手机
        phone = PhoneFactory.producePhone(PhoneFactory.TYPE_APPLE);
        //测试一下
        phone.callTest();

        //再来一台安卓手机
        phone = PhoneFactory.producePhone(PhoneFactory.TYPE_ANDROID);
        //测试一下
        phone.callTest();
    }
}
