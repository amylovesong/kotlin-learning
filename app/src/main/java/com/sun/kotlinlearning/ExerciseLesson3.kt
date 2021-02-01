package com.sun.kotlinlearning

/**
 *
 * @author sxl (amylovesong.sun@gmail.com)
 * @since 2020/4/12.
 */
class ExerciseLesson3 {
    class Student constructor(var name: String) {
        var age: Int = 0
        var grade: Int = 0

        constructor(name: String, age: Int): this(name) {
            this.age = age
        }

        constructor(name: String, age: Int, grade: Int): this(name, age) {
            this.age = age
            this.grade = grade
        }

        fun show() {
            println("Exercise 3: name is $name, age is $age, grade is $grade.")
        }
    }

    fun methodFilter() {
        val array = intArrayOf(21, 40, 11, 33, 78)

        array
            .filter { i -> i % 3 == 0 }
            .forEach { i -> println("Exercise 3: filter result is $i") }
    }
}