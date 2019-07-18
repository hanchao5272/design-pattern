package pers.hanchao.designpattern.command.command.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.command.command.Command;
import pers.hanchao.designpattern.command.receiver.SkillHandler;

/**
 * <p>命令：释放技能：火球术</P>
 *
 * @author hanchao
 */
@Slf4j
@AllArgsConstructor
public class ReleasFireBallCommand implements Command {
    private SkillHandler skillHandler;

    /**
     * 执行命令
     */
    @Override
    public void execute() {
        skillHandler.fireBall();
    }
}
