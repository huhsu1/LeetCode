class Solution {
    public int maxArea(int[] height) {
        int length = height.length - 1;
        int maxVolumn = 0;
        for (int i = 0; i < length; i++) {
            int iheight = height[i];
            for (int j = i + 1; j <= length; j++) {
                int volumn = (j - i) * Math.min(height[i], height[j]);
                if (volumn > maxVolumn) {
                    maxVolumn = volumn;
                }
            }
        }
        return maxVolumn;
    }
}
