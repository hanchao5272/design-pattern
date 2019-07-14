package pers.hanchao.designpattern.state.state2.state.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import pers.hanchao.designpattern.state.state2.Shooter;
import pers.hanchao.designpattern.state.state2.state.State;

/**
 * <p>有子弹状态</P>
 *
 * @author hanchao
 */
@Slf4j
@AllArgsConstructor
public class LoadedState implements State {
    /**
     * 状态所属对象
     */
    private Shooter shooter;

    /**
     * 射击
     */
    @Override
    public void shoot() {
        //造成伤害
        Integer damage = RandomUtils.nextInt(shooter.getMinPower(), shooter.getMaxPower());
        shooter.setNowSize(shooter.getNowSize() - 1);
        log.info("使用[{}]进行射击，造成[{}]伤害！还剩余[{}]颗子弹。", shooter.getName(), damage, shooter.getNowSize());

        //如果剩余子弹为0，则转换为无子弹状态
        if (shooter.getNowSize() == 0) {
            shooter.setCurrentState(shooter.getUnloadState());
        }else {
            //如果还有子弹，则有30%概率进入致死状态
            Integer score = RandomUtils.nextInt(0, 100);
            if (score < 30) {
                log.info("进入致死状态");
                shooter.setCurrentState(shooter.getDeadlyState());
            }
        }
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
