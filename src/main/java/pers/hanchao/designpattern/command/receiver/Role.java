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
    public void forward() {
        log.info("前进");
    }

    /**
     * 跳跃
     */
    public void jump() {
        log.info("跳跃");
    }
}
