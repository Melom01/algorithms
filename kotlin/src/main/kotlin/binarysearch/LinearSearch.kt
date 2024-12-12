package src.main.kotlin.binarysearch

/**
 * Performs a linear search on an array to find the index of a target value.
 *
 * @param list An array of integers to search through.
 * @param target The integer value to search for in the array.
 * @return The index of the target value if found, or `null` if not found.
 *
 * The function iterates through the array one element at a time:
 * 1. Checks each element in the array to see if it matches the target value.
 * 2. If a match is found, the index of the element is returned immediately.
 * 3. If no match is found after checking all elements, the function returns `null`.
 *
 * Time Complexity:
 * - Best case: O(1) if the target is the first element in the array.
 * - Average/Worst case: O(n), where n is the size of the array.
 *
 * Space Complexity:
 * - O(1) as the function operates in constant space.
 *
 * Note:
 * - The input array does not need to be sorted.
 * - This method is simple but less efficient for large arrays compared to binary search.
 */
fun linearSearch(list: IntArray, target: Int): Int? {
    // Iterate through the array
    for (i in list.indices) {
        // Check if the current element matches the target
        if (list[i] == target) {
            return i
        }
    }

    // Return null if the target is not found
    return null
}
