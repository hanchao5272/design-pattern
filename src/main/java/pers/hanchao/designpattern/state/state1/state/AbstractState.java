package pers.hanchao.designpattern.state.state1.state;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.state.state1.Shooter;

/**
 * <p>射击状态</P>
 *
 * @author hanchao
 */
@Slf4j
@AllArgsConstructor
public abstract class AbstractState {

    /**
     * 状态所属对象
     */
    @Getter
    private Shooter shooter;

    /**
     * 射击
     */
    public abstract void shoot();

    /**
     * 填充子弹
     */
    public void fill() {
        log.info("[{}]当前共[{}]发子弹，填充了[{}]发子弹。", shooter.getName(), shooter.getNowSize(), (shooter.getMaxSize() - shooter.getNowSize()));
        shooter.setNowSize(shooter.getMaxSize());
        shooter.setCurrentState(shooter.getLoadedState());
    }
}
