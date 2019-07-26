package pers.hanchao.designpattern.state.state2.state.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import pers.hanchao.designpattern.state.state2.Shooter;
import pers.hanchao.designpattern.state.state2.state.AbstractState;

/**
 * <p>有子弹状态</P>
 *
 * @author hanchao
 */
@Slf4j
public class LoadedState extends AbstractState {

    public LoadedState(Shooter shooter) {
        super(shooter);
    }

    /**
     * 射击
     */
    @Override
    public void shoot() {
        //造成伤害
        Integer damage = RandomUtils.nextInt(super.getShooter().getMinPower(), super.getShooter().getMaxPower());
        super.getShooter().setNowSize(super.getShooter().getNowSize() - 1);
        log.info("使用[{}]进行射击，造成[{}]伤害！还剩余[{}]颗子弹。", super.getShooter().getName(), damage, super.getShooter().getNowSize());

        //如果剩余子弹为0，则转换为无子弹状态
        if (super.getShooter().getNowSize() == 0) {
            super.getShooter().setCurrentState(super.getShooter().getUnloadState());
        } else {
            //如果还有子弹，则有30%概率进入致死状态
            Integer score = RandomUtils.nextInt(0, 100);
            if (score < 30) {
                log.info("进入致死状态");
                super.getShooter().setCurrentState(super.getShooter().getDeadlyState());
            }
        }
    }
}
