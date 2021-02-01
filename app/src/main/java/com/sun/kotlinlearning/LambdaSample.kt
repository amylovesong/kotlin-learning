package com.sun.kotlinlearning

import android.view.View
import android.widget.TextView

/**
 *
 * @author sxl (amylovesong.sun@gmail.com)
 * @since 2020/5/1.
 */
class LambdaSample {
    fun b(param: Int): String {
        val result = param * 2
        return "$result"
    }

    fun a(f: (Int) -> String) {
        f(2)
    }

    fun methodSample() {
        // ① 函数类型
        // 函数类型的使用：注意前面的双冒号。双冒号使函数变成了(函数类型的)对象
        a(::b)
        val d = ::b

        // 对函数 b 的使用
        b(1)
        d(1)
        (::b)(1)

        // 函数类型的对象有一个 invoke() 方法
        d(2) // 实际上会调用 d.invoke(2)

        // ② 匿名函数
        a(fun(param: Int): String {
            return param.toString()
        })
        val f =  fun(param: Int): String {
            val result = param * 10
            return "$result"
        }

        fun setOnClickListener(onClick: (View) -> Unit) {
            println(onClick)
            // ...
        }

        setOnClickListener(fun(v: View): Unit{
            println(v)
        })

        // 再简化一点的写法：lambda 表达式
        setOnClickListener({ v: View ->
            println(v)
        })

        // ③ lambda（变形）
        // -- 1. lambda 是函数的最后一个参数：写在圆括号外
        setOnClickListener() { v: View ->
            println(v)
        }
        // -- 2. lambda 是函数的唯一参数：省略圆括号()
        setOnClickListener { v: View ->
            println(v)
        }
        // -- 3. lambda 是单参数的：省略参数
        setOnClickListener {
            println(it)
        }
        // -- 4. 给变量赋值时，不能省略参数类型(因为没有足够的上下文来推导参数类型)
        val fc = { param: Int ->
            // lambda 的最后一行代码就是它的返回值
            param.toString()

            // return 会直接结束外层函数（methodSample）
//            return param.toString()
        }


    }

}