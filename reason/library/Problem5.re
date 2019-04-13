let problem = {
  let rec evenlyDivisible = (n, current, limit) =>
    if (current == limit + 1) {
      true;
    } else {
      n mod current == 0 && evenlyDivisible(n, current + 1, limit);
    };
  let rec find = n =>
    if (evenlyDivisible(n, 1, 20)) {
      n;
    } else {
      find(n + 1);
    };
  () => string_of_int(find(1));
};
