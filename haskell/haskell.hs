import Data.HashTable as H 
import Data.Maybe
import List
import Data.Char

--Evaluate the sum of all the amicable numbers uner 10000
--amicable numbers are (a,b) where d(a) = b and d(b) = a; a /=b 
--d(n) = numbers less than n which divide evenly into n
--This was rather annoying dealing with the IO monad - Haskell's IO is unlike any I have ever seen before
twentyone = 
  do
    h <- H.new (==) H.hashInt
    addToTable_helper h 10000
    (amicable h 10000 [] >>= \xs -> return $ foldl (\acc (x,y) -> x+y+acc) 0 xs) >>= (\x -> return $ div x 2)  
amicable hash n acc =
  if n == 0
  then return acc
  else
      let a = (d n)
      in
      do
      r <- H.lookup hash a
      case r of
        Just x  -> 
          if (x == n && (not (x == a)))
            then amicable hash (n-1) ((a, x):acc)
            else amicable hash (n-1) acc
        Nothing -> amicable hash (n-1) acc

--Add all the values of n and d(n) to the hashtable
addToTable_helper hash 0 = return 0
addToTable_helper hash n = 
  do
    H.insert hash n (d n)
    addToTable_helper hash (n - 1)

d :: Int -> Int
d n = d' (proper_divisors n) 0 

--a tail recursive d
d' :: [Int] -> Int -> Int
d' [] acc = acc
d' (x:ls) acc = (d' ls (acc + x))

--Returns a list of all proper divisors of n
proper_divisors n = (tail (factors n))

factors n = n:(factors_helper n (n `div` 2))

factors_helper 1 _ = [1]
factors_helper number 1 = [1]
factors_helper number variable = 
  if (number `mod` variable == 0)
    then (variable:(factors_helper number (variable-1) ))
    else factors_helper number (variable-1)

--What is the total of all the namescores in the file?
twentytwo = readFromFile22 

--Replaces the instance of find in s with repl
replace [] _ _ = []
replace s find repl = 
  if take (length find) s == find
    then repl ++ (replace (drop (length find) s) find repl)
    else [head s] ++ (replace (tail s) find repl)

readFromFile22 = do
  xs <- readFile "names.txt"
  let 
    names = (map themiddle (sort (words (replace xs "," " "))))
    name_vals = (map (\word -> (get_name_index names word) * (count_word_val word)) names)
  print (sum name_vals)

--returns the middle part of a list: "Adam" -> "da"
themiddle a = init (tail a)

--returns the index of the name in the list
get_name_index names name = 
  let var = (elemIndex name names)
  in
    do
    case var of
      Just x -> 1 + x
      Nothing -> 0

--returns the value of a name
count_word_val [] = 0
count_word_val (x:word) = 
  (ab_ord x) + (count_word_val word)

--Returns the alphabetic value of the letter a
ab_ord a = 
  ((ord $ toUpper a) - (ord (pred 'A')))

--Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers
twentythree = 0 

--Integer Square root
isqrt :: Int -> Int
isqrt n = floor (sqrt (fromIntegral n))

factors' n = 0

is_factor :: Int -> Int -> Bool
is_factor n i = (n `mod` i == 0)

factors_helper' n 1 = [1]
factors_helper' n i =
  let max = (isqrt n)
      val = i
  in case i of max -> (if (is_factor n max) then [max] else []) 
               otherwise -> if (is_factor n i) then (i:(factors_helper' n (i+1))) else (factors_helper' n (i+1))


sum_of_proper_divisors n = sum (proper_divisors n)

isAbundant n = (n < (sum_of_proper_divisors n))

list_abundant 0 = []
list_abundant n = 
  if (isAbundant n)
    then (n:(list_abundant (n-1))) 
    else list_abundant (n-1) 

list_numbers_not_sum_of_two_abundant_numbers =
  lnnsotan_helper 15000 (sum_of_two_abundant_numbers 15000)

lnnsotan_helper 1 table = [1] 
lnnsotan_helper dec table =
  if (List.elem dec table)
    then lnnsotan_helper (dec - 1) table
    else dec:(lnnsotan_helper (dec - 1) table)

sum_of_two_abundant_numbers n =
  [x+y | x<-(list_abundant n), y<-(list_abundant n)]

--What is the millionth lexicographic permutation of the digits 0,1,2,3,4,5,6,8 and 9?
twentyfour = 0

--What is the first term in the fibonacci sequence to contain 1000 digits?
--need to add 1 to account for f1 = 1, f2 = 1
twentyfive = (find_term 1)+1

--returns the first term with 1000 digits
find_term n = 
  if (countdigits (fib n) == 1000)
    then n
    else find_term (n+1)

--I lifted this algorithm from the haskellwiki page for fast computing the fibonacci sequence
fib = fst . fib2

fib2 0 = (1,1)
fib2 1 = (1,2)
fib2 n 
  | even n    = (a*a + b*b, c*c - a*a)
  | otherwise = (c*c - a*a, b*b + c*c)
  where (a,b) = fib2 (n `div` 2-1)
        c     = a + b

countdigits 0 = 0
countdigits n = 
  1+(countdigits (n `div` 10))
