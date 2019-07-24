package pers.hanchao.designpattern.facade.worker;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>开发攻城狮</P>
 *
 * @author hanchao
 */
@Slf4j
public class DevelopmentEngineer extends AbstractWorker {
    public DevelopmentEngineer(String name,String job) {
        super(name, job);
    }

    public void develop() {
        log.info("「{}」({})开始进行研发...", super.getName(), super.getJob());
    }
}
