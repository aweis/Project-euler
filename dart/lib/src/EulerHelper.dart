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

  static List<int> primeFactorization(int n) {
    int upTo = sqrt(n).toInt();
    List<int> list = [];
    for (int i = 1; i <= upTo; i++) {
      if (is_prime(i)) {
        list.add(i);
      }
    }
    if (is_prime(n)) {
      list.add(n);
    }
    return list;
  }
}
