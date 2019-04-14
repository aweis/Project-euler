let problem = {
  let square = x => x * x;
  let sum = 1000;
  let break = ref(false);
  let c = ref(3);
  let b = ref(2);
  let a = ref(1);
  let answer = ref(0);
  let solve = () =>
    while (c^ < sum && ! break^) {
      b := 2;
      while (b^ < c^ && ! break^) {
        a := 1;
        while (a^ < b^ && ! break^) {
          if (square(a^) + square(b^) == square(c^) && a^ + b^ + c^ == 1000) {
            break := true;
            answer := a^ * b^ * c^;
          };
          a := a^ + 1;
        };
        b := b^ + 1;
      };
      c := c^ + 1;
    };
  () => {
    solve();
    string_of_int(answer^);
  };
};
