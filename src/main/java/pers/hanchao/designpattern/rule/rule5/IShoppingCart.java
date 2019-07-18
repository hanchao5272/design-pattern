package pers.hanchao.designpattern.rule.rule5;


import pers.hanchao.designpattern.rule.Goods;

/**
 * <p>购物车的抽象类</P>
 *
 * @author hanchao
 */
public interface IShoppingCart {

    IShoppingCart setPayClient(PayClient payClient);

    /**
     * 添加商品
     */
    IShoppingCart addGoods(Goods goods);

    /**
     * 显示商品
     */
    IShoppingCart showGoods();

    /**
     * 计算总价
     */
    float totalCost();

    /**
     * 通过支付宝支付
     */
    void pay();
}
