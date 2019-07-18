package pers.hanchao.designpattern.rule.origin;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.rule.FormatUtil;
import pers.hanchao.designpattern.rule.Goods;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>购物车</P>
 *
 * @author hanchao
 */
@Slf4j
@NoArgsConstructor
public class ShoppingCart {
    /**
     * 商品列表
     */
    private List<Goods> goodsList = new ArrayList<>();

    /**
     * 添加商品
     */
    public ShoppingCart addGoods(Goods goods) {
        goodsList.add(goods);
        return this;
    }

    /**
     * 显示商品
     */
    public ShoppingCart showGoods() {
        goodsList.forEach(goods -> log.info("购物车中有：{}，价格：{}.", goods.getName(), goods.getPrice() * goods.getDiscount()));
        log.info("-------------------------------------");
        log.info("购物车中获取总价格：{}元\n", this.totalCost());
        return this;
    }

    /**
     * 计算总价
     */
    public float totalCost() {
        return goodsList.stream().map(goods -> goods.getPrice() * goods.getDiscount()).reduce(Float::sum).orElse(0f);
    }

    /**
     * 连接支付宝
     */
    public void connect() {
        log.info("开始进行支付宝支付：");
        log.info("1.初始化支付宝客户端...");
        log.info("2.设置请求参数...");
        log.info("3.请求支付宝进行付款，并获取支付结果...");
        log.info("-------------------------------------");
    }

    /**
     * 支付(日志显示2位小数)
     */
    public void pay() {
        float money = this.totalCost();
        connect();
        log.info("4.通过支付宝支付了" + FormatUtil.format(money) + "元.");
    }
}
