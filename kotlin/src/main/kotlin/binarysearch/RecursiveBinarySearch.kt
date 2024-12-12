package src.main.kotlin.binarysearch

/**
 * Performs a binary search recursively on a sorted array to determine if a target value exists.
 *
 * @param list A sorted array of integers in ascending order.
 * @param target The integer value to search for in the array.
 * @return `true` if the target value is found, or `false` if it is not.
 *
 * The function uses recursion to repeatedly narrow down the search range:
 * 1. If the array is empty, the target is not found, and the function returns `false`.
 * 2. Calculates the midpoint of the current array.
 * 3. If the value at the midpoint matches the target, the function returns `true`.
 * 4. If the value at the midpoint is less than the target, the function recurses with
 *    the upper half of the array (elements after the midpoint).
 * 5. If the value at the midpoint is greater than the target, the function recurses with
 *    the lower half of the array (elements before the midpoint).
 *
 * Time Complexity:
 * - Best case: O(1) if the target is found at the first midpoint.
 * - Average/Worst case: O(log n), where n is the size of the array.
 *
 * Space Complexity:
 * - O(log n) due to the recursive calls and the creation of sub-arrays for each call.
 *
 * Note:
 * - The input array (`list`) must be sorted in ascending order for the function to work correctly.
 * - Edge cases:
 *   - An empty array will return `false`.
 *   - If the target is outside the range of values in the array, the function will return `false`.
 */
fun recursiveBinarySearch(list: IntArray, target: Int): Boolean {
    // Base case: If the array is empty, the target is not found
    if (list.isEmpty()) {
        return false
    } else {
        // Calculate the midpoint of the array
        val mid = list.size / 2

        // Check if the target is at the midpoint
        return if (list[mid] == target) {
            true
        } else {
            // Recursively search in the appropriate half of the array
            if (list[mid] < target) {
                recursiveBinarySearch(
                    list = list.sliceArray((mid + 1) until list.size),
                    target = target,
                )
            } else {
                recursiveBinarySearch(
                    list = list.sliceArray(0 until mid),
                    target = target
                )
            }
        }
    }
}
