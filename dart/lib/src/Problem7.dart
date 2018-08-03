import 'Euler.dart';
import 'EulerHelper.dart';

class Problem7 implements Euler {
  String answer() {
    int counter = 1;
    int primesSoFar = 0;
    while (true) {
      if (primesSoFar == 10001) {
        return counter.toString();
      }
      counter++;
      if (EulerHelper.is_prime(counter)) {
        primesSoFar++;
      }
    }
  }
}
