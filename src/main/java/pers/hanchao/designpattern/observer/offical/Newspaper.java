package pers.hanchao.designpattern.observer.offical;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Observable;
import java.util.Observer;

/**
 * <p>报纸</P>
 *
 * @author hanchao
 */
@Slf4j
public class Newspaper extends Observable {

    /**
     * 报纸信息
     */
    @Setter
    private String message;

    /**
     * 订阅
     * Adds an observer to the set of observers for this object, provided
     * that it is not the same as some observer already in the set.
     * The order in which notifications will be delivered to multiple
     * observers is not specified. See the class comment.
     *
     * @param o an observer to be added.
     * @throws NullPointerException if the parameter o is null.
     */
    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }

    /**
     * 取消订阅
     * Deletes an observer from the set of observers of this object.
     * Passing <CODE>null</CODE> to this method will have no effect.
     *
     * @param o the observer to be deleted.
     */
    @Override
    public synchronized void deleteObserver(Observer o) {
        super.deleteObserver(o);
    }

    /**
     * 向所有订阅者邮寄报纸
     * If this object has changed, as indicated by the
     * <code>hasChanged</code> method, then notify all of its observers
     * and then call the <code>clearChanged</code> method to indicate
     * that this object has no longer changed.
     * <p>
     * Each observer has its <code>update</code> method called with two
     * arguments: this observable object and the <code>arg</code> argument.
     *
     * @see Observable#clearChanged()
     * @see Observable#hasChanged()
     * @see Observer#update(Observable, Object)
     */
    @Override
    public void notifyObservers() {
        super.notifyObservers(message);
    }

    /**
     * 标记确定要邮件报纸
     * Marks this <tt>Observable</tt> object as having been changed; the
     * <tt>hasChanged</tt> method will now return <tt>true</tt>.
     */
    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }
}
