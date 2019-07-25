package pers.hanchao.designpattern.observer.offical;

import lombok.extern.slf4j.Slf4j;

import java.util.Observer;

/**
 * <p>报纸订阅测试</P>
 *
 * @author hanchao
 */
@Slf4j
public class NewspaperDemo {

    public static void main(String[] args) {
        //开始有2个人订阅报纸
        //Observable newspaper = new Newspaper(); 不能这么用
        Newspaper newspaper = new Newspaper();
        newspaper.addObserver(new User(1, "Lily"));
        Observer jack = new User(2, "Jack");
        newspaper.addObserver(jack);

        //邮寄报纸
        newspaper.setMessage("中国青年报");
        newspaper.setChanged();
        newspaper.notifyObservers();
        System.out.println("--------------------------------------");

        //换一份报纸
        //邮寄报纸
        newspaper.setMessage("环球时报");
        newspaper.notifyObservers();
    }
}
