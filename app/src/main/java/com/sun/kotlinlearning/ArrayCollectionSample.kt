package com.sun.kotlinlearning

/**
 *
 * @author sxl (amylovesong.sun@gmail.com)
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

    // ③ Sequence：惰性集合操作
    val sequence = sequenceOf("a", "b", "c")

    val list = listOf("a", "b", "c")
    val sequence2 = list.asSequence() // List 实现了 Iterable 接口

    // lambda 表达式
    val sequence3 = generateSequence(0) { it + 1}

    fun methodSequence() {
        val sequence = sequenceOf(1, 2, 3, 4)
        val result: Sequence<Int> = sequence
            .map { i ->
                println("methodSequence Map $i")
                i * 2
            }
            .filter { i ->
                println("methodSequence Filter $i")
                i % 3 == 0
            }
        // 只取集合的第一个元素
        // --因为 Sequence 的惰性特征，上面的集合遍历到 3 就会结束（已满足遍历结束条件），4 会被跳过
        println(result.first())
    }

    // ④ 数组与集合的操作符
    val intArray = intArrayOf(1, 2, 3)
    val strList2 = listOf("a", "b", "c")

    fun methodOperation() {
        // forEach
        // i 为数组元素
        intArray.forEach { i ->
            print("$i ")
        }
        println()

        // filter
        // [1, 2, 3] => {2, 3}
        val newList: List<Int> = intArray.filter { i ->
            i != 1
        }
        println("methodOperation filter result: $newList")

        // map
        // [1, 2, 3] => {2, 3, 4}
        val newList1: List<Int> = intArray.map { i ->
            i + 1
        }
        println("methodOperation map result: $newList1")

        // flatMap：为每个元素创建新的集合，最后合并到一个集合中
        // [1, 2, 3] => {"2", "a", "3", "a", "4", "a"}
        val newList2: List<String> = intArray.flatMap { i ->
            listOf("${i + 1}", "a") // 生成新集合
        }
        println("methodOperation flatMap result: $newList2")
    }

    // ⑤ Range
    val range: IntRange = 0..1000 // 闭区间：[0, 1000]
    val range1: IntRange = 0 until 1000 // 半开区间：[0, 1000)
    fun methodRange() {
        for (i in range) { // 默认遍历的步长为1
            print("methodRange $i, ")
        }

        for (i in range1 step 2) {
            print("methodRange $i, ")
        }

        for (i in 10 downTo 1) { // 递减的闭区间：[10, 1]
            print("methodRange $i, ")
        }

        // 这里的 step、downTo 都叫做「中缀表达式」
    }

}