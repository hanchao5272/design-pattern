package pers.hanchao.designpattern.rule.rule2.impl;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.rule.Goods;
import pers.hanchao.designpattern.rule.rule2.IAliPayClient;
import pers.hanchao.designpattern.rule.rule2.IShoppingCart;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>普通购物车</P>
 *
 * @author hanchao
 */
@Slf4j
@NoArgsConstructor
public class ShoppingCart implements IShoppingCart {
    /**
     * 商品列表
     */
    private List<Goods> goodsList = new ArrayList<>();

    /**
     * 添加商品
     */
    @Override
    public IShoppingCart addGoods(Goods goods) {
        goodsList.add(goods);
        return this;
    }

    /**
     * 显示商品
     */
    @Override
    public IShoppingCart showGoods() {
        goodsList.forEach(goods -> log.info("购物车中有：{}，价格：{}.", goods.getName(), goods.getPrice() * goods.getDiscount()));
        log.info("-------------------------------------");
        log.info("购物车中获取总价格：{}元\n", this.totalCost());
        return this;
    }

    /**
     * 计算总价
     */
    @Override
    public Float totalCost() {
        return goodsList.stream().map(goods -> goods.getPrice() * goods.getDiscount()).reduce(Float::sum).orElse(0f);
    }

    /**
     * 通过支付宝支付
     */
    @Override
    public void pay() {
        IAliPayClient aliPayClient = new AliPayClient();
        aliPayClient.pay(totalCost());
    }
}
