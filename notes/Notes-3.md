# Kotlin 教程笔记（三）
> [Kotlin 协程](https://kaixue.io/tag/kotlin-coroutines/)

### Lesson 1
> [Kotlin 协程-1](https://kaixue.io/kotlin-coroutines-1/)

##### 协程（Coroutines）是什么
> 协程：协作式的例程，旨在让多线程之间进行协作，简化并发操作的处理。
> 
> 协程是一种编程思想，并不局限于特定的语言。
>
> 协程的设计初衷是为了解决并发问题，让 「协作式多任务」 实现起来更加方便。
>
> 协程在 Kotlin 中是一套线程封装的 API（**线程框架**，类似 Java 中的 `Executor`、Android 中的 `AsyncTask`），但并不是说协程就是为线程而生的。
> 只不过在 Kotlin 中，协程的一个典型的使用场景就是线程控制。

##### 闭包
> 在 Kotlin 中有这样一个语法糖：当函数的最后一个参数是 lambda 表达式时，可以将 lambda 写在括号外。
>
> 这就是它的闭包原则。

##### 使用
> Kotlin 协程是以官方扩展库的形式进行支持的。而且，我们所使用的「核心库」和 「平台库」的版本应该保持一致。

`build.gradle` 文件配置：
```groovy
// 协程核心库：包含的代码主要是协程的公共 API 部分。有了这一层公共代码，才使得协程在各个平台上的接口得到统一。
implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlin_coroutines"
// 当前平台所对应的平台库：平台库中包含的代码主要是协程框架在具体平台的具体实现方式。因为多线程在各个平台的实现方式是有所差异的。
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
```kotlin
CoroutineScope(Dispatchers.Main).launch {
    val image = withContext(Dispatchers.IO) { // 在 IO 线程执行获取图片的操作，结束后自动回到主线程
        getImage(imageId)
    }
    showImage(image) // 主线程处理 UI 操作
}
```

##### suspend 关键字
`suspend` 是 Kotlin 协程最核心的关键字。代码执行到 suspend 函数的时候会「挂起」，
并且这个「挂起」是非阻塞式的，它不会阻塞你当前的线程。

### Lesson 2
> [Kotlin 协程-2](https://kaixue.io/kotlin-coroutines-2/)

##### TODO


### Lesson 3
> [Kotlin 协程-3](https://kaixue.io/kotlin-coroutines-2/)

##### TODO


