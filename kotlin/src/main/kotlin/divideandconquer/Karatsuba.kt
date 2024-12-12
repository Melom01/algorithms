package src.main.kotlin.divideandconquer

import java.math.BigInteger

/**
 * The Karatsuba multiplication is useful to multiply big numbers in an efficient way.
 * Based on the divide and conquer technique, it reduces the time complexity from O(n²) to O(n)
 *
 * #### Pseudocode:
 * Given the two numbers represented by X and Y:
 * - X = a * 10^m + b
 * - Y = c * 10^m + d
 *
 * The algorithm will compute:
 * 1. **ac**: product of high parts
 * 2. **bd**: product of low parts
 * 3. **(a + b) * (c + d)**: product of the sum of high and low parts
 *
 * By using the formula:
 * - X * Y = ac * 10^(2m) + ((a + b) * (c + d) - ac - bd) * 10^m + bd
 *
 * #### Time and space complexity
 * - **Time**: O(n^log2(3)) ≈ O(n^1.585)
 * - **Space**: O(log n) in an optimal scenario
 *
 * @param x First integer to multiply.
 * @param y Second integer to multiply.
 * @return The product of x and y using the Karatsuba method.
 */
fun karatsuba(x: BigInteger, y: BigInteger): BigInteger {
    // Base case with a single digit multiplication
    if (x < BigInteger.TEN || y < BigInteger.TEN) {
        return x * y
    }

    // Get the size of the numbers
    val n = maxOf(x.toString().length, y.toString().length)
    val m = n / 2

    // DIVIDE: Split the numbers x and y into two parts
    val tenPowM = BigInteger.TEN.pow(m)
    val highX = x / tenPowM // Most significant part
    val lowX = x % tenPowM // Least significant part
    val highY = y / tenPowM
    val lowY = y % tenPowM

    // CONQUER: Recursive calls
    val z0 = karatsuba(lowX, lowY) // bd
    val z1 = karatsuba(highX + lowX, highY + lowY) // (a+b)*(c+d)
    val z2 = karatsuba(highX, highY) // ac

    // RESULT: combine the results into one
    return z2 * tenPowM.pow(2) + (z1 - z2 - z0) * tenPowM + z0
}
