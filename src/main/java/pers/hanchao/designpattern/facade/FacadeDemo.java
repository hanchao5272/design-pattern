package pers.hanchao.designpattern.facade;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.facade.worker.*;

import java.util.Collections;
import java.util.List;

/**
 * <p>客户端</P>
 *
 * @author hanchao
 */
@Slf4j
public class FacadeDemo {
    public static void main(String[] args) {
        //产品经理
        ProjectManager projectManager = new ProjectManager("扫地僧");
        //开发经理
        DevelopManager developManager = new DevelopManager("张三丰");
        //开发攻城狮们
        List<DevelopmentEngineer> engineerList = Lists.newArrayList(
                new DevelopmentEngineer("令狐冲", "前端开发攻城狮"),
                new DevelopmentEngineer("张无忌", "后端开发攻城狮")
        );
        //测试攻城狮们
        List<QualityAssurance> assuranceList = Lists.newArrayList(
                new QualityAssurance("小龙女")
        );
        //运维攻城狮们
        List<Operations> operationsList = Lists.newArrayList(
            new Operations("鸠摩智"),
            new Operations("欧阳锋")
        );

        //项目一
        new Project("武林群侠传项目", projectManager, developManager, engineerList, assuranceList, operationsList).developProject();

        log.info("=============================");

        //项目二
        new Project("入职项目", projectManager, developManager,
                Collections.singletonList(new DevelopmentEngineer("小虾米", "前端开发攻城狮")),
                Collections.singletonList(new QualityAssurance("小虾米")),
                Collections.singletonList(new Operations("小虾米"))).developProject();
    }
}
