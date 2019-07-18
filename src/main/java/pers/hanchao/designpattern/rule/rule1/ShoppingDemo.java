package pers.hanchao.designpattern.rule.rule1;

import pers.hanchao.designpattern.rule.Goods;

/**
 * <p>购物</P>
 *
 * @author hanchao
 */
public class ShoppingDemo {

    /**
     * 开闭原则：
     * - 对扩展开发,对修复关闭。
     * - 在面向对象设计中，不允许更改的是系统的抽象层，而允许扩展的是系统的实现层。
     * - 换言之，定义一个一劳永逸的抽象设计层，允许尽可能多的行为在实现层被实现。
     * - 解决问题关键在于抽象化，抽象化是面向对象设计的第一个核心本质。
     * 问题：违背开闭原则：支付客户端和购物车都是具体实现类
     * 解决：将支付客户端和购物车抽象化
     */
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addGoods(new Goods("一双球鞋", 3500f, 1f))
                .addGoods(new Goods("一件外套", 2800f, 0.8f))
                .showGoods()
                .pay();
    }
}
