package pers.hanchao.designpattern.facade.worker;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>测试攻城狮</P>
 *
 * @author hanchao
 */
@Slf4j
public class QualityAssurance extends AbstractWorker {
    public QualityAssurance(String name) {
        super(name, "测试攻城狮");
    }

    public void test() {
        log.info("「{}」({})开始进行测试...", super.getName(), super.getJob());
    }
}
