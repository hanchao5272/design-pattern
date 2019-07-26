package pers.hanchao.designpattern.command.command.impl;

import lombok.AllArgsConstructor;
import pers.hanchao.designpattern.command.command.Command;

import java.util.List;

/**
 * <p>宏命令</P>
 * <p>
 * 需求三：可以自定义宏命令，一个宏命令可以进行多个操作。
 *
 * @author hanchao
 */
@AllArgsConstructor
public class MacroCommand implements Command {

    /**
     * 宏命令列表
     */
    private List<Command> commandList;

    /**
     * 执行命令
     */
    @Override
    public void execute() {
        //依次执行命令
        for (Command command : commandList) {
            command.execute();
        }
    }
}
