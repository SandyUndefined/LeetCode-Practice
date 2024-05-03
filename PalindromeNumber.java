class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            int lastDigit = x % 10;
            reversedHalf = reversedHalf * 10 + lastDigit;
            x /= 10;
        }
        return x == reversedHalf || x == reversedHalf / 10;
    }
}

/*
 * Negative Number and Edge Cases:
 * Negative Numbers: All negative numbers are not palindromes because a
 * palindrome reads the same backward as forward, and no negative number can end
 * with a negative sign.
 * Multiples of 10: Any number ending with 0 (except for 0 itself) cannot be a
 * palindrome because there would be no corresponding leading zero in the number
 * (e.g., 10, 20, 100).
 * 
 * Reversing Half of the Integer:
 * The process involves dividing the number by 10 repeatedly to strip off the
 * last digit and simultaneously building the reversed number.
 * Each time you strip off the last digit from the original number (x % 10), you
 * add this digit to the reversed number. The reversed number is constructed by
 * multiplying the current reversedHalf by 10 (shifting it one decimal place)
 * and then adding the last digit of x.
 * This is done until the original number (x) becomes less than the reversed
 * number (reversedHalf). This indicates that more than half of the number has
 * been processed (because the reversed number is being constructed from the
 * back half of the original number).
 * 
 * Comparing Halves for Palindrome Check:
 * Even Length Numbers: For numbers with an even number of digits, by the time x
 * is less than or equal to reversedHalf, the entire second half of the number
 * has been reversed, and you can directly compare x and reversedHalf.
 * Odd Length Numbers: For numbers with an odd number of digits, the middle
 * digit will end up at the beginning of reversedHalf after the loop. This digit
 * is irrelevant for the palindrome check because it does not need to match
 * anything on the other half. Therefore, you compare x and reversedHalf / 10
 * (this effectively removes the middle digit).
 */