package pers.hanchao.designpattern.factory.abstractfactory.factory;

import pers.hanchao.designpattern.factory.simple.telephone.Phone;
import pers.hanchao.designpattern.factory.simple.telephone.ApplePhone;

/**
 * <p>具体工厂：苹果手机工厂</P>
 *
 * @author hanchao
 */
public class ApplePhoneFactory extends AbstractPhoneFactory {

    @Override
    public Phone producePhone() {
        return new ApplePhone();
    }
}