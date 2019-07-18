package pers.hanchao.designpattern.rule.rule3;

import pers.hanchao.designpattern.rule.Goods;
import pers.hanchao.designpattern.rule.rule3.impl.ShoppingCart;
import pers.hanchao.designpattern.rule.rule3.impl.WeChatPayClient;

/**
 * <p>购物</P>
 *
 * @author hanchao
 */
public class ShoppingDemo {

    /**
     * 里式替换原则：
     * - 子类型必须能够替换它们的基类型。
     * - 一个软件实体如果使用的是一个基类，那么当把这个基类替换成继承该基类的子类，程序的行为不会发生任何变化。
     * 问题：违背里式替换原则：微信支付作为支付抽象类的子类，并不能实现父类规定的功能，即：保留2位小数
     * 解决：修改子类型的重载方法，完全实现父类型的功能
     */
    public static void main(String[] args) {
        IShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addGoods(new Goods("一双球鞋", 3500f, 1f))
                .addGoods(new Goods("一件外套", 2800.00f, 0.80f))
                .showGoods()
                //设置微信支付方式
                .setPayClient(new WeChatPayClient())
                .pay();
    }
}
