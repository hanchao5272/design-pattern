package pers.hanchao.designpattern.command.receiver;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>游戏界面：命令接受者 Receiver 命令的真正执行者</P>
 *
 * @author hanchao
 */
@Slf4j
public class UiHandler {
    /**
     * 打开背包界面
     */
    public void showPack() {
        log.info("打开背包界面");
        log.info("背包中现在有：2个面包，3棵草药，5块矿石...");
    }

    /**
     * 打开技能界面
     */
    public void showSkill() {
        log.info("打开技能界面");
        log.info("已掌握的技能有：暗影之舞，剑刃风暴，神圣之光...");

    }

}
