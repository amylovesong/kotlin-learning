package com.sun.kotlinlearning

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.TextView

/**
 *
 * @author sxl (sunxiaoling@didiglobal.com)
 * @since 2020/4/18.
 */
class GenericSample {
    class MyList<T> {
        // ……
    }
    // ① 变量声明
    var textViewsOut: MyList<out TextView> = MyList()
    var textViewsIn: MyList<in TextView> = MyList()

}

// ② Producer & Consumer（类声明时加上 out 和 in）
class Producer<out T> {
    fun produce(): T {
        // ……
        return TODO()
    }
}

fun methodProducer() {
    val producer1: Producer<TextView> = Producer<Button>()
    val producer2: Producer<out TextView> = Producer<Button>()
    val textView: TextView = producer1.produce()
}

class Consumer<in T> {
    fun consume(t: T) {

    }
}

fun methodConsumer(context: Context) {
    val consumer1: Consumer<Button> = Consumer<TextView>()
    val consumer2: Consumer<in Button> = Consumer<TextView>()
    consumer1.consume(Button(context))
}

// ③ * 等价于 out Any
var list: List<*> = TODO()

// ④ where：多个泛型约束边界
open class Animal {}

interface Food {}

class Monster<T> where T: Animal, T: Food {

}

interface MonsterParent<T> {}

// MonsterNew 本身继承自 MonsterParent，泛型 T 也有约束边界
// where 带来更好的可读性
class MonsterNew<T> : MonsterParent<T> where T : Animal {

}

// ⑤ reified
// inline + reified 解决泛型类型判断
inline fun <reified T> printIfTypeMatch(item: Any) {
    if (item is T) {
        println(item)
    }
}




