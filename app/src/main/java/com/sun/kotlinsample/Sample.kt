package com.sun.kotlinsample

import android.view.View

class Sample {
    var view: View? = null
    lateinit var view1: View

    fun cook(name: String): Food? {
        return null
    }

    // 无返回值的函数定义
    fun main(): Unit {}
    fun main1() {}

//    var myName: String? = "sxl"
    var myName: String = "sxl"
    fun test() {
        cook(myName)
    }
}