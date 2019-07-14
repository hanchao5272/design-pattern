package pers.hanchao.designpattern.state.origin1;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

/**
 * <p>射击武器</P>
 *
 * @author hanchao
 */
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
     * 枪械状态
     */
    private Integer state;

    public Shooter(@NonNull String name, @NonNull Integer minPower, @NonNull Integer maxPower, @NonNull Integer maxSize) {
        this.name = name;
        this.minPower = minPower;
        this.maxPower = maxPower;
        this.maxSize = maxSize;
        this.nowSize = maxSize;
        this.state = STATE_LOADED;
        log.info("-----------------------------------");
        log.info("得到一把[{}]，伤害范围[{} ~ {}]，弹匣大小[{}]。", name, minPower, maxPower, maxSize);
    }

    /**
     * 枪械状态-已装载子弹
     */
    public static final int STATE_LOADED = 0;

    /**
     * 枪械状态-未装载子弹
     */
    public static final int STATE_UNLOAD = 1;

    /**
     * 射击
     */
    public void shoot() {
        //如果有子弹，则直接释放
        if (STATE_LOADED == state) {
            //造成伤害
            Integer damage = RandomUtils.nextInt(minPower, maxPower);
            log.info("使用[{}]进行射击，造成[{}]伤害！还剩余[{}]颗子弹。", name, damage, --nowSize);

            //如果剩余子弹为0，则转换为无子弹状态
            if (nowSize == 0) {
                state = STATE_UNLOAD;
            }
        } else {
            //如果无子弹，则提示
            log.info("[{}]没有子弹了，请填充！！！", name);
        }
    }

    /**
     * 填充子弹
     */
    public void fill() {
        log.info("[{}]当前共[{}]发子弹，填充了[{}]发子弹。", name, nowSize, (maxSize - nowSize));
        nowSize = maxSize;
        state = STATE_LOADED;
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
        shooter = new Shooter("AK-47", 80, 95, 3);
        shooter.shoot();
        shooter.shoot();
        shooter.shoot();
        shooter.shoot();
        shooter.shoot();
        shooter.fill();
    }
}
