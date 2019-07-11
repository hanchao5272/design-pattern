package pers.hanchao.designpattern.responsibility.chain.impl;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import pers.hanchao.designpattern.responsibility.chain.Interview;

/**
 * <p>技术面试</P>
 *
 * @author hanchao
 */
@Slf4j
@AllArgsConstructor
public class TechnicalInterview implements Interview {
    /**
     * 下一轮面试
     */
    @Setter
    private Interview interview;

    /**
     * 面试
     */
    @Override
    public String interview(String name) {
        //技术面试
        log.info("[{}]开始参加技术面试", name);
        log.info("技术面试官先问了一些基础知识");
        Boolean pass = RandomUtils.nextBoolean();
        if (pass) {
            log.info("[{}]基础知识回答得很完美，继续技术面试。", name);
        } else {
            log.info("[{}]基础知识掌握的很差，未通过了笔试。", name);
            return "面试结果：未通过技术面试";
        }
        log.info("技术面试官又问了一些高级知识");
        pass = RandomUtils.nextBoolean();
        if (pass) {
            log.info("[{}]高级知识回答得马马虎虎，继续技术面试。", name);
        } else {
            log.info("[{}]高级知识简直是不懂装通，未通过了笔试。", name);
            return "面试结果：未通过技术面试";
        }

        log.info("[{}]进入下一轮面试。", name);
        log.info("--------------------------------");
        return interview.interview(name);
    }
}
