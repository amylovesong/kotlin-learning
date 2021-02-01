package com.sun.kotlinlearning

/**
 *
 * @author sxl (amylovesong.sun@gmail.com)
 * @since 2020/4/8.
 */
class FunctionSample {
    fun area(width: Int, height: Int): Int {
        return width * height
    }

    // 函数简化
    // 返回类型可以省略（「类型推断」特性），但不推荐
    fun area1(width: Int, height: Int): Int = width * height

    // 无返回值的情况，也可以理解为返回值是 Unit
    fun sayHi(name: String) = println("Hi $name")

    // 参数默认值：方法重载
    fun sayHello(name: String = "world") = println("Hello $name")

    // 命名参数
    fun showInfo(name: String =  "world", age: Int) {
        println("My name is $name, I'm $age")
    }

    // 本地函数（嵌套函数）
    fun login(user: String, password: String, illegalStr: String) {
        fun validate(value: String) {
            if (value.isEmpty()) {
                // 这里直接使用了外层函数的参数
                throw IllegalArgumentException(illegalStr)
            }
        }

        validate(user)
        validate(password)

        // lambda 表达式 + require() 函数
        require(user.isNotEmpty()) { illegalStr }
        require(password.isNotEmpty()) { illegalStr }
    }

    fun main() {
        sayHello() // 使用默认值
        sayHello("S")

        showInfo(age = 20) //『命名参数』
        showInfo("S", 18) // 『位置参数』
//        showInfo(name = "S", 18) // 会报错
        showInfo("S", age = 18) //『混合使用』时，『位置参数』要在第一个『命名参数』前！
        showInfo(age = 18, name = "S") //『命名参数』无序
    }

}