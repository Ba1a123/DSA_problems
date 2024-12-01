class Solution {
    public boolean checkIfExist(int[] arr) {
        HashMap<Integer,Integer> s=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            s.put(arr[i],i);
        }
        for(int j=0;j<arr.length;j++){
            // if(s.get(arr[j]*2)==j){
            //     continue;
            // }

            if(s.containsKey(arr[j]*2)){
                if(s.get(arr[j]*2)==j){
                continue;
            }
                return true;
            }
        
        }
        return false;
        
    }
}