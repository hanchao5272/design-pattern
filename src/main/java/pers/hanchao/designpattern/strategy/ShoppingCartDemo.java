package pers.hanchao.designpattern.strategy;

import pers.hanchao.designpattern.strategy.ordinary.OrdinaryShoppingCart;
import pers.hanchao.designpattern.strategy.strategy.StrategyShoppingCart;
import pers.hanchao.designpattern.strategy.strategy.strategy.impl.AliPayStrategy;
import pers.hanchao.designpattern.strategy.strategy.strategy.impl.UnionPayStrategy;
import pers.hanchao.designpattern.strategy.strategy.strategy.impl.WeChatPayStrategy;

/**
 * <p>购物车场景测试</P>
 *
 * @author hanchao
 */
public class ShoppingCartDemo {
    public static void main(String[] args) {
        //购物车(普通版本)
        //张三的购物行为
        new OrdinaryShoppingCart()
                .addGoods(new Goods("一箱牛奶", 34.55f))
                .addGoods(new Goods("一瓶白酒", 250.50f))
                .payWithAlipay();

        //李四的购物行为
        new OrdinaryShoppingCart()
                .addGoods(new Goods("一箱牛奶", 34.55f))
                .addGoods(new Goods("一瓶啤酒", 3.50f))
                .payWithWeChat();

        //购物车(策略模式版本)
        //王五的购物行为
        new StrategyShoppingCart()
                .addGoods(new Goods("一箱牛奶", 34.55f))
                .addGoods(new Goods("一瓶白酒", 250.50f))
                .setPayStrategy(new AliPayStrategy()).pay();

        //赵六的购物行为
        new StrategyShoppingCart()
                .addGoods(new Goods("一箱牛奶", 34.55f))
                .addGoods(new Goods("一瓶啤酒", 3.50f))
                .setPayStrategy(new WeChatPayStrategy()).pay();

        //孙七的购物行为
        new StrategyShoppingCart()
                .addGoods(new Goods("一箱牛奶", 34.55f))
                .addGoods(new Goods("一双袜子", 23.50f))
                .setPayStrategy(new UnionPayStrategy()).pay();

    }
}
