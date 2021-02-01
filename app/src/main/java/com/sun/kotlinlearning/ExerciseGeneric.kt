package com.sun.kotlinlearning

import android.util.Log

/**
 *
 * @author sxl (amylovesong.sun@gmail.com)
 * @since 2020/4/18.
 */
class ExerciseGeneric {
    private val TAG: String = "ExerciseGeneric"

    open class Book {

    }

    open class EnglishBook: Book() {

    }

    class EnglishMagazine: EnglishBook() {

    }

    private fun <T> fill(array: Array<in T>, t: T) {
        array[0] = t
    }

    private fun <T> copy(src: Array<out T>, dest: Array<in T>) {
        for (i in src.indices) {
            dest[i] = src[i]
        }
    }

    fun methodSample() {
        val books: Array<Book> = arrayOf(Book())
        val englishBook = EnglishBook()

        println("before fill books: ")
        logArray(books)
        fill(books, englishBook)
        println("after fill books: ")
        logArray(books)

        val srcArray: Array<EnglishBook> = arrayOf(EnglishMagazine(), EnglishMagazine())
        val destArray: Array<Book> = Array(3) { Book() }
        println("before copy destArray: ")
        logArray(destArray)
        copy(srcArray, destArray)
        println("after copy destArray: ")
        logArray(destArray)
    }

    private fun <T> logArray(array: Array<T>) {
        array.forEach { println("\t$it")}
    }

    private fun println(msg: String) {
        Log.d(TAG, msg)
    }

}