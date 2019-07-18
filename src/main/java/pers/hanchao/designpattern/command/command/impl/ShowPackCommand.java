package pers.hanchao.designpattern.command.command.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.command.command.Command;
import pers.hanchao.designpattern.command.receiver.UiHandler;

/**
 * <p>命令：打开背包界面</P>
 *
 * @author hanchao
 */
@Slf4j
@AllArgsConstructor
public class ShowPackCommand implements Command {
    private UiHandler uiHandler;

    /**
     * 执行命令
     */
    @Override
    public void execute() {
        uiHandler.showPack();
    }
}
