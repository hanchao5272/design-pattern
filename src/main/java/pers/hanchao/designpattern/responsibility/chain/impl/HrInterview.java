package pers.hanchao.designpattern.responsibility.chain.impl;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import pers.hanchao.designpattern.responsibility.chain.Interview;

/**
 * <p>HR面试</P>
 *
 * @author hanchao
 */
@Slf4j
@AllArgsConstructor
public class HrInterview implements Interview {
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
        //HR面试
        log.info("[{}]开始参加HR笔试", name);
        log.info("HR先聊了聊公司的背景、现状、前景...");
        log.info("[{}]反映很满意。");
        log.info("HR开始谈工资。");
        Integer percent = RandomUtils.nextInt(0, 50);
        if (percent <= 25) {
            log.info("[{}]期望工资涨幅为{}%，在HR承受范围内，通过了面试。", name, percent);
        } else {
            log.info("[{}]期望工资涨幅为{}%，超出HR承受范围内，未通过了面试。", name, percent);
            return "面试结果：未通过HR面试";
        }
        log.info("[{}]进入下一轮面试。", name);
        log.info("--------------------------------");
        return interview.interview(name);
    }
}
