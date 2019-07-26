package pers.hanchao.designpattern.command.command.impl;

import pers.hanchao.designpattern.command.command.Command;
import pers.hanchao.designpattern.command.receiver.SkillHandler;

/**
 * <p>命令：释放技能：潜行术</P>
 *
 * @author hanchao
 */
public class ReleaseSneakCommand implements Command {

    /**
     * 执行命令
     */
    @Override
    public void execute() {
        SkillHandler.sneak();
    }
}
