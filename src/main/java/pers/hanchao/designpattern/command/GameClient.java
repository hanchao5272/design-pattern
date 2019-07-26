package pers.hanchao.designpattern.command;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.command.command.Command;
import pers.hanchao.designpattern.command.command.impl.*;
import pers.hanchao.designpattern.command.invoker.KeyEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * <p>游戏客户端</P>
 *
 * @author hanchao
 */
@Slf4j
public class GameClient {

    /**
     * 假设共计32种游戏操作
     */
    private static final int MAX_SIZE = 32;

    /**
     * 快捷键列表
     */
    private static Map<KeyEnum, Command> commandMap = new HashMap<>(MAX_SIZE);

    static {
        //按键初始化:设置默认按键
        commandMap.put(KeyEnum.KEY_W, new RoleForwardCommand());
        commandMap.put(KeyEnum.KEY_SPACE, new RoleJumpCommand());
        commandMap.put(KeyEnum.KEY_B, new ShowPackCommand());
        commandMap.put(KeyEnum.KEY_V, new ShowSkillCommand());
        commandMap.put(KeyEnum.KEY_1, new ReleaseFireBallCommand());
        commandMap.put(KeyEnum.KEY_2, new ReleaseSneakCommand());
        commandMap.put(KeyEnum.KEY_NULL, new DefaultCommand());
    }

    /**
     * 需求一：通过按键进行快捷操作。
     */
    public static void press(KeyEnum key) {
        //如果旧的按键为空，则置为空按键
        if (Objects.isNull(key)) {
            key = KeyEnum.KEY_NULL;
        }

        log.info("按下了「{}」", key.name());
        //执行此按键
        Command command = commandMap.get(key);
        if (Objects.isNull(command)){
            command = new DefaultCommand();
        }
        command.execute();
        log.info("----------");
    }

    /**
     * 需求二：可以替换快捷键。
     */
    public static void setCustomKey(Command command, KeyEnum oldKey, KeyEnum newKey) {
        //如果旧的按键为空，则置为空按键
        if (Objects.isNull(oldKey)) {
            oldKey = KeyEnum.KEY_NULL;
        }

        //如果新的按键为空，则置为空按键
        if (Objects.isNull(newKey)) {
            newKey = KeyEnum.KEY_NULL;
        }


        log.info("将「{}」操作的快捷键进行替换：{} --> {}", command.getClass().getSimpleName(), oldKey.name(), newKey.name());

        //将旧按键绑定到默认操作
        if (!Objects.equals(oldKey, KeyEnum.KEY_NULL)) {
            commandMap.put(oldKey, new DefaultCommand());
        }

        //将新按键绑定到当前操作
        commandMap.put(newKey, command);
    }

    public static void main(String[] args) {
        //默认按键
        GameClient.press(KeyEnum.KEY_W);
        GameClient.press(KeyEnum.KEY_SPACE);
        System.out.println("==============================================================================================================");

        //将角色跳跃的快捷键进行替换
        GameClient.setCustomKey(new RoleJumpCommand(), KeyEnum.KEY_SPACE, KeyEnum.KEY_ENTER);
        GameClient.press(KeyEnum.KEY_SPACE);
        GameClient.press(KeyEnum.KEY_ENTER);
        System.out.println("==============================================================================================================");

        //自定义宏命令:角色前进、释放技能:潜行术、释放技能:火球术，并将其绑定在按键A
        GameClient.press(KeyEnum.KEY_A);
        List<Command> commandList = Lists.newArrayList(
                new RoleForwardCommand(), new ReleaseSneakCommand(), new ReleaseFireBallCommand()
        );
        GameClient.setCustomKey(new MacroCommand(commandList), null, KeyEnum.KEY_A);
        GameClient.press(KeyEnum.KEY_A);
    }

}
