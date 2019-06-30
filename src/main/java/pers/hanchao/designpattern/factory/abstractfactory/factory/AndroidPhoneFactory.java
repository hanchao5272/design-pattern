package pers.hanchao.designpattern.factory.abstractfactory.factory;

import pers.hanchao.designpattern.factory.simple.telephone.AndroidPhone;
import pers.hanchao.designpattern.factory.simple.telephone.Phone;

/**
 * <p>具体工厂：安卓手机工厂</P>
 *
 * @author hanchao
 */
public class AndroidPhoneFactory extends AbstractPhoneFactory {

    @Override
    public Phone producePhone() {
        return new AndroidPhone();
    }
}