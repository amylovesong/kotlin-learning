# Kotlin 教程笔记（三）
> [Kotlin 协程](https://kaixue.io/tag/kotlin-coroutines/)

### Lesson 1
> [Kotlin 协程-1](https://kaixue.io/kotlin-coroutines-1/)

##### 协程是什么
> 协程（Coroutines）设计的初衷是为了解决并发问题，让 「协作式多任务」 实现起来更加方便。
>
> 协程就是 Kotlin 提供的一套线程封装的 API（线程框架），但并不是说协程就是为线程而生的。
> 只不过在 Kotlin 中，协程的一个典型的使用场景就是线程控制。

##### 闭包
> 在 Kotlin 中有这样一个语法糖：当函数的最后一个参数是 lambda 表达式时，可以将 lambda 写在括号外。
>
> 这就是它的闭包原则。

##### 使用
> Kotlin 协程是以官方扩展库的形式进行支持的。而且，我们所使用的「核心库」和 「平台库」的版本应该保持一致。

`build.gradle` 文件配置：
```groovy
implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlin_coroutines"
implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlin_coroutines"
```

`launch()` 函数：
```kotlin
fun methodBasic(context: CoroutineContext) {
    val coroutineScope = CoroutineScope(context)
    coroutineScope.launch {
        // ...
    }

    coroutineScope.launch(Dispatchers.IO) {

    }

    coroutineScope.launch(Dispatchers.Main) {

    }
}
```
`withContext()` 函数：
> 这个函数可以切换到指定的线程，并在闭包内的逻辑执行结束之后，自动把线程切回去继续执行。

##### suspend 关键字
`suspend` 是 Kotlin 协程最核心的关键字。代码执行到 suspend 函数的时候会「挂起」，
并且这个「挂起」是非阻塞式的，它不会阻塞你当前的线程。

### Lesson 2
> [Kotlin 协程-2](https://kaixue.io/kotlin-coroutines-2/)

##### TODO


### Lesson 3
> [Kotlin 协程-3](https://kaixue.io/kotlin-coroutines-2/)

##### TODO


