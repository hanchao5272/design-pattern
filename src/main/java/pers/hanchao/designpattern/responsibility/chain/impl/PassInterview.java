package pers.hanchao.designpattern.responsibility.chain.impl;

import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.responsibility.chain.Interview;

/**
 * <p>面试通过</P>
 *
 * @author hanchao
 */
@Slf4j
public class PassInterview implements Interview {
    /**
     * 面试
     *
     * @param name
     */
    @Override
    public String interview(String name) {
        log.info("[{}]通过了所有面试，恭喜你！", name);
        return "通过了所有面试，恭喜你！";
    }
}
