package pers.hanchao.designpattern.responsibility.chain;

import pers.hanchao.designpattern.responsibility.chain.impl.ExamInterview;
import pers.hanchao.designpattern.responsibility.chain.impl.HrInterview;
import pers.hanchao.designpattern.responsibility.chain.impl.PassInterview;
import pers.hanchao.designpattern.responsibility.chain.impl.TechnicalInterview;

/**
 * <p></P>
 *
 * @author hanchao
 */
public class SuperInterview {

    /**
     * 针对普通求职者的面试过程
     */
    public static void customInterview(String name) {
        new ExamInterview(new TechnicalInterview(new HrInterview(new PassInterview()))).interview(name);
    }

    /**
     * 针对高级求职者的面试过程
     */
    public static void advancedInterview(String name) {
        new TechnicalInterview(new HrInterview(new PassInterview())).interview(name);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            SuperInterview.customInterview("求职者" + i);
            System.out.println();
        }
    }
}
