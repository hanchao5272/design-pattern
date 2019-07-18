package pers.hanchao.designpattern.rule.rule6;

import pers.hanchao.designpattern.rule.rule6.impl.ShoppingCart;
import pers.hanchao.designpattern.rule.rule6.impl.WeChatPayClient;

/**
 * <p>购物</P>
 *
 * @author hanchao
 */
public class ShoppingDemo {

    public static void main(String[] args) {
        IShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addGoods(new Goods("一双球鞋", 3500f, 1f, 0.8f))
                .addGoods(new Goods("一件外套", 2800f, 0.8f, 0.5f))
                .showGoods()
                //设置微信支付方式
                .setPayClient(new WeChatPayClient())
                .pay();
    }
}
