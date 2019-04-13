let problem = () => {
  let nthPrime = (numPrimes, currentNumber) => {
    let rec nthPrime_h = (numPrimes, currentNumber, countSoFar) =>
      if (countSoFar == numPrimes) {
        currentNumber - 1;
      } else if (Util.isPrime(currentNumber)) {
        nthPrime_h(numPrimes, currentNumber + 1, countSoFar + 1);
      } else {
        nthPrime_h(numPrimes, currentNumber + 1, countSoFar);
      };
    nthPrime_h(numPrimes, currentNumber, 0);
  };
  string_of_int(nthPrime(10001, 1));
};
