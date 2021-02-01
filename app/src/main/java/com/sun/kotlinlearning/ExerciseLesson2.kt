package com.sun.kotlinlearning

/**
 *
 * @author sxl (amylovesong.sun@gmail.com)
 * @since 2020/4/4.
 */

fun createLesson2(): ExerciseLesson2 {
    return ExerciseLesson2.create()
}

class ExerciseLesson2 {
    var description: String

    private constructor(description: String) {
        this.description = description
    }

    companion object {
        fun create(): ExerciseLesson2 {
            return ExerciseLesson2("Lesson 2 is about constructor、object and many other important features")
        }

        private const val size = 100_000;

        fun timeCostOfArray(): String {
            val start: Long =  System.currentTimeMillis()
            val array = Array(size) { i -> i + 1 }

            val avg = array.average()
            val timeCost = System.currentTimeMillis() - start

            val result = "Array timeCost=$timeCost avg =$avg"
            println(result)

            return result
        }

        fun timeCostOfIntArray(): String {
            val start: Long =  System.currentTimeMillis()
            val intArray = IntArray(size) { i -> i + 1 }

            val avg = intArray.average()
            val timeCost = System.currentTimeMillis() - start

            val result = "IntArray timeCost=$timeCost avg =$avg"
            println(result)

            return result
        }

        fun timeCostOfList(): String {
            val start: Long =  System.currentTimeMillis()
            val list = MutableList(size) { i -> i + 1 }

            val avg = list.average()
            val timeCost = System.currentTimeMillis() - start

            val result = "List timeCost=$timeCost avg =$avg"
            println(result)

            return result
        }
    }

}