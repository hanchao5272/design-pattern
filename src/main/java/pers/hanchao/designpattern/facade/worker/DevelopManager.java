package pers.hanchao.designpattern.facade.worker;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>开发经理</P>
 *
 * @author hanchao
 */
@Slf4j
public class DevelopManager extends AbstractWorker {
    public DevelopManager(String name) {
        super(name, "开发经理");
    }

    public void makeDevelopmentPlan() {
        log.info("「{}」({})制定了研发计划...", super.getName(), super.getJob());
    }
}
