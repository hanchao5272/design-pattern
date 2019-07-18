package pers.hanchao.designpattern.rule.rule5;

import pers.hanchao.designpattern.rule.Goods;
import pers.hanchao.designpattern.rule.rule5.impl.ShoppingCart;
import pers.hanchao.designpattern.rule.rule5.impl.WeChatPayClient;

/**
 * <p>购物</P>
 *
 * @author hanchao
 */
public class ShoppingDemo {

    /**
     * 需求变化：商品的价格计算不仅仅有普通折扣，还有会员折上折
     * 迪米特原则：
     * - 对象与对象之间应该使用尽可能少的方法来关联，避免千丝万缕的关系。
     * 问题：违背迪米特原则(最少知识原则)：购物车不应该关系商品的计算逻辑。
     * 解决：购物车不应该知道商品价格的计算规则，他只要能够通过某个方法直接获取商品的最终价格接口。
     */
    public static void main(String[] args) {
        IShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addGoods(new Goods("一双球鞋", 3500f, 1f))
                .addGoods(new Goods("一件外套", 2800f, 0.8f))
                .showGoods()
                //设置微信支付方式
                .setPayClient(new WeChatPayClient())
                .pay();
    }
}
