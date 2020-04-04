package com.sun.kotlinlearning

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), Impl {

    lateinit var view: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view = findViewById(R.id.text_view_hello)
        printViewId(view)
    }

    private fun printViewId(view: View?) {
        println("view.id==>" + view?.id)
    }
}
