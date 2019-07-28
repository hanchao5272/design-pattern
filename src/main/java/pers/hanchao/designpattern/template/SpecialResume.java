package pers.hanchao.designpattern.template;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>一种特殊简历模板：需要填写家庭成员和其他，并且自定义了基本信息</P>
 *
 * @author hanchao
 */
@Slf4j
public class SpecialResume extends AbstractResume {
    public SpecialResume(@NonNull String name) {
        super(name, true, true);
    }

    /**
     * 填写基本情况
     */
    @Override
    protected void fillInBasic() {
        super.fillInBasic();
        log.info("「{}」开始填写现居地...", super.getName());
        log.info("「{}」开始填写工作年限...", super.getName());
        log.info("「{}」开始填写是否已婚...", super.getName());
    }

    /**
     * 其他
     */
    @Override
    protected void fillInOther() {
        log.info("「{}」开始填写兴趣爱好...", super.getName());
    }
}
