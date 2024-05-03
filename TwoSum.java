import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] {map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

/*
 * num {2,7,11} tagert = 9
 * 
 * map =
 * {
 * 7 -> 0,
 * 
 * }
 * Detailed Step-by-Step Explanation
 * 
 * Initialization:
 * Create an empty hashmap. This will be used to store the necessary data during
 * the iteration over the array.
 * 
 * Iterate Through the Array:
 * Current Element Check: For each element nums[i] in the array, check if it
 * exists as a key in the hashmap. The presence of nums[i] as a key in the
 * hashmap means that we have previously encountered another element which, when
 * added to nums[i], equals the target. This is because the keys in the hashmap
 * are actually the complements (target - previous element) of the previously
 * seen elements.
 * Store Complement: If nums[i] is not found in the hashmap, compute its
 * complement by subtracting nums[i] from the target (i.e., target - nums[i]).
 * Store this complement as a key in the hashmap, with its value being the
 * current index i. This setup implies that if in a future iteration we
 * encounter an element that matches this stored key, we know that the current
 * element and the element at index i (stored as the value of the key) sum up to
 * the target.
 * 
 * Returning the Result:
 * Found Pair: If at any point a key is found in the hashmap during the
 * iteration (i.e., map.containsKey(nums[i]) returns true), it means that the
 * current element and the element at the index stored as the value of that key
 * are the two numbers that sum up to the target. Therefore, return these two
 * indices.
 * No Pair Found: If the entire array is processed without finding such a pair,
 * it indicates that no two numbers sum up to the target. Thus, an exception is
 * thrown indicating the absence of a solution.
 * 
 */