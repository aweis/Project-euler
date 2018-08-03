import "Euler.dart";

class Problem5 implements Euler {
  bool _divisibleByAllUpto(int n, int value) {
    var list = new List<int>.generate(n, (i) => i + 1);
    for (int i in list) {
      if (value % i != 0) {
        return false;
      }
    }
    return true;
  }

  String answer() {
    int counter = 20;
    while (true) {
      if (_divisibleByAllUpto(20, counter)) {
        return counter.toString();
      } else {
        counter++;
      }
    }
  }
}
