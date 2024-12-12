package src.main.kotlin.binarysearch

/**
 * Performs a binary search on a sorted array to find the index of a target value.
 *
 * @param list A sorted array of integers in ascending order.
 * @param target The integer value to search for in the array.
 * @return The index of the target value if found, or null if not found.
 *
 * The function uses the binary search algorithm, which operates by dividing the
 * search range in half during each iteration:
 * 1. Calculates the midpoint of the current range.
 * 2. If the value at the midpoint matches the target, the index is returned.
 * 3. If the value at the midpoint is less than the target, the search continues
 *    in the upper half of the range.
 * 4. If the value at the midpoint is greater than the target, the search continues
 *    in the lower half of the range.
 *
 * Time Complexity:
 * - Best case: O(1) if the target is found at the first midpoint.
 * - Average/Worst case: O(log n), where n is the size of the array.
 *
 * Space Complexity:
 * - O(1) as it uses only a few integer variables.
 *
 * Note:
 * - The input array (`list`) must be sorted in ascending order for the function to work correctly.
 * - Edge cases:
 *   - An empty array will return null.
 *   - If the target is outside the range of values in the array, the function will return null.
 */
fun binarySearch(list: IntArray, target: Int): Int? {
    // Get the length of first and last element of the list
    var first = 0
    var last = list.size - 1

    // Perform the binary search loop
    while (first <= last) {
        val mid = (first + last) / 2

        // Check if the target value is found at the midpoint
        if (list[mid] == target) {
            return mid
        } else if (list[mid] < target){
            // Narrow the search to the upper half
            first = mid + 1
        } else {
            // Narrow the search to the lower half
            last = mid - 1
        }
    }

    // Return null if the target value is not found
    return null
}