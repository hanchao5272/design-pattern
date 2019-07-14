package pers.hanchao.designpattern.state.state2.state.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.state.state2.Shooter;
import pers.hanchao.designpattern.state.state2.state.State;

/**
 * <p>无子弹状态</P>
 *
 * @author hanchao
 */
@Slf4j
@AllArgsConstructor
public class UnloadState implements State {
    /**
     * 状态所属对象
     */
    private Shooter shooter;

    /**
     * 射击
     */
    @Override
    public void shoot() {
        //如果无子弹，则提示
        log.info("[{}]没有子弹了，请填充！！！", shooter.getName());
    }

    /**
     * 填充子弹
     */
    @Override
    public void fill() {
        log.info("[{}]当前共[{}]发子弹，填充了[{}]发子弹。", shooter.getName(), shooter.getNowSize(), (shooter.getMaxSize() - shooter.getNowSize()));
        shooter.setNowSize(shooter.getMaxSize());
        shooter.setCurrentState(shooter.getLoadedState());
    }
}
