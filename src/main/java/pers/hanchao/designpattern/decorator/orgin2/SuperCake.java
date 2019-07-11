package pers.hanchao.designpattern.decorator.orgin2;

import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.decorator.ICake;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>实现方式2：所有蛋糕共用一个大类</P>
 *
 * @author hanchao
 */
@Slf4j
public class SuperCake implements ICake {
    /**
     * 制作过程
     */
    private List<String> processList = new ArrayList<>();
    /**
     * 价格
     */
    private float cost;

    /**
     * 展示制作过程
     */
    @Override
    public void showMakingProcess() {
        processList.forEach(log::info);
    }

    /**
     * 显示总花费
     */
    @Override
    public float getCost() {
        return cost;
    }

    /**
     * 显示花费
     */
    @Override
    public void showCost() {
        log.info("总价：{}", cost);
    }

    /**
     * 选取蛋糕胚
     */
    public void selectCake() {
        processList.add("选取一个蛋糕胚...");
        cost += 30f;
    }

    /**
     * 添加奶油
     */
    public void addCream() {
        processList.add("包裹一层奶油...");
        cost += 10f;
    }

    /**
     * 添加水果
     */
    public void addFruit(String name, float price) {
        processList.add("摆放" + name + "...");
        cost += price;
    }
}
