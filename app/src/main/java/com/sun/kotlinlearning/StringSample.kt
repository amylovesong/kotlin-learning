package com.sun.kotlinlearning

/**
 *
 * @author sxl (sunxiaoling@didiglobal.com)
 * @since 2020/4/10.
 */
class StringSample {

    fun main() {
        // ① 字符串模板
        val name = "world"
        // 变量：$xx
        println("Hi $name")
        // 表达式：${}
        println("Hi ${name.length}")

        // 转义字符
        val str = "world!\n"
        println("Hi $str")

        // ② 原生字符串
        val nameStr = "kotlin"
        val text  = """
              Hi $name!
            My name is $nameStr.\n
        """
        println(text) // \n不被转义，空格和换行都会被输出，$引用变量有效

        // trimMargin() 函数去掉每行前面的空格：
        val textTrim = """
              |Hi world!
            |My name is kotlin.
        """.trimMargin() // 默认的边界前缀是 | 符号。可以使用其他字符：trimMargin("/")
        println(textTrim)

    }
}