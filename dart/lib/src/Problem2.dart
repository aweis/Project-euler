import 'Euler.dart';

class Problem2 implements Euler {
  String answer() {
    var first = 1;
    var second = 2;
    var sum = 2;
    while (first + second < 4000000) {
      var temp = second;
      second = first + second;
      first = temp;
      if (second % 2 == 0) {
        print('even ' + second.toString());
        sum += second;
      }
    }
    return sum.toString();
  }
}
