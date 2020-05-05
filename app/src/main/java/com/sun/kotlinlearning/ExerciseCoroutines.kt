package com.sun.kotlinlearning

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import android.widget.ImageView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL
import java.util.zip.GZIPInputStream

/**
 *
 * @author sxl (sunxiaoling@didiglobal.com)
 * @since 2020/5/5.
 */
class ExerciseCoroutines {
    val TAG = "ExerciseCoroutines"

    fun printThreadName() {
        val coroutineScope = CoroutineScope(Dispatchers.Main)
        coroutineScope.launch {
            Log.d(TAG, "ThreadName: ${Thread.currentThread().name}")
        }
    }

    fun showImage(imgView: ImageView) {
        val imageUrl = "http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588680487055&di=890642c016b948055e123b58017645c5&imgtype=0&src=http%3A%2F%2Fpic4.zhimg.com%2F50%2Fv2-a71a40410bbc2789cc3f1c0cad413bb8_r.jpg"
        CoroutineScope(Dispatchers.Main).launch {
            val image: Bitmap  = downloadImage(imageUrl)
            imgView.setImageBitmap(image)
        }
    }

    private suspend fun downloadImage(imageUrl: String) = withContext(Dispatchers.IO) {
        val openConnection = URL(imageUrl).openConnection()
        val bytes = if (openConnection.contentEncoding == "gzip") {
            GZIPInputStream(openConnection.getInputStream()).readBytes()
        } else {
            openConnection.getInputStream().readBytes()
        }

        BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    }

}