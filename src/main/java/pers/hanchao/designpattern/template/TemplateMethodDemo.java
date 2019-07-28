package pers.hanchao.designpattern.template;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>client</P>
 *
 * @author hanchao
 */
@Slf4j
public class TemplateMethodDemo {
    public static void main(String[] args) {
        //普通简历模板的填写
        AbstractResume resume = new CustomResume("张三");
        resume.fillIn();

        log.info("==================================");

        //特殊建立模板的填写
        resume = new SpecialResume("李四");
        resume.fillIn();
    }
}
