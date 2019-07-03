package pers.hanchao.designpattern.strategy.ordinary;

import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.strategy.Goods;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>购物车(普通版本)</P>
 *
 * @author hanchao
 */
@Slf4j
public class OrdinaryShoppingCart {
    /**
     * 商品列表
     */
    private List<Goods> goodsList;

    public OrdinaryShoppingCart() {
        goodsList = new ArrayList<>();
    }

    /**
     * 添加商品
     */
    public OrdinaryShoppingCart addGoods(Goods goods) {
        goodsList.add(goods);
        return this;
    }

    /**
     * 计算总价
     */
    public float totalCost() {
        return goodsList.stream().map(Goods::getPrice).reduce(Float::sum).orElse(0f);
    }

    /**
     * 通过支付宝支付
     */
    public void payWithAlipay() {
        log.info("通过支付宝支付了" + totalCost() + "元.");
    }

    /**
     * 通过微信支付
     */
    public void payWithWeChat() {
        log.info("通过微信支付了" + totalCost() + "元.");
    }
}
