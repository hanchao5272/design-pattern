package pers.hanchao.designpattern.template;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>普通简历模板: 无需显示家庭成员和其他</P>
 *
 * @author hanchao
 */
@Slf4j
public class CustomResume extends AbstractResume {
    public CustomResume(@NonNull String name) {
        super(name, false, false);
    }
}
