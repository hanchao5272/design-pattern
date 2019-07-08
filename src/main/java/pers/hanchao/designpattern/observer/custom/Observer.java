package pers.hanchao.designpattern.observer.custom;

/**
 * <p>观察者</P>
 *
 * @author hanchao
 */
public interface Observer {
    /**
     * 消息更新
     */
    void update(String message);
}
