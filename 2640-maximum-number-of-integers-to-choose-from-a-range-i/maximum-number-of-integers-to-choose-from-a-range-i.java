class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set = new HashSet<>();

        for(int i:banned){
            set.add(i);
        }   
        int sum = 0;
        int chose = 0;
        for(int i=1;i<=n;i++){
            if(!set.contains(i) && sum + i <= maxSum){
                sum += i;
                chose++;
            }
            
            if(sum >= maxSum){
                break;
            }
        }

        return chose;
    }
}