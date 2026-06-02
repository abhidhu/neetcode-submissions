class Solution {
      public int leastInterval(char[] tasks, int n) {
          Map<Character, Integer> map = new HashMap<>();
          for (char c : tasks) {
              map.put(c, map.getOrDefault(c, 0) + 1);
          }

          PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
          pq.addAll(map.keySet());

          int ans = 0;
          while (!pq.isEmpty()) {
              int cycleSize = Math.min(n + 1, pq.size());
              List<Character> processed = new ArrayList<>();

              for (int i = 0; i < cycleSize; i++) {
                  char ch = pq.poll();
                  ans++;
                  map.put(ch, map.get(ch) - 1);
                  if (map.get(ch) > 0) {
                      processed.add(ch);
                  }
              }

              pq.addAll(processed);

              if (!pq.isEmpty()) {
                  ans += (n + 1 - cycleSize);
              }
          }

          return ans;
      }
  }