package pers.hanchao.designpattern.command.command.impl;

import pers.hanchao.designpattern.command.command.Command;
import pers.hanchao.designpattern.command.receiver.UiHandler;

/**
 * <p>命令：打开背包界面</P>
 *
 * @author hanchao
 */
public class ShowPackCommand implements Command {

    /**
     * 执行命令
     */
    @Override
    public void execute() {
        UiHandler.showPack();
    }
}
