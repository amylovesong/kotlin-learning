package com.sun.kotlinlearning

/**
 *
 * @author sxl (sunxiaoling@didiglobal.com)
 * @since 2020/4/12.
 */
class OperationSample {
    // 判空操作符：?:
    var str: String? = "Hello"
//    var length: Int = str?.length
    var length: Int = str?.length ?: -1 // 如果 str 的值为空，那么 str?.length 表达式的值也为空，此时返回 ?: 右侧的值：-1

    fun validate(user: User) {
        val name = user.name ?: return // 如果 use.name 为空，则 return
    }

    // 与上面👆 validate() 的逻辑等价
    fun validate1(user: User) {
        if (user.name == null) {
            return
        }
        val nameNew = user.name
    }

    // 判等操作符：==、===
    fun methodEqualSample() {
        val str1 = "123"
        val str2 = "123"
        // == 等价于 Java 的 equals()
        // === 是引用地址的比较
        println("str1 == str2 result: ${str1 == str2}")
        println("str1 === str2 result: ${str1 === str2}")

        val str = "String"
        val str3 = str
        val str4 = str
        println("str3 === str4 result: ${str3 === str4}")

        val str5 = StringBuilder().append("abc").toString()
        val str6 = StringBuilder().append("abc").toString()
        println("str5 == str6 result: ${str5 == str6}")
        println("str5 === str6 result: ${str5 === str6}")
    }
}