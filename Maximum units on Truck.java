import java.util.Arrays;

public class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]); 
        int units = 0;

        for (int[] box : boxTypes) {
            int take = Math.min(truckSize, box[0]);
            units += take * box[1];
            truckSize -= take;
            if (truckSize == 0) break;
        }
        return units;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumUnits(new int[][]{{1,3},{2,2},{3,1}}, 4)); 
        System.out.println(new Solution().maximumUnits(new int[][]{{5,10},{2,5},{4,7},{3,9}}, 10)); 
    }
}
