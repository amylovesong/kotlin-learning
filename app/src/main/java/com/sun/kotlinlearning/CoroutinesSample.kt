package com.sun.kotlinlearning

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

/**
 *
 * @author sxl (sunxiaoling@didiglobal.com)
 * @since 2020/5/5.
 */
class CoroutinesSample {

    // ① 协程的使用（示例代码）
    /*
    launch({

    })

    // 闭包简化版
    launch {

    }
    */

    // ② 闭包
    fun methodClosure() {
        // 完整版本
        Thread(object : Runnable {
            override fun run() {

            }
        })

        // SAM 的简化版
        Thread({

        })

        // 使用闭包的简化版
        Thread {

        }
    }

    // ③ 基本使用
    fun methodBasic(context: CoroutineContext) {
        val coroutineScope = CoroutineScope(context)
        coroutineScope.launch {
            // ...
        }

        coroutineScope.launch(Dispatchers.IO) {

        }

        coroutineScope.launch(Dispatchers.Main) {

        }

        coroutineScope.launch(Dispatchers.Main) {
            val imageId = 1023456
            val image = getImage(imageId)
            // ...
        }
    }

    // ④ withContext：
    suspend fun getImage(imageId: Int) = withContext(Dispatchers.IO) {

    }

}