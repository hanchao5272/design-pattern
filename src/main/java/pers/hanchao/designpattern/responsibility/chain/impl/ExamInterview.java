package pers.hanchao.designpattern.responsibility.chain.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import pers.hanchao.designpattern.responsibility.chain.AbstractInterview;

/**
 * <p>笔试</P>
 *
 * @author hanchao
 */
@Slf4j
public class ExamInterview extends AbstractInterview {

    public ExamInterview(AbstractInterview interview) {
        super(interview);
    }

    /**
     * 面试
     */
    @Override
    public String interview(String name) {
        //笔试
        log.info("[{}]开始参加笔试", name);
        log.info("此轮笔试共计10道选择题，5到机试题，共计100分，答题时间60分钟。");
        Integer score = RandomUtils.nextInt(40, 100);
        if (score >= 60) {
            log.info("[{}]笔试得分为{}，通过了笔试。", name, score);
        } else {
            log.info("[{}]笔试得分为{}，未通过了笔试。", name, score);
            return "面试结果：未通过笔试";
        }
        log.info("[{}]进入下一轮面试。", name);
        log.info("--------------------------------");
        return super.getInterview().interview(name);
    }
}
