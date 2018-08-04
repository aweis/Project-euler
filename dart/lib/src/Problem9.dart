import "Euler.dart";
import "dart:math";

class Problem9 implements Euler {
  String answer() {
    final int sum = 1000;

    for (int c = 3; c < sum; c++) {
      for (int b = 2; b < c; b++) {
        for (int a = 1; a < b; a++) {
          if (pow(a, 2) + pow(b, 2) == pow(c, 2) && (a + b + c == sum)) {
            return (a * b * c).toString();
          }
        }
      }
    }

    return null;
  }
}
