# Kotlin 教程笔记（二）
> [Kotlin 进阶](https://kaixue.io/tag/kotlin-advanced/)

### Lesson 1
> [Kotlin 泛型](https://kaixue.io/kotlin-generics/)

##### kotlin 的 out 和 in

`out` 等价于 Java 的 `? extends`：上界通配符（限制泛型的上界）

`in` 等价于 Java 的 `? super`：下届通配符（限制泛型的下界）

`*` 等价于 Java 的 `?`：相当于 `out Any`

※※ 与 Java 不同的是：如果类型定义里已经有 `out` 或 `in` 时，在变量声明处使用 `*` 无法解除类型定义处的限制：

> 类型定义里是 `out T: Number`，那么声明变量是使用 `<*>` 依然是 `out Number`，而不是 `out Any`！

即`类型定义的泛型声明优先级高于变量声明`。

##### kotlin 的 where 关键字
泛型类型参数限制为多个边界时，使用 `where` 关键字：
```
interface Animal {}

interface Food {}

class Monster<T> where T: Animal, T: Food {

}
```
`where` 带来更好的可读性：
```
interface MonsterParent<T> {}

// MonsterNew 本身继承自 MonsterParent，泛型 T 也有约束边界
class MonsterNew<T> : MonsterParent<T> where T : Animal {
    
}
```

##### Kotlin 的 reified 关键字
`inline` + `reified` 解决泛型类型判断：
```
inline fun <reified T> printIfTypeMatch(item: Any) {
    if (item is T) {
        println(item)
    }
}
```

### Lesson 2
> [Kotlin 的 Lambda 表达式](https://kaixue.io/kotlin-lambda/)

##### 高阶函数
函数类型：由「参数类型 + 返回值类型」来确定。  
在 Java 中不存在，是 Kotlin 中新加入的一种类型。

参数/返回值是「函数类型」的函数：高阶函数（Higher-Order Functions）。

只是一类函数的称呼，没有特别的功能。

##### 函数类型的使用
`::method`

函数名前的双冒号，`使函数变成了对象`。

> 在 Kotlin 里，一个函数名的左边加上双冒号，它就不表示这个函数本身了，而表示一个对象，或者说一个指向对象的引用，但，这个对象可不是函数本身，而是一个和这个函数具有相同功能的对象。

注意「函数」和「函数类型的对象」的区分。

`::method` 的写法是指向一个对象的引用，而不是指向函数本身。这个对象是 Kotlin 自动创建的。

##### 匿名函数
```
a(fun(param: Int): String {
    return param.toString()
})

val f =  fun(param: Int): String {
    val result = param * 10
    return "$result"
}
```
##### Lambda
```
setOnClickListener{ v: View ->
    println(v)
}
```

注意 Lambda 作为函数参数时的变形：简化写法。具体参见示例代码。

Lambda 的最后一行代码就是它的返回值，而 return 会直接结束外层函数。

###### 匿名函数和 Lambda 的本质

在 Kotlin 里，匿名函数和 Lambda 的本质都是「函数类型的对象」。
