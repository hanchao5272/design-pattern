package pers.hanchao.designpattern.facade.worker;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>产品经理</P>
 *
 * @author hanchao
 */
@Slf4j
public class ProjectManager extends AbstractWorker {
    public ProjectManager(String name) {
        super(name, "项目经理");
    }

    public void makeProjectPlan() {
        log.info("「{}」({})制定了项目计划...", super.getName(), super.getJob());
    }

    public void analysisRequirement() {
        log.info("「{}」({})进行了需求分析...", super.getName(), super.getJob());
    }
}
