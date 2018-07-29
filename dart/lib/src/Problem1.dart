import 'Euler.dart';

class Problem1 implements Euler {
  String answer() {
    String answer_h(int upto) {
      var list = new List<int>.generate(upto - 1, (i) => i + 1);
      var sum = 0;
      for (int i in list) {
        if ((i % 3 == 0) || (i % 5 == 0)) {
          sum += i;
        }
      }
      return sum.toString();
    }

    return answer_h(1000);
  }
}
