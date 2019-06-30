package pers.hanchao.designpattern.factory.simple.telephone;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>安卓手机</P>
 *
 * @author hanchao
 */
@Slf4j
public class AndroidPhone extends Phone {

    public AndroidPhone() {
        super("安卓手机");
    }

    @Override
    public void callTest() {
        log.info("使用[" + super.getName() + "]给15533335555打电话.");
    }
}
