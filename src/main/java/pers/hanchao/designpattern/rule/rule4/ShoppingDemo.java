package pers.hanchao.designpattern.rule.rule4;

import pers.hanchao.designpattern.rule.Goods;
import pers.hanchao.designpattern.rule.rule4.impl.ShoppingCart;
import pers.hanchao.designpattern.rule.rule4.impl.WeChatPayClient;

/**
 * <p>购物</P>
 *
 * @author hanchao
 */
public class ShoppingDemo {

    /**
     * 接口隔离原则：
     * - 使用多个专一功能的接口比使用一个的总接口总要好。
     * - 一个类对另外一个类的依赖性应当是建立在最小接口上的。
     * 问题：违背接口隔离原则：PayClient的接口有两个方法，但是connect()对于微信支付是无用的。
     * 解决：拆解大接口，形成小接口。
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
