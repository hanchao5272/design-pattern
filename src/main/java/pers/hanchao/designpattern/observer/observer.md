# 观察者模式
## 场景：报纸订阅
- 用户可以订阅报纸，也可以取消订阅报纸。
- 可以将报纸发布给所有订阅它的用户。

## 原始形式
- 因为`可以将报纸[Newspaper]发布给所有订阅它的用户[User]`，所以它需要知道有哪些用户订阅了它，所以：
    - `报纸[Newspaper]`需要存储已经订阅它的`用户集合[Set<User>]`。
    - `报纸[Newspaper]`需要提供方法`给所有订阅者邮寄报纸[mailNewspaperToSubscribers()]`。
    - `用户[User]`需要提供方法用于`接受报纸[receiveNewspaper()]`。
- 因为`用户可以订阅报纸，也可以取消订阅报纸`，所以可以理解为:`报纸可以记录谁订阅了它，也可以知道谁取消了订阅`
    - `报纸[Newspaper]`需要提供方法用于`记录谁订阅了它[subscribe()]`。
    - `报纸[Newspaper]`需要提供方法用于`记录谁取消了订阅[cancel()]`。

缺点:

- 未遵从`面向接口的编程`。

## 观察者模式

- 从`用户[User]`抽象出接口`观察者[Observer]`。
- 从`报纸[Newspaper]`抽象出接口`主题[Subject]`。

## Java观察者模式

- `用户[User]`实现父接口`观察者[Observer]`。
- `报纸[Newspaper]`继承父类`被观察者[Observable]`。