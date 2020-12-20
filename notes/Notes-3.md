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
> `suspend` 是 Kotlin 协程最核心的关键字。代码执行到 suspend 函数的时候会「挂起」，
并且这个「挂起」是非阻塞式的，它不会阻塞你当前的线程。

### Lesson 2
> [Kotlin 协程-2](https://kaixue.io/kotlin-coroutines-2/)

##### 创建协程的 3 种方式：
1. `launch`：最常用且推荐使用。
2. `runBlocking`：适用于单测的场景，因为它是线程阻塞的。
3. `async`：与 `launch` 类似，但返回的 `Coroutine` 多实现了 `Deferred` 接口。

##### "挂起"的本质
> "挂起"的对象是协程。
> 挂起时协程从启动它的线程脱离，之后线程和协程分别执行各自的代码。

##### Dispatchers（调度器）
> 将协程限制在一个特定的线程执行，或者将它分派到一个线程池，或者让它不受限制地运行。

常用的三种 `Dispatcher`：
1. Dispatchers.Main：Android 中的主线程
2. Dispatchers.IO：IO 线程，适用于 IO 密集型任务。
3. Dispatchers.Default：计算线程，适用于 CPU 密集型任务。

##### "挂起"之后的恢复（resume）
> 挂起函数在执行完成之后，协程会重新切回它原来的线程。
> 所以 Kotlin 中挂起可理解为"一个稍后会被自动切回来的线程调度操作"。
> 恢复功能是协程完成的。因此挂起函数必须在协程中被调用，否则无法完成恢复操作。

##### 具体是如何"挂起"的
> 在使用 `suspend` 关键字修饰的自定义函数中直接或间接地调用 Kotlin 协程框架自带的 `suspend` 函数，才能真正实现挂起操作。
> 而仅仅使用 `suspend` 关键字本身来修饰一个函数，是无法实现挂起操作的。

##### "suspend" 关键字
可简单理解为一个提醒：旨在标明被修饰的函数内部有耗时操作，需要在协程中被调用。
（实际的作用是为了简化编译过程中对上下文代码的管理）

##### 使用场景
有耗时操作的场景中，都可以定义为 `suspend` 函数。例如 IO 操作和 CPU 计算等。

### Lesson 3
> [Kotlin 协程-3](https://kaixue.io/kotlin-coroutines-2/)

##### TODO


