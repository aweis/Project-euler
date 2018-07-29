import "./Euler.dart";
import './EulerHelper.dart';
import 'dart:math';

class Problem3 implements Euler {
  String answer() {
    String answer_h(int upto) {
      int max = sqrt(upto).toInt();
      var list = [];
      for (var i = 2; i <= max; i++) {
        if ((upto % i) == 0 && EulerHelper.is_prime(i)) {
          list.add(i);
        }
      }
      print(list);
      return null;
    }

    return answer_h(600851475143);
  }
}
