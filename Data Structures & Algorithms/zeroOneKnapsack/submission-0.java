class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        return dfs(profit, weight, capacity, 0);
    }

    public int dfs(List<Integer> profit, List<Integer> weight, int capacity, int i) {
        if(i == profit.size()) return 0;

        int maxProfit = dfs(profit, weight, capacity, i+1);

        int newCap = capacity - weight.get(i);
        if(newCap >= 0) {
            int p = profit.get(i) + dfs(profit, weight, newCap, i+1);
            maxProfit = Math.max(p, maxProfit);
        }
        return maxProfit;
    }
}
