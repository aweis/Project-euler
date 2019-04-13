open Printf;

let problem = {
  let sumOfEvens = l =>
    List.filter(elem => elem mod 2 == 0, l) |> List.fold_left((+), 0);
  let solve = n => {
    let break = ref(false);
    let ahead = ref(2);
    let behind = ref(1);
    let fibonnaci = ref([1, 2]);
    while (! break^) {
      let sum = ahead^ + behind^;
      if (sum > n) {
        break := true;
      } else {
        fibonnaci := List.append(fibonnaci^, [sum]);
        behind := ahead^;
        ahead := sum;
      };
    };
    string_of_int(sumOfEvens(fibonnaci^));
  };

  () => solve(4_000_000);
};
