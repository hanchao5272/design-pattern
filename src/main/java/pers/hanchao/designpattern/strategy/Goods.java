package pers.hanchao.designpattern.strategy;

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
    private Float price;
}
