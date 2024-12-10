import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int maximumLength(String s) {
    
        List<String> subarrays = new ArrayList<>();

       
        for (int i = 0; i < s.length(); i++) {
            int index = i;
            
            while (index < s.length() && s.charAt(index) == s.charAt(i)) {
                subarrays.add(s.substring(i, index + 1)); // Add substring to list
                index++;
            }
        }

        
        Map<String, Integer> counter = new HashMap<>();
        for (String sub : subarrays) {
            counter.put(sub, counter.getOrDefault(sub, 0) + 1);
        }

       
        int maxLen = 0;
        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            String substring = entry.getKey();
            int count = entry.getValue();

           
            if (count >= 3) {
                maxLen = Math.max(maxLen, substring.length());
            }
        }

        
        return maxLen == 0 ? -1 : maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

       
        String input = "aabbbaa";
        System.out.println("Maximum length: " + solution.maximumLength(input));
    }
}
