let problem = () => {
  let rec solve = (n, acc) =>
    switch (n, acc) {
    | (0, _) => acc
    | (n, _) =>
      if (n mod 3 == 0 || n mod 5 == 0) {
        solve(n - 1, acc + n);
      } else {
        solve(n - 1, acc);
      }
    };
  string_of_int(solve(1000 - 1, 0));
};
