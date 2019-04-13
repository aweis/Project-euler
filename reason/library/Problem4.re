let problem = {
  let isPalindrome = str => {
    let rec isPalindrome_h = str =>
      if (String.length(str) == 0 || String.length(str) == 1) {
        true;
      } else {
        let first = str.[0];
        let last = str.[String.length(str) - 1];
        first == last
        && isPalindrome_h(String.sub(str, 1, String.length(str) - 2));
      };
    isPalindrome_h(str);
  };

  let solve = () => {
    let longest = ref(-1);
    for (i in 100 to 999) {
      for (j in 100 to 999) {
        let product = i * j;
        let str = string_of_int(product);
        if (isPalindrome(str)) {
          longest := max(product, longest^);
        };
      };
    };
    string_of_int(longest^);
  };

  () => solve();
};
