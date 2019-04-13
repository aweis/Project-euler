let foo = () => print_endline("Hello");

let isPrime = n => {
  let n = abs(n);
  let rec isNotDivisor = d =>
    d * d > n || n mod d != 0 && isNotDivisor(d + 1);
  n != 1 && isNotDivisor(2);
};
