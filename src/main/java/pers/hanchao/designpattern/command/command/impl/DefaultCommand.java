package pers.hanchao.designpattern.command.command.impl;

import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.command.command.Command;

/**
 * <p>默认命令</P>
 *
 * @author hanchao
 */
@Slf4j
public class DefaultCommand implements Command {

    /**
     * 执行命令
     */
    @Override
    public void execute() {
        log.info("什么也没有发生");
    }
}
