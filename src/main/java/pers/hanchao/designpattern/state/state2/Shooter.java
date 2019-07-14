package pers.hanchao.designpattern.state.state2;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.state.state2.state.State;
import pers.hanchao.designpattern.state.state2.state.impl.DeadlyState;
import pers.hanchao.designpattern.state.state2.state.impl.LoadedState;
import pers.hanchao.designpattern.state.state2.state.impl.UnloadState;

/**
 * <p>射击武器</P>
 *
 * @author hanchao
 */
@Getter
@Setter
@Slf4j
public class Shooter {
    /**
     * 武器名称
     */
    @NonNull
    private String name;

    /**
     * 武器下限
     */
    @NonNull
    private Integer minPower;

    /**
     * 武器上限
     */
    @NonNull
    private Integer maxPower;

    /**
     * 弹匣大小
     */
    @NonNull
    private Integer maxSize;

    /**
     * 剩余子弹数
     */
    private Integer nowSize;

    /**
     * 当前枪械状态
     */
    private State currentState;

    /**
     * 有子弹状态
     */
    private State loadedState;

    /**
     * 无子弹状态
     */
    private State unloadState;

    /**
     * 致死状态
     */
    private State deadlyState;


    public Shooter(@NonNull String name, @NonNull Integer minPower, @NonNull Integer maxPower, @NonNull Integer maxSize) {
        this.name = name;
        this.minPower = minPower;
        this.maxPower = maxPower;
        this.maxSize = maxSize;
        this.nowSize = maxSize;
        log.info("-----------------------------------");
        log.info("得到一把[{}]，伤害范围[{} ~ {}]，弹匣大小[{}]。", name, minPower, maxPower, maxSize);

        //状态初始化
        loadedState = new LoadedState(this);
        unloadState = new UnloadState(this);
        deadlyState = new DeadlyState(this);
        currentState = loadedState;
    }

    /**
     * 射击
     */
    public void shoot() {
        currentState.shoot();
    }

    /**
     * 填充子弹
     */
    public void fill() {
        currentState.fill();
    }

    public static void main(String[] args) {
        //手枪：沙漠孤鹰
        Shooter shooter = new Shooter("Desert-Eagle", 30, 45, 2);
        shooter.shoot();
        shooter.shoot();
        shooter.shoot();
        shooter.fill();
        shooter.fill();
        shooter.shoot();

        //突击步枪：AK-47
        shooter = new Shooter("AK-47", 50, 66, 10);
        shooter.shoot();
        shooter.shoot();
        shooter.shoot();
        shooter.shoot();
        shooter.shoot();
        shooter.shoot();
        shooter.shoot();
        shooter.shoot();
        shooter.shoot();
        shooter.shoot();
        shooter.shoot();
        shooter.shoot();
        shooter.fill();
    }
}
