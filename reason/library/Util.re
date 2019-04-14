let foo = () => print_endline("Hello");

let isPrime = n => {
  let n = abs(n);
  let rec isNotDivisor = d =>
    d * d > n || n mod d != 0 && isNotDivisor(d + 1);
  n != 1 && isNotDivisor(2);
};
let readFile = path => {
  let file = open_in(path);
  try (really_input_string(file, in_channel_length(file))) {
  | exn =>
    close_in(file);
    raise(exn);
  };
};
