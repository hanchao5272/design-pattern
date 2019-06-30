package pers.hanchao.designpattern.factory.abstractfactory;

import pers.hanchao.designpattern.factory.abstractfactory.factory.ApplePhoneFactory;
import pers.hanchao.designpattern.factory.abstractfactory.factory.AndroidPhoneFactory;
import pers.hanchao.designpattern.factory.simple.telephone.Phone;

/**
 * <p>3.抽象工厂模式</P>
 *
 * @author hanchao
 */
public class AbstractFactoryDemo {

    /**
     * 抽象工厂模式: 提供一个抽象工厂和抽象方法，每种对象的创建都有对应的子工厂的对象创建方法完成。
     * - 优点：容错率高，因为每种对象都有专用的工厂及创建方法，只要调用正确的工厂的创建方法就不会出错。
     * - 优点：耦合度低，每增减一种产品，只需要增减一个工厂及创建方法，不会影响其他对象的创建方法。
     * - 优点：扩展性好，每增减一种产品，只需要增减此对象专用的工厂及创建方法，不会修改其他工厂，遵循了开放-封闭原则（OCP，对扩展开放，对修改关闭）。
     */
    public static void main(String[] args) {
        //某客户下了一笔大单子，要求制造2台苹果手机和1台安卓手机
        //于是手机工厂开始了制造

        //先来一台苹果手机
        Phone phone = new ApplePhoneFactory().producePhone();
        //测试一下
        phone.callTest();

        //再来一台苹果手机
        phone = new ApplePhoneFactory().producePhone();
        //测试一下
        phone.callTest();

        //再来一台安卓手机
        phone = new AndroidPhoneFactory().producePhone();
        //测试一下
        phone.callTest();
    }
}
