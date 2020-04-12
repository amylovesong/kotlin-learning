package com.sun.kotlinlearning

import java.lang.NumberFormatException

/**
 *
 * @author sxl (sunxiaoling@didiglobal.com)
 * @since 2020/4/11.
 */
class ConditionSample {
    fun methodIfElse(a: Int, b: Int) {
        // ① if/else 直接赋值给 max
        val max = if (a > b) a else b

        // 代码块的最后一行作为结果返回赋值给 min
        val min = if (a < b) {
            println("min:a")
            a // 返回 a
        } else {
            println("min:b")
            b // 返回 b
        }

        // ② when
        var x = 0
        when (x) {
            1 -> { println("1") }
            2 -> { println("2") }
            else -> { println("else") }
        }

        // when 作为表达式使用
        val value: Int = when (x) {
            1 -> { x + 1 }
            2 -> { x * 2}
            else -> { x + 5}
        }

        // 多个分支合并
        when (x) {
            1, 2 -> println("x == 1 or x == 2")
            else -> println("else")
        }

        // 『表达式』作为分支的判断条件
        // in
        when (x) {
            in  1..10 -> println("x in range of 1~10")
            in listOf(1, 2) -> println("x in the list")
            !in 10..20 -> println("x is not in the range of 10~20")
            else -> println("x is not in any range")
        }
        // is
        val y = "s"
        val isString = when(y) {
            is String -> true
            else -> false
        }

        // 省略 when 后面的参数
        var str1 = "abc"
        var str2 = "ABCD"
        when {
            str1.contains("a") -> println("str1 contains a")
            str2.length == 3 -> println("the length of str2 is 3")
        }

        // ③ for
        val array = intArrayOf(1, 2, 3, 4)
        for (item in array) {
            println("item is $item")
        }

        for (i in 1..10) {
            println("i is $i")
        }

        // ④ try-catch
        try {

        } catch (e: Exception) {

        } finally {

        }

        // try-catch 作为表达式
        val a: Int? = try { methodWithThrowable() } catch (e: NumberFormatException) { null }
    }

    private fun methodWithThrowable(): Int? {
        var x = 0;
        return x;
    }
}