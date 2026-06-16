class Solution {
      public void islandsAndTreasure(int[][] grid) {
          int rows = grid.length, cols = grid[0].length;
          Queue<int[]> queue = new ArrayDeque<>();

          // 1. SEED: push EVERY gate (0) into the queue as a starting point
          for (int r = 0; r < rows; r++) {
              for (int c = 0; c < cols; c++) {
                  if (grid[r][c] == 0) queue.add(new int[]{r, c});
              }
          }

          int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

          // 2. BFS outward from ALL gates at once
          while (!queue.isEmpty()) {
              int[] cell = queue.poll();
              int r = cell[0], c = cell[1];
              for (int[] d : dirs) {
                  int nr = r + d[0], nc = c + d[1];
                  if (nr < 0 || nc < 0 || nr >= rows || nc >= cols) continue;
                  if (grid[nr][nc] != Integer.MAX_VALUE) continue;  // skip water(-1), gates(0), already-filled land
                  grid[nr][nc] = grid[r][c] + 1;                    // distance = parent's distance + 1
                  queue.add(new int[]{nr, nc});
              }
          }
      }
  }