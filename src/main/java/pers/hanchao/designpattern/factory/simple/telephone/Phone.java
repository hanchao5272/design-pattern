package pers.hanchao.designpattern.factory.simple.telephone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>手机</P>
 *
 * @author hanchao
 */
@Getter
@Setter
@AllArgsConstructor
public abstract class Phone {
    private String name;

    /**
     * 打个电话测试一下
     */
    public abstract void callTest();
}
