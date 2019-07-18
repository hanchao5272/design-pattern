package pers.hanchao.designpattern.rule.rule6.impl;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.rule.rule6.Goods;
import pers.hanchao.designpattern.rule.rule6.IShoppingCart;
import pers.hanchao.designpattern.rule.rule6.PayClient;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>购物车</P>
 * <p>
 * 最后一个原则：开闭原则：对扩展开放，对修改关闭。前面做的事情。
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
     * 支付方式
     */
    private PayClient payClient = new AliPayClient();

    @Override
    public IShoppingCart setPayClient(PayClient payClient) {
        this.payClient = payClient;
        return this;
    }

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
        goodsList.forEach(goods -> log.info("购物车中有：{}，价格：{}.", goods.getName(), goods.getFinalPrice()));
        log.info("-------------------------------------");
        log.info("购物车中获取总价格：{}元\n", this.totalCost());
        return this;
    }

    /**
     * 计算总价
     */
    @Override
    public float totalCost() {
        return goodsList.stream().map(Goods::getFinalPrice).reduce(Float::sum).orElse(0f);
    }

    /**
     * 通过支付宝支付
     */
    @Override
    public void pay() {
        payClient.pay(totalCost());
    }
}
