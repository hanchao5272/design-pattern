# design-pattern
Java设计模式系统性学习记录。

博客链接： https://blog.csdn.net/hanchao5272/article/details/95980982

-----

## 前言
虽然拜读了《HeadFirst设计模式》一书，对设计模式进行了学习，但是一直没有真正的进行编码。
近期打算抽空对常用的设计模式进行实例编码，并形成博文，以备日后参考。
## 关于设计模式

- 设计模式（Design Pattern）是一套被反复使用、多数人知晓的、经过分类的、代码设计经验的总结。
- 用设计模式的目的：为了代码可重用性、让代码更容易被他人理解、保证代码可靠性。 

## 辅助工具
- [UML类图的依赖、关联、聚合、组合、泛化、继承](https://hanchao.blog.csdn.net/article/details/96477526)
## 设计原则(待更新...)

- [面向对象的六个设计原则-以购物车支付为例](https://blog.csdn.net/hanchao5272/article/details/96438727)

## 设计模式分类

设计模式分为三种类型，共计23种：

- 创建型模式：**`单例模式`**、**`抽象工厂模式`**、**`工厂模式`**、建造者模式、原型模式。
- 结构型模式：**`适配器模式`**、**`装饰模式`**、**`外观模式`**、**`代理模式`**、桥接模式、组合模式、享元模式。
- 行为型模式：**`策略模式`**、**`观察者模式`**、**`责任链模式`**、**`状态模式`**、**`命令模式`**、**`模版方法模式`**、迭代器模式、中介者模式、备忘录模式、解释器模式、访问者模式。

## 设计模式实例学习列表

创建型模式：对象实例化的模式，创建型模式用于解耦对象的实例化过程。

- [单例模式(singleton)-8种-以打印机为例](https://blog.csdn.net/hanchao5272/article/details/95981494): 保证一个类仅有一个实例，并提供一个访问它的全局访问点。
- [工厂模式(factory)-3种-以手机制造工厂为例](https://blog.csdn.net/hanchao5272/article/details/96482859): 提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。

结构型模式：把类或对象结合在一起形成一个更大的结构。

- [适配器模式(adapter)-以电压适配器为例](https://hanchao.blog.csdn.net/article/details/96484044): 将一个类的接口转换成另外一个客户希望的接口，使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
- [装饰者模式(decorator)-以生日蛋糕装饰为例](https://hanchao.blog.csdn.net/article/details/97142746): 动态地给一个对象添加一些额外的职责。就扩展功能而言， 它比生成子类方式更为灵活。
- [外观模式(facade)-以瀑布模型软件开发为例](https://hanchao.blog.csdn.net/article/details/97616272): 为子系统中的一组接口提供一个一致的界面，Facade模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。
- [代理模式(proxy)-以购房中介为例](https://hanchao.blog.csdn.net/article/details/97641940): 为其他对象提供一个代理以控制对这个对象的访问。

行为型模式：类和对象如何交互，及划分责任和算法。

- [策略模式(strategy)-以购物车的支付策略为例](https://blog.csdn.net/hanchao5272/article/details/96480255): 定义一系列的算法,把它们一个个封装起来, 并且使它们可相互替换。本模式使得算法可独立于使用它的客户而变化。
- [观察者模式(observer)-以报纸订阅为例](https://hanchao.blog.csdn.net/article/details/97149607): 定义对象间的一种一对多的依赖关系，以便当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并自动刷新。
- [设计模式(chain of responsibility)-责任链模式-以多轮面试为例](https://hanchao.blog.csdn.net/article/details/97285508): 使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。将这些对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理它为止。
- [状态模式(state)-以射击游戏的武器状态为例](https://hanchao.blog.csdn.net/article/details/97391011): 允许一个对象在其内部状态改变时改变它的行为，对象看起来似乎修改了它的类。
- [命令模式(command)-以游戏快捷键为例](https://hanchao.blog.csdn.net/article/details/97613225): 将一个请求封装为一个对象，从而使你可用不同的请求对客户进行参数化；对请求排队或记录请求日志，以及支持可取消的操作。
- [模板方法模式-以简历模板为例](https://hanchao.blog.csdn.net/article/details/97614786): 定义一个操作中的算法的骨架，而将一些步骤延迟到子类中。模板方法模式使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
