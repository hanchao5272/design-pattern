package pers.hanchao.designpattern.factory.simple;

import pers.hanchao.designpattern.factory.simple.telephone.AndroidPhone;
import pers.hanchao.designpattern.factory.simple.telephone.ApplePhone;
import pers.hanchao.designpattern.factory.simple.telephone.Phone;

/**
 * <p>简单工厂：手机工厂</P>
 *
 * @author hanchao
 */
public class PhoneFactory {
    public static final int TYPE_APPLE = 1;
    public static final int TYPE_ANDROID = 2;

    /**
     * 简单工厂：一般情况下，创建对象的方法需要传入代表类型的参数type，然后再通过if-else或者switch语句根据type创建对应的对象。
     */
    public static Phone producePhone(int type) {
        Phone phone;
        switch (type) {
            case TYPE_APPLE:
                //生产一个苹果手机
                phone = new ApplePhone();
                break;
            case TYPE_ANDROID:
                //生产一个安卓手机
                phone = new AndroidPhone();
                break;
            default:
                throw new IllegalArgumentException("此型号手机暂不生产！");
        }
        return phone;
    }
}