class Solution {
      public int[] minInterval(int[][] intervals, int[] queries) {
          Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
          int[] sortedIdx = IntStream.range(0, queries.length)
              .boxed()
              .sorted((a, b) -> queries[a] - queries[b])
              .mapToInt(i -> i)
              .toArray();

          PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - a[0]) - (b[1] - b[0]));
          int[] ans = new int[queries.length];
          int j = 0;

          for (int i = 0; i < sortedIdx.length; i++) {
              int q = queries[sortedIdx[i]];
              // add all intervals whose left <= q
              while (j < intervals.length && intervals[j][0] <= q) {
                  pq.offer(intervals[j]);
                  j++;
              }
              // evict expired intervals (right < q)
              while (!pq.isEmpty() && pq.peek()[1] < q) {
                  pq.poll();
              }
              ans[sortedIdx[i]] = pq.isEmpty() ? -1 : pq.peek()[1] - pq.peek()[0] + 1;
          }
          return ans;
      }
  }