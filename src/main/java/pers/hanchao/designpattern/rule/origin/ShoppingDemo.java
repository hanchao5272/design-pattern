package pers.hanchao.designpattern.rule.origin;

import pers.hanchao.designpattern.rule.Goods;

/**
 * <p>购物</P>
 *
 * @author hanchao
 */
public class ShoppingDemo {

    /**
     * 单一职责原则：
     * - 就一个类而言，应该仅有一个引起它变化的原因.
     * - 简而言之：一个类应该是一组相关性很高的函数、数据的封装。
     * 问题：违背单一职责原则：支付宝的连接和支付逻辑不应该放在购物车类中
     * 解决：将支付宝相关逻辑抽离出来，放到单独的类中处理o
     */
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addGoods(new Goods("一双球鞋", 3500f, 1f))
                .addGoods(new Goods("一件外套", 2800.00f, 0.80f))
                .showGoods()
                .pay();
    }
}
