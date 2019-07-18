package pers.hanchao.designpattern.rule.rule6;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>商品</P>
 *
 * @author hanchao
 */
@Setter
@Getter
@AllArgsConstructor
public class Goods {
    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品价格
     */
    private float price;

    /**
     * 折扣
     */
    private float discount;

    /**
     * 会员折扣
     */
    private float vipDiscount;

    /**
     * 计算最终价格（把价格计算放在自己的类中，不然别的类知道）
     */
    public float getFinalPrice() {
        return price * discount * vipDiscount;
    }
}
