package pers.hanchao.designpattern.command.receiver;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>游戏角色：命令接受者 Receiver 命令的真正执行者</P>
 *
 * @author hanchao
 */
@Slf4j
public class Role {

    /**
     * 前进
     */
    public static void forward() {
        log.info("角色前进");
    }

    /**
     * 跳跃
     */
    public static void jump() {
        log.info("角色跳跃");
    }
}
