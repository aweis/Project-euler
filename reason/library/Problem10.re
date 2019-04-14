let problem = {
  let rec findSumOfPrimesBelow = (n, current, acc) =>
    if (current == n) {
      List.rev(acc);
    } else if (Util.isPrime(current)) {
      findSumOfPrimesBelow(n, current + 1, [current, ...acc]);
    } else {
      findSumOfPrimesBelow(n, current + 1, acc);
    };
  () =>
    string_of_int(
      findSumOfPrimesBelow(2_000_000, 2, []) |> List.fold_left((+), 0),
    );
};
