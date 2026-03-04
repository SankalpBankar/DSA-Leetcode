class Solution {
    public int maxArea(int[] height) {
        int maxwater = 0;
        int lp = 0;
        int rp = height.length - 1;

        while (lp < rp) {
            int w = rp - lp;
            int ht = Math.min(height[lp], height[rp]);
            int container = w * ht;
            maxwater = Math.max(maxwater, container);

            if (height[lp] < height[rp])
                lp++;
            else
                rp--;
        }
        return maxwater;
    }
}
