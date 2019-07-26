package pers.hanchao.designpattern.command.command.impl;

import pers.hanchao.designpattern.command.command.Command;
import pers.hanchao.designpattern.command.receiver.UiHandler;

/**
 * <p>命令：打开技能界面</P>
 *
 * @author hanchao
 */
public class ShowSkillCommand implements Command {

    /**
     * 执行命令
     */
    @Override
    public void execute() {
        UiHandler.showSkill();
    }
}
