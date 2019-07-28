package pers.hanchao.designpattern.command.client;

import com.google.common.collect.Lists;
import pers.hanchao.designpattern.command.KeyEnum;
import pers.hanchao.designpattern.command.command.Command;
import pers.hanchao.designpattern.command.command.impl.*;
import pers.hanchao.designpattern.command.invoker.KeyManager;

import java.util.List;

/**
 * <p>客户端</P>
 *
 * @author hanchao
 */
public class GameClientDemo {

    public static void main(String[] args) {
        //默认按键
        KeyManager.press(KeyEnum.KEY_W);
        KeyManager.press(KeyEnum.KEY_SPACE);
        System.out.println("==============================================================================================================");

        //将角色跳跃的快捷键进行替换
        KeyManager.setCustomKey(new RoleJumpCommand(), KeyEnum.KEY_SPACE, KeyEnum.KEY_ENTER);
        KeyManager.press(KeyEnum.KEY_SPACE);
        KeyManager.press(KeyEnum.KEY_ENTER);
        System.out.println("==============================================================================================================");

        //自定义宏命令:角色前进、释放技能:潜行术、释放技能:火球术，并将其绑定在按键A
        KeyManager.press(KeyEnum.KEY_A);
        List<Command> commandList = Lists.newArrayList(
                new RoleForwardCommand(), new ReleaseSneakCommand(), new ReleaseFireBallCommand()
        );
        KeyManager.setCustomKey(new MacroCommand(commandList), null, KeyEnum.KEY_A);
        KeyManager.press(KeyEnum.KEY_A);
    }
}
