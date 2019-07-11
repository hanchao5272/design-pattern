package pers.hanchao.designpattern.responsibility.origin;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

/**
 * <p>超级面试类</P>
 *
 * @author hanchao
 */
@Slf4j
public class SuperInterview {
    /**
     * 针对普通求职者的面试过程
     */
    public static String customInterview(String name) {
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

        log.info("[{}]通过了所有面试，恭喜你！", name);
        return "通过了所有面试，恭喜你！";
    }

    /**
     * 针对高级求职者的面试过程
     */
    public static String advancedInterview(String name) {
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

        log.info("[{}]通过了所有面试，恭喜你！", name);
        return "通过了所有面试，恭喜你！";
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            SuperInterview.customInterview("求职者" + i);
            System.out.println();
        }
    }
}
