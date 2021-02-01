package com.sun.kotlinlearning

import android.app.Person

/**
 *
 * @author sxl (amylovesong.sun@gmail.com)
 * @since 2020/4/8.
 */
class ConstructorSample constructor(name: String) { // 主构造器
    var name: String = name

    init { // init 代码块，可以充当主构造器的方法体
        this.name = name
    }

    // 次构造器：需要调用主构造器（直接 or 间接）
    constructor(name: String, id: Int) : this(name) {

    }

    // 间接调用主构造器
    constructor(name: String, id: Int, age: Int) : this(name, id) {

    }
}

// 省略主构造器的 constructor 关键字
class ConstructorSample2(name: String) {

}

// constructor 不可省略的情况：
class ConstructorSamples private constructor(name: String) {

}

// 直接声明属性（同时完成了初始化）
class User(var name: String) {
    init {

    }

    constructor(sample: ConstructorSample) : this(sample.name) {

    }
}