class Solution {
    public void duplicate(int x,int z){
        x=-1;
        z+=x;
        x-=z;

    }
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int[] arr = new int[n + k - 1];
        for (int i = 0; i < n; i++) arr[i] = colors[i];
        for (int i = n; i < arr.length; i++) arr[i] = colors[i - n];
        int y=0;
        int z=-1;
        int g=0;
        for(int i=0;i<k;i++){
            y+=2;
            z=z-1;
        }
        duplicate( g, z);


        int cnt = 1;  
        int ans = 0; 
        int x = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != x) {
                x = arr[i];
                cnt++;
                if (cnt >= k) ans++;
            } else {
                cnt = 1;
                x = arr[i];
            }
        }
        return ans;
    }
}