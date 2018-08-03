import 'Euler.dart';
import 'dart:math';

class Problem6 implements Euler {
  List<int> gen(int n) {
    return new List<int>.generate(n, (i) => i + 1);
  }

  int sumOfSquares(int n) {
    return gen(n).map((i) => pow(i, 2)).fold(0, (i, acc) => i + acc);
  }

  int squareOfSum(int n) {
    return pow(gen(n).fold(0, (i, acc) => i + acc), 2);
  }

  int differenceBetweenThem(int n) {
    return squareOfSum(n) - sumOfSquares(n);
  }

  String answer() {
    return differenceBetweenThem(100).toString();
  }
}
