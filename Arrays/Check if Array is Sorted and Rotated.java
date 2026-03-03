import java.util.*;
class Solution{
    public boolean check(int []nums){
        int n = nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            if(nums[i]>nums[(i+1)%n]){
                count++;
            }
        }
        return count<=1;
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int []nums = new int[size];

        for(int i=0;i<size;i++){
            nums[i] = sc.nextInt();
        }
        Solution sol = new Solution();
        System.out.println(sol.check(nums));
    }
}
