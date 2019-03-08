# noob-games（早期的可执行文件位于根目录下的game.rar）
## 一、	开发过程

## 2.	实现方式

### 2.1	    绘制游戏窗口

（1）	使用javax.swing.JPanel类绘制窗口

（2）	使用java.awt类获取资源组件并加入窗口来绘制游戏背景图片

（3）	使用线程和repaint方法绘制动态画面

### 2.2	    绘制角色

（1）	创建Player类，定义角色基本属性（width、height、x、y、hp等）

（2）	使用java.awt类获取角色图片

（3）	设置drawself方法来绘制子弹

### 2.3	    设置监听器

（1）	使用java.awt.event.KeyEvent类和java.awt.event.KeyListener类设置键盘监听器实现角色移动等功能

### 2.4	    添加角色子弹

（1）	创建Bullet类，定义子弹基本属性(width、height、x、y等)

（2）	使用java.awt类获取子弹图片

（3）	设置drawself方法来绘制子弹

### 2.5	    添加敌机

（1）	创建Enemy父类，定义敌机基本属性

（2）	使用java.awt类获取敌机图片

（3）	设置drawself方法来绘制敌机

### 2.6	    添加道具

（1）	创建Item父类，定义道具基本属性

（2）	使用java.awt类获取道具图片

（3）	设置drawself方法来绘制道具

### 2.7	    添加游戏分数

（1）	在MyPanel中使用java.awt类绘制游戏分数

### 2.8	    添加游戏音乐、音效

（1）	导入JLayer包

（2）	使用JLayer类中的方法实现游戏背景音乐和游戏音效的添加


## 3.	如何检查系统功能

运行游戏，检查各项功能是否正常


## 二、	设计方案

### 1.	功能组成

大体将程序分为四个模块：
 
从上至下依次是：监听器模块、模型模块、线程模块、视窗模块

（1）	监听器模块：实现角色移动功能及主菜单开始按钮和游戏结束界面重来按钮功能

（2）	模型模块：玩家角色、敌机、子弹、敌机子弹、玩家炸弹、物品属性等定义，可通过更改其中对应参数，实现不同功能，如：一次发出子弹数量，子弹飞行轨迹、物品效果、玩家血量、玩家移动速度等

（3）	线程模块：分为绘制画面线程和游戏音乐音效线程两大类，绘制画面线程主要是控制对游戏背景、游戏角色、敌机、物品、子弹等图片的绘制，游戏音乐音效线程则是控制游戏背景音乐与游戏音效的播放等

（4）	视窗模块：绘制游戏角色、敌机、子弹、等模型模块中的模型，搭配线程模块中的绘制画面线程可实现动态画面，即游戏化

## 三、	技术讨论

### 1.	存在问题

（1）	玩家角色、敌机、子弹之间的碰撞问题。由于三者碰撞体积都为一个矩形，但由于三者又不一定都是矩形，故存在明明玩家角色与其余两者未接触但造成角色血量减少的较差的游戏体验。

（2）	因为存在碰撞问题，故调整了碰撞函数，但又出现新的BUG：角色存在多段扣血的情况，因此将子弹伤害降低为1，减少角色被秒杀的情况。

（3）	游戏性不高

### 2.	解决方法

（1）	问题1、2可设置角色无敌时间，即子弹命中角色后角色可无敌一段时间，无敌时间需大于碰撞函数检测时间，即在子弹移除之前角色应是无敌状态

（2）	游戏性问题可增加游戏关卡，游戏敌人种类，游戏道具种类，玩家角色攻击方式等，但实际情况是游戏素材不足，有心而无力。另外可增加新系统增加游戏性，如增加rougelike模式，即遗物系统，角色吃下后可有特殊的攻击方式或有趣的被动属性（如增加攻速或僚机攻击等）

