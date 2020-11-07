/* Queue Reconstruction by Height
 * Input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * Output: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * */

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class LeetCode0406 {
    public static void main(String args[]) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] res = reconstructQueue(people);
        for(int i = 0; i < people.length; i++){
            for(int j = 0;j < 2; j++){
                System.out.print(res[i][j] + ",");
            }
            System.out.println(" ");
        }
    }

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 如果身高相同，则按第二项升序排列
                // 如果身高不同，则按身高降序排列
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        List<int[]> output = new LinkedList<>();
        for(int[] p : people){
            output.add(p[1], p);        //向p[1]位置插入p
        }
        int[][] res = new int[people.length][2];
        output.toArray(res);
        return  res;
    }
}
