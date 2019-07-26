package pers.hanchao.designpattern.responsibility.chain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>一轮面试</P>
 *
 * @author hanchao
 */
@AllArgsConstructor
public abstract class AbstractInterview {
    /**
     * 下一轮面试
     */
    @Getter
    private AbstractInterview interview;

    /**
     * 面试
     */
    public abstract String interview(String name);
}
