import "./Euler.dart";

class Problem4 implements Euler {
  bool _isPalindrome(String s) {
    if (s.length == 0 || s.length == 1) {
      return true;
    }

    if (s[0] == s[s.length - 1]) {
      return _isPalindrome(s.substring(1, s.length - 1));
    }
    return false;
  }

  String answer() {
    var largest = 0;
    for (var i = 100; i < 1000; i++) {
      for (var j = 100; j < 1000; j++) {
        var product = i * j;
        if (_isPalindrome(product.toString())) {
          if (product > largest) {
            largest = product;
          }
        }
      }
    }
    return largest.toString();
  }
}
