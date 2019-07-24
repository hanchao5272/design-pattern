package pers.hanchao.designpattern.facade;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
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
    private ProjectManager PM = new ProjectManager("诸葛经理");

    /**
     * 开发经理
     */
    private DevelopManager DM = new DevelopManager("东方经理");

    /**
     * 开发攻城狮们
     */
    private List<DevelopmentEngineer> engineerList = Lists.newArrayList(
            new DevelopmentEngineer("张三", "前端开发攻城狮"),
            new DevelopmentEngineer("李四", "后端开发攻城狮")
    );

    /**
     * 测试攻城狮
     */
    private QualityAssurance QA = new QualityAssurance("王五");

    /**
     * 运维攻城狮
     */
    private Operations OP = new Operations("赵六");

    /**
     * 开发过程
     */
    public void developProject() {
        log.info("「{}」项目启动...",name);
        log.info("-----------------------------");
        //指定计划
        PM.makeProjectPlan();

        //需求分析
        PM.analysisRequirement();

        //软件设计
        DM.makeDevelopmentPlan();

        //程序编写
        engineerList.forEach(DevelopmentEngineer::develop);

        //软件测试
        QA.test();

        //运行维护
        OP.operationAndMaintenance();

        log.info("-----------------------------");
        log.info("「{}」项目完成...",name);
    }

    public static void main(String[] args) {
        Project project = new Project("购物网站项目");
        project.developProject();
    }
}
