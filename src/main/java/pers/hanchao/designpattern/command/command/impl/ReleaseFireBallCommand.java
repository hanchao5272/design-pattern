package pers.hanchao.designpattern.command.command.impl;

import pers.hanchao.designpattern.command.command.Command;
import pers.hanchao.designpattern.command.receiver.SkillHandler;

/**
 * <p>命令：释放技能：火球术</P>
 *
 * @author hanchao
 */
public class ReleaseFireBallCommand implements Command {

    /**
     * 执行命令
     */
    @Override
    public void execute() {
        SkillHandler.fireBall();
    }
}
