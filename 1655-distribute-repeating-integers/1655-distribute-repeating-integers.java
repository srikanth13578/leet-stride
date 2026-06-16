import java.util.*;

class Solution {
    public boolean canDistribute(int[] nums, int[] quantity) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int[] counts = new int[freqMap.size()];
        int idx = 0;
        for (int count : freqMap.values()) {
            counts[idx++] = count;
        }
        Arrays.sort(quantity);
        int m = quantity.length;
        int[] reversedQuantity = new int[m];
        for (int i = 0; i < m; i++) {
            reversedQuantity[i] = quantity[m - 1 - i];
        }
        return backtrack(counts, reversedQuantity, 0);
    }
    
    private boolean backtrack(int[] counts, int[] quantity, int customerIdx) {
        if (customerIdx == quantity.length) {
            return true;
        }
        
        int req = quantity[customerIdx];
        for (int i = 0; i < counts.length; i++) {
            if (i > 0 && counts[i] == counts[i - 1]) {
                continue;
            }
            if (counts[i] >= req) {
                counts[i] -= req;
                if (backtrack(counts, quantity, customerIdx + 1)) {
                    return true;
                }
                counts[i] += req;
            }
        }
        return false;
    }
}