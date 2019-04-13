let problem = {
  let maxInList = (ls) => {
    switch(ls) {
      | [] => -1
      | [x, ...xs] => List.fold_left(max, x, xs);
    }
  };
  let solve = n => {
    let break = ref(false);
    let counter = ref(2);
    let number = ref(n);
    let primeFactors = ref([]);
    while (! break^) {
      if (number^ == 1 || number^ == 0) { // or we reached the sqrt part
        break := true;
      } else if (Util.isPrime(counter^)) {
        if (number^ mod counter^ == 0) {
          while (number^ mod counter^ == 0) {
            number := number^ / counter^;
          };
          if(n != counter^) {
            primeFactors := primeFactors^ @ [counter^];
          }
        }
      };
      counter := counter^ + 1;
    };
    primeFactors^;
  };
  () => string_of_int(maxInList(solve(600851475143)));
};
