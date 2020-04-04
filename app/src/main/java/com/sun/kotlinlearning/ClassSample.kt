package com.sun.kotlinlearning

/**
 *
 * @author sxl (sunxiaoling@didiglobal.com)
 * @since 2020/4/4.
 */
class ClassSample {
    val name: String

    // 初始化代码块需要 init 关键字做前缀
    init {

    }

    // 构造器
    constructor(name: String) {
        this.name = name
    }

    // final -> val
    val final = 1

    fun method(final2: String) {
        val final3 = final2
    }

    var varStr: String = "aaa"
    // val 自定义 getter
    val size: Int
        get() {
            return varStr.length
        }

    fun methodCompanionObject() {
        varStr = CompanionObjectSample.anotherString
    }

    fun methodObject() {
        CompanionObjectSample.ObjectSample.name
    }
}