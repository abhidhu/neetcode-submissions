class Solution {
      public double myPow(double x, int n) {
          long e = n;              // widen BEFORE negating
          if (e < 0) {
              x = 1 / x;           // x^-n  ==  (1/x)^n
              e = -e;
          }
          double ans = 1.0;
          while (e > 0) {
              if ((e & 1) == 1) ans *= x;   // last bit set → fold current base in
              x *= x;                        // square the base
              e >>= 1;                       // drop the last bit
          }
          return ans;
      }
  }