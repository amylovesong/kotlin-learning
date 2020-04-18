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