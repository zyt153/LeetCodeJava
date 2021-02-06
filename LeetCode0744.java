/* Find Smallest Letter Greater Than Target
 * Input: letters = ["c", "f", "j"] target = "d"
 * Output: "f"
 * */

public class LeetCode0744 {
    public static void main(String args[]){
        char[] letters = {'c', 'f', 'j'};
        char target = 'd';
        System.out.println(nextGreatestLetter(letters, target));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int left = 0;
        int right = n - 1;
        while (left <= right){
            int middle = left + (right - left) / 2;
            if (letters[middle] <= target)
                left = middle + 1;
            else
                right = middle - 1;
        }
        return left < n ? letters[left] : letters[0];
    }
}
