package com.sun.kotlinlearning

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
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

    fun methodTopLevel() {
        topLevelFunction()
    }

    fun methodConst() {
        ConstSample.CONST_NUMBER
        CONST_NUMBER_TOP_LEVEL
    }

    fun methodCreateLesson2() {
        val lesson2 = createLesson2()
        val anotherLesson2 = ExerciseLesson2.create()
    }

    fun onClick(view: View) {
        val timeCostResult = when (view.id) {
            R.id.btn_time_cost_array -> ExerciseLesson2.timeCostOfArray()
            R.id.btn_time_cost_int_array -> ExerciseLesson2.timeCostOfIntArray()
            R.id.btn_time_cost_list -> ExerciseLesson2.timeCostOfList()
            else -> ""
        }

        if (!TextUtils.isEmpty(timeCostResult)) {
            (view as? Button)?.text = timeCostResult
        }
    }

    override fun onResume() {
        super.onResume()

        val arrayCollectionSample =  ArrayCollectionSample()
        arrayCollectionSample.methodOperation()
        arrayCollectionSample.methodSequence()

        OperationSample().methodEqualSample()

        // Exercise of Lesson 3
        val studentS: ExerciseLesson3.Student = ExerciseLesson3.Student("S", 18, 100)
        val studentA: ExerciseLesson3.Student = ExerciseLesson3.Student("A", 18)
        studentS.show()
        studentA.show()

        val exerciseLesson3 = ExerciseLesson3()
        exerciseLesson3.methodFilter()

        // Exercise of Generics
        val exerciseGeneric = ExerciseGeneric()
        exerciseGeneric.methodSample()

        // Exercise of Coroutines
        val exerciseCoroutines = ExerciseCoroutines()
        exerciseCoroutines.printThreadName()
    }

    fun showImage(view: View) {
        ExerciseCoroutines().showImage(view as ImageView)
    }

    fun showPartOfImage(view: View) {
        ExerciseCoroutines().showPartOfImage(findViewById(R.id.img1), findViewById(R.id.img2))
    }

    fun requestUrl(view: View) {
        ExerciseCoroutines().request(::showLoading, ::dismissLoading, ::showError, ::showResult)
    }

    private fun showLoading() {
        findViewById<ProgressBar>(R.id.pb_loading).visibility = View.VISIBLE
    }

    private fun dismissLoading() {
        findViewById<ProgressBar>(R.id.pb_loading).visibility = View.GONE
    }

    private fun showError() {
        Toast.makeText(this, "Something's wrong!", Toast.LENGTH_SHORT).show()
    }

    private fun showResult(result: String) {
        findViewById<TextView>(R.id.tv_request_result).let {
            it.text = result
            it.visibility = View.VISIBLE
        }
    }
}
