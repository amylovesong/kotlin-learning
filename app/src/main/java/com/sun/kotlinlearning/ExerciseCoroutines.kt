package com.sun.kotlinlearning

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import android.widget.ImageView
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.net.URL
import java.util.zip.GZIPInputStream

/**
 *
 * @author sxl (amylovesong.sun@gmail.com)
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

    fun showPartOfImage(imageView1 : ImageView, imageView2 : ImageView) {
        val imageUrl = "http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588680487055&di=890642c016b948055e123b58017645c5&imgtype=0&src=http%3A%2F%2Fpic4.zhimg.com%2F50%2Fv2-a71a40410bbc2789cc3f1c0cad413bb8_r.jpg"
        CoroutineScope(Dispatchers.Main).launch {
            val image: Bitmap = downloadImage(imageUrl)

            val image1: Deferred<Bitmap> = async { splitImage(image, 2, 2, 0, 0) }
            val image2: Deferred<Bitmap> = async { splitImage(image, 3, 3, 2, 2) }

            imageView1.setImageBitmap(image1.await())
            imageView2.setImageBitmap(image2.await())
        }
    }

    private fun splitImage(source: Bitmap, row: Int, column: Int, startRow: Int, startColumn: Int): Bitmap {
        val splitWidth = source.width / row
        val splitHeight = source.height / column
        return Bitmap.createBitmap(source, splitWidth * startRow, splitHeight * startColumn, splitWidth, splitHeight)
    }

    fun request(showLoading: () -> Unit, dismissLoading: () -> Unit, showError: () -> Unit, showResult: (String) -> Unit) {
        CoroutineScope(Dispatchers.Main).launch {
            showLoading()
            val response = requestUrl()
            dismissLoading()
            if(!response.isSuccessful) {
                showError()
            }
            showResult("${response.message}: ${response.code}")
        }
    }

    private suspend fun requestUrl(): Response = withContext(Dispatchers.IO) {
        val url = "https://api.github.com/users/amylovesong/repos"
        val request = Request.Builder().url(url).build()
        OkHttpClient().newCall(request).execute()
    }


}