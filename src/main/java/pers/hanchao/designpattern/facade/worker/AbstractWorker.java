package pers.hanchao.designpattern.facade.worker;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>打工者</P>
 *
 * @author hanchao
 */
@AllArgsConstructor
@Getter
public abstract class AbstractWorker {
    /**
     * 姓名
     */
    private String name;

    /**
     * 职位
     */
    private String job;
}
