### JSP
### 单一原则
### 门面模式 Facade Pattern
### 泛型 Generics
- 1、让数据类型变得参数化
```
1) 定义泛型的时候，对应的数据类型是不确定的
2) 泛型方法被调用的时候，会指定具体的类型
3) 核心目标: 解决容器类型在编译时候的安全检查问题
```

- 2、泛型通配符 ?
```
Number 为上边界
<? extends Number>
```

```
下边界
<? super Integer>
```

### 拦截所有请求
```
/ => 拦截所有请求，不包含jsp
/* => 拦截所有请求，包含jsp
```

- 3、工厂模式
```
1) 定义一个工厂类，根据传入的参数的值不同返回不同的实例。
2) 延迟工厂模式
3) 抽象工厂模式
```

- 4、反射
```
IOC 是工厂模式与反射的集合
反射类 依赖Class，只有JVM能够创建Class类的实例
JVM中只有一个和类相对应的Class对象来描述其类型信息
1) 获取Class对象的三种方式
object -> getClass()
任何数据类型（包括基本数据类型）都有一个"静态"的class属性
通过Class类的静态方法：forName(String className) (常用)
2) 反射的获取源
用注解来保存类相关的信息以供反射调用
```

- 5、注解
```
提供一种为程序元素设置元数据的方法
    元数据是添加到程序元素如方法、字段、类和包上的额外信息
```

```
JDK启动的时候添加VM options参数
-Djdk.proxy.ProxyGenerator.saveGeneratedFiles=true

根据生成的类可以查看到invocation

```


