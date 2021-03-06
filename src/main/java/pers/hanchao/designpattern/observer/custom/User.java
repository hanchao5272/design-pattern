package pers.hanchao.designpattern.observer.custom;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>用户</P>
 *
 * @author hanchao
 */
@AllArgsConstructor
@Slf4j
@ToString
@EqualsAndHashCode
public class User  implements Observer{
    /**
     * 用户编号
     */
    @Setter
    @Getter
    private Integer id;
    /**
     * 用户名称
     */
    @Setter
    @Getter
    private String name;

    /**
     * 签收报纸
     */
    @Override
    public void update(String message) {
        log.info("{} Received Newspaper [{}].", name, message);
    }
}
