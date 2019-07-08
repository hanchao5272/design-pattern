package pers.hanchao.designpattern.observer.origin;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>报纸</P>
 *
 * @author hanchao
 */
@Slf4j
public class Newspaper {
    /**
     * 订阅者列表
     */
    private Set<User> userSet;

    /**
     * 报纸信息
     */
    @Setter
    private String message;

    public Newspaper() {
        userSet = new HashSet<>();
    }

    /**
     * 订阅
     */
    public void subscribe(User user) {
        userSet.add(user);
    }

    /**
     * 取消订阅
     */
    public void cancel(User user) {
        userSet.remove(user);
    }

    /**
     * 向所有订阅者邮寄报纸
     */
    public void mailNewspaperToSubscribers() {
        userSet.forEach(user -> user.receiveNewspaper(message));
    }
}
