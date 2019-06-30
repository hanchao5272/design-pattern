package pers.hanchao.designpattern.factory.multfactorymethods;


import pers.hanchao.designpattern.factory.simple.telephone.Phone;
import pers.hanchao.designpattern.factory.simple.telephone.ApplePhone;
import pers.hanchao.designpattern.factory.simple.telephone.AndroidPhone;

/**
 * <p>多个工厂方法模式：手机工厂</P>
 *
 * @author hanchao
 */
public class PhoneFactory {

    /**
     * 制造一个苹果手机
     */
    public static Phone produceApplePhone() {
        return new ApplePhone();
    }

    /**
     * 制造一个安卓手机
     */
    public static Phone produceAndroidPhone() {
        return new AndroidPhone();
    }

}