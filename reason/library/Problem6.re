let problem = () => {
  ();
  let square = x => x * x;
  let sumOfSquares = List.fold_left((a, b) => a + square(b), 0);
  let squareOfSum = ls => square(List.fold_left((+), 0, ls));
  let genList = (first, last) => {
    let rec genList_h = (first, last, acc) =>
      if (first == last) {
        [last, ...acc];
      } else {
        genList_h(first + 1, last, [first, ...acc]);
      };
    genList_h(first, last, []);
  };
  let x = genList(1, 100);
  let differenceBetweenSums = ls => squareOfSum(ls) - sumOfSquares(ls);
  string_of_int(differenceBetweenSums(x));
};
