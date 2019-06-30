package pers.hanchao.designpattern.factory.simple.telephone;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>苹果手机</P>
 *
 * @author hanchao
 */
@Slf4j
public class ApplePhone extends Phone {

    public ApplePhone() {
        super("苹果手机");
    }

    @Override
    public void callTest() {
        log.info("使用[" + super.getName() + "]给13322224444打电话.");
    }
}
