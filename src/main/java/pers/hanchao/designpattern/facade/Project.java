package pers.hanchao.designpattern.facade;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.facade.worker.*;

import java.util.List;

/**
 * <p>项目开发</P>
 *
 * @author hanchao
 */
@Slf4j
@RequiredArgsConstructor
public class Project {
    /**
     * 项目名称
     */
    @NonNull
    private String name;

    /**
     * 产品经理
     */
    @NonNull
    private ProjectManager projectManager;

    /**
     * 开发经理
     */
    @NonNull
    private DevelopManager developManager;

    /**
     * 开发攻城狮们
     */
    @NonNull
    private List<DevelopmentEngineer> engineerList;

    /**
     * 测试攻城狮
     */
    @NonNull
    private List<QualityAssurance> assuranceList;

    /**
     * 运维攻城狮
     */
    @NonNull
    private List<Operations> operationsList;

    /**
     * 开发过程
     */
    public void developProject() {
        log.info("「{}」项目启动...", name);
        log.info("-----------------------------");
        //指定计划
        projectManager.makeProjectPlan();

        //需求分析
        projectManager.analysisRequirement();

        //软件设计
        developManager.makeDevelopmentPlan();

        //程序编写
        engineerList.forEach(DevelopmentEngineer::develop);

        //软件测试
        assuranceList.forEach(QualityAssurance::test);

        //运行维护
        operationsList.forEach(Operations::operationAndMaintenance);

        log.info("-----------------------------");
        log.info("「{}」项目完成...", name);
    }
}