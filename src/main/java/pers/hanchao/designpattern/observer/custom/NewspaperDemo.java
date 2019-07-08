package pers.hanchao.designpattern.observer.custom;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>报纸订阅测试</P>
 *
 * @author hanchao
 */
@Slf4j
public class NewspaperDemo {

    public static void main(String[] args) {
        //开始有2个人订阅报纸
        Newspaper newspaper = new Newspaper();
        newspaper.register(new User(1, "Lily"));
        User jack = new User(2, "Jack");
        newspaper.register(jack);

        //邮寄报纸
        newspaper.setMessage("中国青年报");
        newspaper.notifyObservers();
        System.out.println("--------------------------------------");

        //后来，有一个人取消了订阅报纸
        newspaper.remove(jack);
        //邮寄报纸
        newspaper.setMessage("环球时报");
        newspaper.notifyObservers();
    }
}
