package com.sun.kotlinlearning

import androidx.viewpager.widget.ViewPager

/**
 *
 * @author sxl (sunxiaoling@didiglobal.com)
 * @since 2020/4/4.
 */
class CompanionObjectSample {
    companion object {
        val anotherString = "Another String"

        // 静态代码块
        init {

        }
    }

    // 单例（饿汉式）
    object ObjectSample {
        val name = "A"
    }

    fun methodObject() {
        ObjectSample.name
    }

    // 创建匿名类
    val listenr = object: ViewPager.SimpleOnPageChangeListener() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
        }
    }
}