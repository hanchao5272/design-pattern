package pers.hanchao.designpattern.decorator;

import lombok.extern.slf4j.Slf4j;
import pers.hanchao.designpattern.decorator.decorator.CakeEmbryo;
import pers.hanchao.designpattern.decorator.decorator.decorator.CreamDecorator;
import pers.hanchao.designpattern.decorator.decorator.decorator.FruitDecorator;
import pers.hanchao.designpattern.decorator.orgin2.SuperCake;
import pers.hanchao.designpattern.decorator.origin1.CreamCake;
import pers.hanchao.designpattern.decorator.origin1.FruitCake;

/**
 * <p>装饰者模式示例</P>
 *
 * @author hanchao
 */
@Slf4j
public class DecoratorDemo {

    public static void main(String[] args) {
        //实现方式1：每种蛋糕一个子类
        log.info("实现方式1：每种蛋糕一个子类：制作一个水果蛋糕：");
        ICake cake = new FruitCake();
        cake.showMakingProcess();
        cake.showCost();

        System.out.println();

        log.info("实现方式1：每种蛋糕一个子类：制作一个奶油蛋糕：");
        cake = new CreamCake();
        cake.showMakingProcess();
        cake.showCost();

        System.out.println();

        //实现方式2：所有蛋糕共用一个大类
        log.info("实现方式2：所有蛋糕共用一个大类：制作一个水果蛋糕：");
        SuperCake superCake = new SuperCake();
        superCake.selectCake();
        superCake.addCream();
        superCake.addFruit("6片菠萝", 20f);
        superCake.addFruit("6颗草莓", 30f);
        superCake.showMakingProcess();
        superCake.showCost();

        System.out.println();

        log.info("实现方式2：所有蛋糕共用一个大类：制作一个奶油蛋糕：");
        superCake = new SuperCake();
        superCake.selectCake();
        superCake.addCream();
        superCake.showMakingProcess();
        superCake.showCost();

        System.out.println();

        //实现方式3：装饰者模式
        log.info("实现方式3：装饰者模式：制作一个水果蛋糕");
        cake = new FruitDecorator(new FruitDecorator(new CreamDecorator(new CakeEmbryo()), "6片菠萝", 20f), "6颗草莓", 30f);
        cake.showMakingProcess();
        cake.showCost();

        System.out.println();

        log.info("实现方式3：装饰者模式：制作一个奶油蛋糕：");
        cake = new CreamDecorator(new CakeEmbryo());
        cake.showMakingProcess();
        cake.showCost();
    }
}
