package pers.hanchao.designpattern.state.state1.state.impl;

import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.state.state1.Shooter;
import pers.hanchao.designpattern.state.state1.state.AbstractState;

/**
 * <p>无子弹状态</P>
 *
 * @author hanchao
 */
@Slf4j
public class UnloadState extends AbstractState {

    public UnloadState(Shooter shooter) {
        super(shooter);
    }

    /**
     * 射击
     */
    @Override
    public void shoot() {
        //如果无子弹，则提示
        log.info("[{}]没有子弹了，请填充！！！", super.getShooter().getName());
    }
}
