package pers.hanchao.designpattern.rule;

import java.text.DecimalFormat;
import java.util.Objects;

/**
 * <p>格式化工具类</P>
 *
 * @author hanchao
 */
public class FormatUtil {
    /**
     * 浮点数显示两位小数
     */
    public static String format(float number) {
        return new DecimalFormat("0.00").format(Objects.isNull(number) ? 0 : number);
    }
}
