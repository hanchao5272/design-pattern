package pers.hanchao.designpattern.command.command.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.command.command.Command;
import pers.hanchao.designpattern.command.receiver.Role;

/**
 * <p>命令：跳跃</P>
 *
 * @author hanchao
 */
@Slf4j
@AllArgsConstructor
public class RoleJumpCommand implements Command {
    private Role role;

    /**
     * 执行命令
     */
    @Override
    public void execute() {
        role.jump();
    }
}
