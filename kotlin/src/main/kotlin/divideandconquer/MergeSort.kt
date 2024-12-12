package src.main.kotlin.divideandconquer

/**
 * MERGE SORT is an efficient algorithm that sorts an input array of numbers by recursively splitting it into two halves,
 * sorting each half, and then merging the sorted halves into a single sorted array. The time complexity is O(n log n),
 * making it highly efficient even for large inputs.
 *
 * Other similar algorithms are: SELECTION SORT, INSERTION SORT and BUBBLE SORTS, but they are more inefficient because
 * they all end with a O(n²) result, which represents quadratic running time. This makes them impractical for large datasets
 * compared to algorithms like MERGE SORT.
 *
 * The problem:
 * We have an input of N numbers unsorted. We want as output, the same numbers, sorted in increasing order.
 * Assume that the numbers are distinct.
 *
 * Example:
 * INPUT  -> [5, 4, 1, 8, 7, 2, 6, 3, 9]
 * OUTPUT -> [1, 2, 3, 4, 5, 6, 7, 8, 9]
 */
fun mergeSort(array: IntArray): IntArray {
    return if (array.size <= 1) {
        array
    } else {
        // Create a mid-value
        val mid = array.size / 2

        // DIVIDE: Split the original array in two parts
        val left = array.copyOfRange(fromIndex = 0, toIndex = mid)
        val right = array.copyOfRange(fromIndex = mid, toIndex = array.size)

        // CONQUER: Sort both halves by recursion calls
        val sortedLeft = mergeSort(left)
        val sortedRight = mergeSort(right)

        // Return the merged result
        return merge(sortedLeft, sortedRight)
    }
}

fun merge(left: IntArray, right: IntArray): IntArray {
    val result = IntArray(left.size + right.size)
    var i = 0
    var j = 0
    var k = 0

    // Merge elements while both arrays have elements
    while (i < left.size && j < right.size) {
        if (left[i] < right[j]) {
            result[k++] = left[i++]
        } else {
            result[k++] = right[j++]
        }
    }

    // Add remaining elements from left array
    while (i < left.size) {
        result[k++] = left[i++]
    }

    // Add remaining elements from right array
    while (j < right.size) {
        result[k++] = right[j++]
    }

    return result
}
