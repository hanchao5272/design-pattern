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
    public void fireBall() {
        log.info("酝酿1秒钟");
        log.info("释放法术：火球 火球 火球 火球 火球 ");
    }

    /**
     * 释放技能-潜行
     */
    public void sneak() {
        log.info("头巾蒙面");
        log.info("潜行");
    }
}
