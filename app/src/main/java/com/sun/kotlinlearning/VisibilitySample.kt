package com.sun.kotlinlearning

/**
 *
 * @author sxl (sunxiaoling@didiglobal.com)
 * @since 2020/4/4.
 */
class VisibilitySample {
    private val propertyInClass = 1
}

private val propertyInFile = "A"

class Outter {
    fun method() {
        val inner = Inner()

//        val result = inner.number * 2 // compile-error
    }

    class Inner {
        private val number = 1
    }
}

private class PrivateClass {
    val number = 1
    fun method() {
        println("Private class method()")
    }
}

private val privateClass = PrivateClass()

