--Evaluate the sum of all the amicable numbers under 1000
twentyOne = 7

--returns the list of proper divisors of n (numbers less than n which divide
--evenly into n
proper_divisors n =
  (proper_divisors_helper n (div n 2) [])

proper_divisors_helper n var xs =
  if var == 1
    then var:xs
    else 
      if (n `mod` var) == 0   
        then (proper_divisors_helper n (var-1) (var:xs))
      else
        proper_divisors_helper n (var -1) (xs)

accumulate_proper_divisors_list n ls= 
 if n == 0 
   then ls
   else (n, sum (proper_divisors_helper n)):ls
