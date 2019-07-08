package pers.hanchao.designpattern.observer.origin;

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
        newspaper.subscribe(new User(1, "Lily"));
        User jack = new User(2, "Jack");
        newspaper.subscribe(jack);

        //邮寄报纸
        newspaper.setMessage("中国青年报");
        newspaper.mailNewspaperToSubscribers();
        System.out.println("--------------------------------------");

        //后来，有一个人取消了订阅报纸
        newspaper.cancel(jack);
        //邮寄报纸
        newspaper.setMessage("环球时报");
        newspaper.mailNewspaperToSubscribers();
    }
}
