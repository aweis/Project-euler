import 'dart:math';

class EulerHelper {
  static bool is_prime(int n) {
    if (n < 2) return false;
    if (n == 2 || n == 3) return true;
    if (n % 2 == 0 || n % 3 == 0) return false;
    int sqrtN = (sqrt(n) + 1).toInt();
    for (int i = 6; i <= sqrtN; i += 6) {
      if (n % (i - 1) == 0 || n % (i + 1) == 0) return false;
    }
    return true;
  }
}
