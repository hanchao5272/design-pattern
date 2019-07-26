package pers.hanchao.designpattern.command.command.impl;

import pers.hanchao.designpattern.command.command.Command;
import pers.hanchao.designpattern.command.receiver.Role;

/**
 * <p>命令：跳跃</P>
 *
 * @author hanchao
 */
public class RoleJumpCommand implements Command {

    /**
     * 执行命令
     */
    @Override
    public void execute() {
        Role.jump();
    }
}
