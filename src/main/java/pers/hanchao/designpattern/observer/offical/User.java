package pers.hanchao.designpattern.observer.offical;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Observable;
import java.util.Observer;

/**
 * <p>用户</P>
 *
 * @author hanchao
 */
@AllArgsConstructor
@Slf4j
@ToString
@EqualsAndHashCode
public class User implements Observer {
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
     * This method is called whenever the observed object is changed. An
     * application calls an <tt>Observable</tt> object's
     * <code>notifyObservers</code> method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     */
    @Override
    public void update(Observable o, Object arg) {
        log.info("{} Received Newspaper [{}].", name, arg.toString());
    }
}
