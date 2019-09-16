# Kotlin 教程笔记

[Kotlin 基础](https://kaixue.io/tag/kotlin-ji-chu/)

##### 类型推断
Kotlin 的类型推断不同于 Groovy 或 JavaScript 的动态类型。类型推断是在代码里不用写变量类型，编译器在编译的时候会自动补上。所以 Kotlin 是一门静态语言。

##### 变量声明
var 和 val 是声明变量的两种方式：
> var 是 variable 的缩写，val 是 value 的缩写。

##### 可见性
Kotlin 中变量的默认可见性是 **public** 的。

函数的默认可见性也是 **public** 的（遇到 `override` 关键字的情况除外）。

> 对任何编程语言来讲，变量 -> 存储数据，函数 -> 处理数据。

##### getter/setter
使用 get/set 关键字来实现 getter/setter「钩子」方法。

* 这里涉及一个 field 的概念，它在 Kotlin 中相当于每一个 var 内部的一个变量，用来自动应用于 getter 和 setter。

val 声明的变量只读，因此不能重写 setter 函数，但可以重写 getter 函数。
* 与 Java 中的 final 不同的是，val 声明的只读变量在 getter 中可以修改其返回值。因此从某种程度上来说，val 修饰的变量取值是可变的。

##### 类型
基本类型包括：数字、字符、布尔值、数组和字符串。

* 基本类型的装箱注意点：
    > Kotlin 在语言层面简化了 Java 中的 int 和 Integer，但是我们对是否装箱的场景还是要有一个概念，因为这个牵涉到程序运行时的性能开销。
    > 因此在日常的使用中，**对于 Int 这样的基本类型，尽量用不可空变量**。
    >
    > 简单来说，原先在 Java 里的基本类型，类比到 Kotlin 里面，条件满足如下之一就不装箱：
    > * 不可空类型。
    > * 使用 IntArray、FloatArray 等。
    > 
    > 即像 Int? 和 List<Int> 这种是装箱的。
    
##### 类和对象
* Java 中的 extends 和 implements 都使用 `:` 代替。 
    ```
    class A : ClassB(), ImplC {}
    ```
* 构造函数使用 `constructor` 关键字与普通函数区分：
    ```
    class MainActivity : AppCompatActivity {
        constructor() {
        }
    }
    ```
* Kotlin 里的 `override` 函数的可见性是继承自父类的。
* Kotlin 里的类默认是 final 的，如果要解除 final 限制，需要使用 `open` 关键字来完成：
    ```
    open class A : ClassB() {}
    
    class C : A() {}
    ```
    这里的 C 也是 final 的，即 `open` 没有父类到子类的遗传性。
* Kotlin 中实例化一个对象不需要 `new` 关键字：
    ```
    var cInstance: C = C()
    ```
##### 类型判断
Java 中 `instanceof` -> Kotlin 中的 `is`，同时强转也可以省略（编译器能够进行类型推断）：
```
if (a is C) {
    a.action()
}
```
另外，还可以使用 `as` 关键字来省略类型判断，直接强转调用：
```
(a as C).action()
```
如果这里的强转失败，则会抛出异常。

更好地处理强转可能出错的情况是使用 `as?` 来解决：
```
(a as? C)?.action()
```
`(a as? C)` 得到的是一个可空类型的对象，因此需要使用 `?.` 来调用。

即如果强转成功则执行之后的调用，如果失败就不执行。

