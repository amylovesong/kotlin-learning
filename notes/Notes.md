# Kotlin 教程笔记
> [Kotlin 基础](https://kaixue.io/tag/kotlin-ji-chu/)

### Lesson 1
> [Kotlin 的变量、函数和类型](https://kaixue.io/kotlin-basic-1/)

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

### Lesson 2
> [Kotlin 里那些「不是那么写的」](https://kaixue.io/kotlin-basic-2/)

##### Constructor
Kotlin 构造器直接使用 `constructor` 关键字表示，且没有 `public` 修饰，默认可见性就是公开的。
```
Class C {
    constructor() {}
}
```

##### init 代码块
Kotlin 的 init 代码块需要加一个 `init` 前缀，执行顺序跟 Java 一样也是在构造器之前。

##### final
在 Kotlin 中 `final` -> `val`，可以用来修饰成员变量和局部变量。特别地，Kotlin 中的函数参数默认是 `val` 类型，所以参数前不需要写 `val` 关键字，  
因此可以保证参数在方法体中不会被修改。

> var = variable
>
> val = value

##### val 自定义 getter
虽然被 val 修饰的变量不能被重新赋值，但是可以通过自定义 getter 来使变量被访问时返回动态获取的值：
```
val size: Int
    get() {
        return items.size
    }
```

##### 静态属性和方法
在 Kotlin 中其实没有了静态属性和方法的概念，但如果想要像 Java 里通过类直接引用的话，可以使用 `companion object`：
```
class CompanionObjectSample {
    companion object {
        val anotherStr = "bbb"
    }
}
```
请注意这里的 `object` 关键字是**小写**！
> Java 中的 `Object` 在 Kotlin 中变成了 `Any`。

###### object
在 Kotlin 中 `object` 关键字的含义是：创建一个类，并创建一个这个类的对象。

之后就可以通过这个类的类名来直接访问它的成员变量和方法：
```
    object S {
        val name = "A"
    }
    
    fun methodObject() {
        S.name
    }
```
这里用 object 修饰的 S 类其实就变成了一个单例！
> 这种通过 `object` 实现的单例是一个饿汉式的单例，同时保证了线程安全。

这里其实可以理解为 `object` 是把单例的两步和合并成了一步：定义类、单例化

使用 `object:` 可以创建匿名类：

##### companion object
在一个类中可以有多个 `object` 修饰的嵌套对象，但**只能有一个** `companion` 修饰的伴生对象：`companion object`。
类的嵌套对象在使用上如下：
```
class C {
    object O {
        var v: Int = 0
    }
}

C.O.v
```
而当有 `companion` 修饰时则更加方便：
```
class C {
    companion object {
        var v: Int = 0
    }
}

C.v
```
##### 静态代码块
```
class C {
    companion object {
        init { }
    }
}
```

##### top-level 属性、方法声明
全局变量、方法，属于 package，不属于 class/object。

如果多个包下出现同名的方法、属性，在使用时需要通过包前缀来加以区分。

##### object、companion object、top-level 最佳实践
- 工具类：top-level
- 需要继承别的类或实现接口：object、companion object

##### 常量
- 静态：`object`(companion object) 或 `top-level`
- 新增关键字：`const`
- 不可变：只有基本类型和 String 可以声明为常量
> Kotlin 中的常量指的是 compile-time constant：编译时常量。
>
> 而 Java 中的 Object 常量可以认为是「伪常量」，因为其内部的属性是可变的。

##### 数组&集合
Kotlin 的数组在语言层面支持泛型（编译成字节码时使用的仍然是 Java 的数组），因此失去了 Java 数组的协变（covariance）特性：

子类数组对象不能赋值给父类数组变量。

不过数组泛型化使得操作数组更加方便，因为可以增加很多工具函数：
- `get()/set()`
- `contains()`
- `first()`
- `find()`

Kotlin 的集合：`List`、`Set`、`Map`。

Kotlin 的 List 支持协变（Java 不支持……）。

对于基本类型的操作，Kotlin 中要用专门的基本类型数组类 (`IntArray`、`FloatArray`、`LongArray`) 才可以免于装箱。

`mapOf` 的每个参数是一个键值对，`to`表示将「键」和「值」关联，叫做「中缀表达式」：
```
val map = mapOf("k1" to 1, "k2" to 2, "k3" to 3, "k4" to 4)
```
Map 可以通过 `get()/put()` 和 `[key]` 两种方式来操作元素：
```
val map = mapOf("k1" to 1, "k2" to 2, "k3" to 3, "k4" to 4) // 不可变集合
val v1 = map.get("k1")
val v2 = map["k2"]

val mapMutable = mutableMapOf("k1" to 1, "k2" to 2) // 可变集合
mapMutable.put("k1", 11)
mapMutable["k1"] = 111

map.toMutableMap() // 不可变 -> 可变
```

`toMutable*()` 返回的是一个新建的集合，原有集合还是不可变的。

##### Sequence
```
// ① sequenceOf()
val sequence = sequenceOf("a", "b", "c")

// ② Iterable 接口
val list = listOf("a", "b", "c")
val sequence2 = list.asSequence() // List 实现了 Iterable 接口

// ③ lambda 表达式
val sequence3 = generateSequence(0) { it + 1}
```

##### 可见性修饰符
- `public`
- `private`：类中或文件中可见，内部类对外部类不可见
- `protected`：private + 子类可见
- `internal`：仅 module 内可见

> 这里的 module 指的是一组共同编译的 Kotlin 文件，如：
> - Android Studio 里的 module
> - Maven project

Kotlin 默认的可见性是 `public`，同时去掉了「包内可见」的概念。

`internal` 在开发 library module 时非常有用，例如用于修饰仅对 module 内部使用的函数。
（个人认为，对于同一个 module 内的不同包来说 ，`internal` 修饰符解除了 Java 中包级可见性（default）的过强约束，这一点会更加方便 module 内的跨包访问。）

Kotlin 的一个文件中可以声明多个 `class` 和 top-level 的函数和属性，因此类和接口可以声明为 `private`。




