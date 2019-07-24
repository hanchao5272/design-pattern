package pers.hanchao.designpattern.template;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

/**
 * <p></P>
 *
 * @author hanchao
 */
@Slf4j
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public abstract class AbstractResume {
    /**
     * 姓名
     */
    @Getter
    @NonNull
    private String name;

    /**
     * 是否填写家庭成员
     */
    private boolean fillInFamily = false;

    /**
     * 是否填写其他
     */
    private boolean fillInOther = false;

    /**
     * 显示简历
     */
    public final void fillIn() {
        log.info("=====「{}」开始填写简历=====", name);

        //基本信息
        log.info("-----基本信息如下-----");
        fillInBasic();

        //教育背景
        log.info("-----教育背景如下-----");
        fillInEducation();

        //家庭成员
        if (fillInFamily) {
            log.info("-----家庭成员如下-----");
            fillInFamily();
        }

        //项目经历
        log.info("-----项目经历如下-----");
        fillInProject();

        //自我总结
        log.info("-----自我总结如下-----");
        fillInSummary();

        //其他
        if (fillInOther) {
            log.info("-----其他如下-----");
            fillInOther();
        }
    }

    /**
     * 填写基本情况
     */
    protected void fillInBasic() {
        log.info("基本情况填写开始：");
        log.info("「{}」开始填写姓名...", name);
        log.info("「{}」开始填写性别...", name);
        log.info("「{}」开始填写出生日期...", name);
        log.info("「{}」开始填写籍贯...", name);
        log.info("「{}」开始填写政治身份...", name);
    }

    /**
     * 填写教育背景
     */
    protected void fillInEducation() {
        log.info("教育背景要求填写本科以上教育经历。");
        log.info("「{}」教育背景填写开始：", name);
        if (RandomUtils.nextBoolean()) {
            log.info("「{}」填写了本科阶段的求学经历...", name);
            if (RandomUtils.nextBoolean()) {
                log.info("「{}」填写了研究生阶段的求学经历...", name);
                if (RandomUtils.nextBoolean()) {
                    log.info("「{}」填写了博士阶段的求学经历...", name);
                }
            }
        }
        log.info("「{}」教育背景填写完成。", name);
    }

    /**
     * 填写家庭成员
     */
    protected void fillInFamily() {
        log.info("家庭成员要求填写父母、兄弟姐妹和儿女的情况。");
        log.info("「{}」家庭成员填写开始：", name);
        if (RandomUtils.nextBoolean()) {
            log.info("「{}」填写了父母的基本情况...", name);
        }
        if (RandomUtils.nextBoolean()) {
            log.info("「{}」填写了兄弟姐妹的基本情况...", name);
        }
        if (RandomUtils.nextBoolean()) {
            log.info("「{}」填写了儿女的基本情况...", name);
        }
        log.info("「{}」家庭成员填写完成。", name);
    }

    /**
     * 填写项目经验
     */
    protected void fillInProject() {
        log.info("项目经验要求控制在5条以内。");
        log.info("「{}」家庭成员填写开始：", name);
        for (int i = 0; i < RandomUtils.nextInt(2, 8) && i < 5; i++) {
            log.info("「{}」填写了第「{}」条项目经验...", name, 1 + i);
        }
        log.info("「{}」项目经验填写完成。", name);
    }

    /**
     * 填写个人总结
     */
    protected void fillInSummary() {
        log.info("个人总结要求在20~100字内。");
        log.info("「{}」个人总结填写开始：", name);
        log.info("「{}」填写了「{}」个字...", name, RandomUtils.nextInt(20, 100));
        log.info("「{}」个人总结填写完成。", name);
    }

    /**
     * 其他
     */
    protected abstract void fillInOther();
}
