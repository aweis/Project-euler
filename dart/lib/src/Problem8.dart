import "Euler.dart";
import 'dart:io';

class Problem8 implements Euler {
  String answer() {
    var file = new File("lib/src/text/Problem8.txt");
    var text = file.readAsStringSync().replaceAll(new RegExp(r'\n'), '');
    int maxSoFar = 0;
    var adjacent = 13;
    for (int i = 0; i < text.length - adjacent; i++) {
      List<String> currFour = text.substring(i, i + adjacent).split('');
      int product =
          currFour.map((x) => int.parse(x)).fold(1, (x, acc) => x * acc);
      if (product > maxSoFar) {
        maxSoFar = product;
      }
    }
    return maxSoFar.toString();
  }
}
