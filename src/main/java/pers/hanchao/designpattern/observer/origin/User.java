package pers.hanchao.designpattern.observer.origin;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>用户</P>
 *
 * @author hanchao
 */
@Setter
@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Slf4j
public class User {
    /**
     * 用户编号
     */
    private Integer id;
    /**
     * 用户名称
     */
    private String name;

    /**
     * 签收报纸
     */
    public void receiveNewspaper(String message) {
        log.info("{} Received Newspaper [{}].", name, message);
    }
}
