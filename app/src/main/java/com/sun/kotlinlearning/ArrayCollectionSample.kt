package com.sun.kotlinlearning

/**
 *
 * @author sxl (sunxiaoling@didiglobal.com)
 * @since 2020/4/4.
 */
class ArrayCollectionSample {
    // ① Array
    val strs: Array<String> =  arrayOf("a", "b", "c")

    fun methodArray() {
        strs[0]
        strs[1] = "BB"

        // 数组泛型化使得拥有了很多工具函数，更加方便使用
        strs.get(0)
        strs.set(1, "bb")
        strs.contains("c")
        strs.first()
        strs.last()
        strs.find { str -> str.length == 1 }
    }

    // 不支持协变（covariance）
//    val anys: Array<Any> = strs //compile-error

    // ② Collection
    // --List
    val strList = listOf("a", "b", "c")

    val strList1: List<String>  = listOf("a", "b", "c")
    val anyList: List<Any> = strList1 // success

    // --Set
    val strSet = setOf("a", "b", "c")

    // --Map
    val map = mapOf("k1" to 1, "k2" to 2, "k3" to 3, "k4" to 4) // 不可变集合
    val mapMutable = mutableMapOf("k1" to 1, "k2" to 2) // 可变集合

    fun methodMap() {
        val v1 = map.get("k1")
        val v2 = map["k2"]

        mapMutable.put("k1", 11)
        mapMutable["k1"] = 111

        val mapM = map.toMutableMap() // 不可变 -> 可变：返回的是一个新集合，map 依然不可变
    }

    // ③ Sequence
    val sequence = sequenceOf("a", "b", "c")

    val list = listOf("a", "b", "c")
    val sequence2 = list.asSequence() // List 实现了 Iterable 接口

    // lambda 表达式
    val sequence3 = generateSequence(0) { it + 1}

}