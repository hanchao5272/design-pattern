# 状态模式
## 场景：射击游戏的武器状态
- 射击武器的状态有：有子弹、没子弹。
- 射击武器的操作有：射击、填充子弹。
- 有子弹时可以[射击]，射击会造成伤害(0~maxPower)。没子弹不能设计，需要[填充子弹]操作填充子弹。
- 需求变化-可能增加的状态：致死状态(有子弹 && 100伤害)、丢失状态(有子弹 && 50%不能击中目标)等。

## 实现方式1：if-else/switch

缺点：

- `耦合度高`：同一操作导致的所有状态变化都放在一起(同一个方法)处理。
- `实现复杂`：同一操作导致的所有状态变化都在一段代码中，需要一次性考虑全部状态的转换关系，逻辑复杂。
- `容错性低`：同一操作导致的所有状态变化都在一段代码中，当状态有增减时，修改代码出错概率较高。

## 实现方式2：状态模式

优点：

- `耦合度低`：同一操作导致的状态变化按照不同的状态分别(多个方法)处理。
- `实现复杂`：同一操作导致的所有状态变化分布处于不同的状态类，只需要考虑与本状态相关的转换关系，逻辑相对简单。
- `容错性低`：同一操作导致的所有状态变化分布处于不同的状态类，当状态有增减时，只需要修改与本状态相关的状态类，修改代码出错概率相对较低。
