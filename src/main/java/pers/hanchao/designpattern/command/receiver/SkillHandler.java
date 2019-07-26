package pers.hanchao.designpattern.command.receiver;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>技能管理器：命令接受者 Receiver 命令的真正执行者</P>
 *
 * @author hanchao
 */
@Slf4j
public class SkillHandler {

    /**
     * 释放技能-五火球神术
     */
    public static void fireBall() {
        log.info("释放技能:火球术...酝酿1秒钟...砰! 砰!! 砰!!!");
    }

    /**
     * 释放技能-潜行
     */
    public static void sneak() {
        log.info("释放技能:潜行术...蒙面...抛出烟雾弹...不见了!");
    }
}
