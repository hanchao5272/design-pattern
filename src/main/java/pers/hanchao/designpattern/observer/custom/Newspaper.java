package pers.hanchao.designpattern.observer.custom;

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
public class Newspaper implements Subject {
    /**
     * 订阅者列表
     */
    private Set<Observer> observerSet;

    /**
     * 报纸信息
     */
    @Setter
    private String message;

    public Newspaper() {
        observerSet = new HashSet<>();
    }

    /**
     * 订阅
     *
     * @param observer 订阅者
     */
    @Override
    public void register(Observer observer) {
        observerSet.add(observer);
    }

    /**
     * 取消订阅
     *
     * @param observer 订阅者
     */
    @Override
    public void remove(Observer observer) {
        observerSet.remove(observer);
    }

    /**
     * 向所有订阅者邮寄报纸
     */
    @Override
    public void notifyObservers() {
        observerSet.forEach(user -> user.update(message));
    }
}
