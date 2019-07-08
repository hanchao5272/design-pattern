package pers.hanchao.designpattern.observer.custom;

/**
 * <p>主题</P>
 *
 * @author hanchao
 */
public interface Subject {
    /**
     * 注册
     */
    void register(Observer observer);

    /**
     * 取消注册
     */
    void remove(Observer observer);

    /**
     * 通知观察者们
     */
    void notifyObservers();
}
