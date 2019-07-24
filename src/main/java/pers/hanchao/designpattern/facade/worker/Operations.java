package pers.hanchao.designpattern.facade.worker;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>攻城狮</P>
 *
 * @author hanchao
 */
@Slf4j
public class Operations extends AbstractWorker {
    public Operations(String name) {
        super(name, "测试攻城狮");
    }

    public void operationAndMaintenance() {
        log.info("「{}」({})持续运维中...", super.getName(), super.getJob());
    }
}
