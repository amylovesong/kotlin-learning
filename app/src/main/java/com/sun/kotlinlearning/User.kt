package com.sun.kotlinlearning

class User {
    var name: String? = null
    var value: String = "hello"
    // 类型推断
    var name1 = "sxl"
        // 定义 getter/setter「钩子」：
        get() {
            return field + " ~"
        }
        set(value) {
            field = "Cute " + value
        }
    // 只读变量
    val size = 18

    fun test () {
        name1 = ""
//        size = 1
    }

    // getter/setter
    fun run() {
        name = "Mary" // 实际 => setName("Mary")

        println(name) // 实际 => getName()
    }

}