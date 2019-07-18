package pers.hanchao.designpattern.rule.rule2;

import pers.hanchao.designpattern.rule.Goods;
import pers.hanchao.designpattern.rule.rule2.impl.ShoppingCart;

/**
 * <p>购物</P>
 *
 * @author hanchao
 */
public class ShoppingDemo {

    /**
     * 需求变化：新增了微信支付
     * 依赖倒置原则：
     * - 要依赖于抽象，不要依赖于具体。
     * - 要针对接口编程，不针对实现编程。
     * - 以抽象方式耦合是依赖倒转原则的关键。
     * 问题：违背依赖倒置原则：当新增微信支付时，因为写死了用支付宝支付，所以还是要修改支付逻辑。
     * 解决：将支付宝支付和微信支付抽象成更高层次的支付接口；将购物车类对支付类的依赖设置为可替换的
     */
    public static void main(String[] args) {
        IShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addGoods(new Goods("一双球鞋", 3500f, 1f))
                .addGoods(new Goods("一件外套", 2800.00f, 0.80f))
                .showGoods()
                //设置微信支付方式
                .pay();
    }
}
