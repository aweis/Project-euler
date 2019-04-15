Console__ObjectPrinter.setMaxLength(5000);
Console__ObjectPrinter.setPrintWidth(5000);
let problem = {
  let genDivisors = num => {
    let rec genDivisors_h = (num, current, acc) => {
      let root = num |> float_of_int |> sqrt |> ceil |> int_of_float;
      if (num == 1) {
        [1];
      } else if (current == root) {
        acc |> List.sort(compare);
      } else if (num mod current == 0) {
        genDivisors_h(num, current + 1, [current, num / current, ...acc]);
      } else {
        genDivisors_h(num, current + 1, acc);
      };
    };
    genDivisors_h(num, 1, []);
  };
  let rec genTriangleNums = (index, lastValue) => {
    let triangleNumber = index + lastValue;
    let numDivisors = triangleNumber |> genDivisors |> List.length;
    if (numDivisors > 500) {
      triangleNumber;
    } else {
      genTriangleNums(index + 1, lastValue + index);
    };
  };
  () => genTriangleNums(1, 0) |> string_of_int;
};
