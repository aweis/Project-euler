import 'Euler.dart';
import 'EulerHelper.dart';

class Problem10 implements Euler {
  String answer() {
    int counter = 1;
    List<int> arr = [];
    while (true) {
      if (counter >= 2000000) {
        break;
      }
      if (EulerHelper.is_prime(counter)) {
        arr.add(counter);
      }
      counter++;
    }
    return arr.fold(0, (curr, acc) => curr + acc).toString();
  }
}
