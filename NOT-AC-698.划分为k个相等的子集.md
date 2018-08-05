# 698. 划分为k个相等的子集

### 描述：
给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
### 示例：
```
输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
输出： True
说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
```
注意:
* 1 <= k <= len(nums) <= 16
* 0 < nums[i] < 10000

### 解答（NOT ACCEPTED）：
```java
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int N = nums.length;
        int sum = 0;
        int average;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        } else {
            average = sum / k;
        }
        int[] visited = new int[nums.length];
        return partition(nums, visited, k, average, 0, 0);
    }

    boolean partition(int[] nums, int[] visited, int k, int average, int startIndex, int curSum) {
        if (k == 1) {
            return true;
        }
        if (curSum > average) {
            return false;
        }
        if (curSum == average) {
            return partition(nums, visited, k - 1, average, 0, 0);
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] != 1) {
                visited[i] = 1;
                if (partition(nums, visited, k, average, i + 1, curSum + nums[i])) {
                    return true;
                }
                visited[i] = 0;
            }
        }
        return false;
    }
```