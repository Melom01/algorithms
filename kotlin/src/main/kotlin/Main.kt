package src.main.kotlin

import src.main.kotlin.binarysearch.binarySearch
import src.main.kotlin.binarysearch.linearSearch
import src.main.kotlin.binarysearch.recursiveBinarySearch
import src.main.kotlin.divideandconquer.karatsuba
import src.main.kotlin.divideandconquer.mergeSort
import java.math.BigInteger

fun main() {
    println(
        linearSearch(
            list = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
            target = 10
        )
    )

    println(
        binarySearch(
            list = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
            target = 10
        )
    )

    println(
        recursiveBinarySearch(
            list = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
            target = 10
        )
    )

    println(
        mergeSort(
            intArrayOf(5, 4, 1, 8, 7, 2, 6, 3, 9)
        ).toList()
    )

    println(
        karatsuba(
            x = BigInteger("3141592653589793238462643383279502884197169399375105820974944592"),
            y = BigInteger("2718281828459045235360287471352662497757247093699959574966967627"),
        )
    )
}
