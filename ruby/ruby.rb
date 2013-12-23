#Find the sum of all the multiples of 3 or 5 below 1000
def one
  acc = 0
  for i in 1...1000
    if i % 3 == 0 || i % 5 == 0
      acc = acc + i
    end
  end
  acc
end

#Find the sum of the even fibonacci numbers from 1..4 million
def two
  first = 1
  second = 2
  third = 0
  acc = second #initialized to first even term
  begin
    third = first + second
    if third > 4000000
      break
    end
    puts third
    if third%2 == 0
      acc+=third
    end
    first = second
    second = third
  end while true
  acc
end

#What is the largest prime factor of the number 600851475143
def three num
  max = 0
  acc = 1
  for i in 2..num
    if num % i == 0  #first check if i divides the number
      if isPrime?(i) #then check if it is prime (part of the prime factorization)
        max = i   #keep the max so far
        temp = num #this loop is for numbers made up of many of the same prime i.e. 2^32
        while (temp % i == 0)
          temp = temp / i
          acc = acc * i
          if acc == num
            return max
          end
        end
      end
    end
  end
  return max
end

#this is the solution to euler 3 except using my prime factorization method as a helper

def three_b num
  a = prime_factorization num
  return a[a.size-2]
end

#returns the prime factorization of the number num in a list [Prime, exp, Prime, exp ...]
#modified the 3rd problem in project euler to keep track of primes in a list
def prime_factorization num
  acc = 1
  ans = Array.new
  for i in 2..num
    if num % i == 0
      if isPrime?(i)
        temp = num
        count = 0
        ans.push(i)
        while (temp % i == 0)
          count = count + 1
          temp = temp / i
          acc = acc * i
        end
        ans.push(count)
        if acc == num
          return ans
        end
      end
    end
  end
end

#returns whether or not a nonnegative > 1 is prime
def isPrime? x
  max = Math.sqrt(x).truncate
  for i in 2..max
    if (x % i) == 0
      return false
    end
  end
  return true
end

#find the largest palindromic number made from the product of two 3 digit numbers
def four 
  max = 0
  for i in 100..999
    for j in 100..999
      if isPalindrome?(x = i*j)
        if x > max
          max = x
        end
      end
    end
  end
  return max
end

def isPalindrome? num
  numls = numTo_a(num, [])
  isPalindrome_helper numls
end

def isPalindrome_helper numls
  if numls == nil
    true
  elsif (numls.first == numls.last)
     isPalindrome_helper numls[1...numls.length-1] 
  else
    false
  end
end

#takes in a number and an array, returns the number split into array cells
#123 => [1,2,3]
def numTo_a(num, ls)
  if num == 0
    ls
  else
    ls.insert(0, num % 10)
    numTo_a(num / 10, ls)
  end
end

#What is the smallest positive number that is evenly divisible by all
#numbers from 1 to 20
def five
  i = 1
  begin
    i = i + 1
  end until (div_n(20, i) == true)
  return i
end

#looking at common factors, this is the minimum number of mods to see if a number is divisible by 1..10
def div_ten num
  div_n(10, num)
end

def div_n(n, num)
  for i in (n/2+1)..n
    if (num % i != 0)
      return false
    end
  end
  return true
end

#What is the difference between the sum of the squares and the square of the sums of 1..100
def six
  square_of_sum(100) - sum_of_squares(100)
end

def sum_of_squares n
  acc = 0
  for i in 1..n
    acc = acc + (i**2)
  end
  return acc
end

def square_of_sum n
  acc = 0
  for i in 1..n
    acc = acc + i
  end
  return acc**2
end

def find_nth_prime n
  count = 0
  iter = 1
  begin
    iter = iter + 1
    if isPrime? iter
      count = count + 1
    end
  end until count == n
  return iter
end

def find_nth_prime_b n
  (find_n_primes n).last
end

def find_n_primes n
  count = 0
  iter = 1
  acc = []
  begin
    iter = iter + 1
    if isPrime? iter
      acc.push(iter)
      count = count + 1
    end
  end until count == n
  return acc
end

def seven 
  find_nth_prime_b 10001
end 

#Find the greatest product of 5 consecutive digits in the 1000 digit number
def eight 
  max = 0
  number = 7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450

  a = numTo_a(number, [])  
  for i in 0..(a.length-1)-5
    acc = 1
    for j in 0..4
      acc = acc * a[i+j]
    end
    if acc > max
      max = acc
    end
  end
  return max
end

#Find the only pythagorean triplet {a,b,c} for which a + b + c = 1000
def nine
  acc = 1
  list_pythagorean.split(" ").map {|x| x.split('=')[1]}.each do |i| 
    acc = acc * i.to_i
  end
  return acc 
end

def list_pythagorean
  hash = Hash.new
  for b in 1..500
    for a in 1...b
      if is_a_square?(x=(a**2 + b**2))
        c = Math.sqrt(x).to_i
        hash[a+b+c] = "a=#{a} b=#{b} c=#{c}"  
      end
    end
  end
  return hash[1000] 
end

def is_a_square? n
  Math.sqrt(n).truncate.to_f == Math.sqrt(n)
end

#calculate the sum of all the primes below 2 million
def ten
  acc = 0
  (find_primes_below 2000000).each do |i|
    acc = acc + i
  end
  return acc 
end

def find_primes_below n
  iter = 1
  acc = []
  begin
    iter = iter + 1
    if isPrime? iter
      acc.push(iter)
    end
  end while iter < n
  return acc
end

#what is the greatest product of 4 adjacent numbers on the same straight line in the given 20x20 grid
def eleven
  max = 0
  matrix = read_file
  height = matrix.length
  width = matrix[0].length

  for i in 0..height
    for j in 0..width
      if (temp = max_fn(find_max_hor(matrix, i, j, 1), find_max_ver(matrix, i, j, 1), find_max_lower_dia(matrix, i, j, 1), find_max_upper_dia(matrix, i, j, 1))) > max
        max = temp
      end  
    end
  end
  return max 
end

def find_max_hor(matrix, x, y, count)
  if count > 4
    return 1
  end
  
  return safe_access(x, y, matrix) * find_max_hor(matrix, x+1, y, count+1)
end
  
def find_max_ver(matrix, x, y, count)
  if count > 4
    return 1
  end

  return safe_access(x, y, matrix) * find_max_ver(matrix, x, y+1, count+1)
end

def find_max_lower_dia(matrix, x, y, count)
  if count > 4
    return 1
  end

  return safe_access(x, y, matrix) * find_max_lower_dia(matrix, x+1, y+1, count+1)
end

#this one caused me great pain as I forgot to check for upper diagonals...
def find_max_upper_dia(matrix, x, y, count)
  if count > 4
    return 1
  end

  return safe_access(x, y, matrix) * find_max_upper_dia(matrix, x+1, y-1, count+1)
end

def max_fn(v, x, y, z)
  max = 0  

  if v > max
    max = v
  end

  if x > max
    max = x
  end   

  if y > max 
    max = y
  end
  
  if z > max
    max = z
  end

  return max
end

#safely access matrix (out of bounds access returns 0)
def safe_access(x, y, matrix)
  height = matrix.length
  width = matrix[0].length
  
  if (x >= width) || (x < 0) || (y >= height) || (y < 0)
    return 0
  end
  return matrix[y][x]
end

def read_file
  file = File.open("11.txt")
  matrix = []
  array_line =[]
  file.each {|line|
    array_line = line.gsub("\n"," ").split(" ")
    0.upto(array_line.length-1) do |i| 
      array_line[i] = array_line[i].to_i
    end
    matrix.push(array_line)
  }
  return matrix
end

#what is the value of the first triangle number to have over 500 divisors
def twelve
  iter = 1
  trinum_temp = 0
  begin
    factors = count_factors(trinum_temp = (trinum(iter)))
    iter = iter + 1

  end until factors > 200

  return trinum_temp
end

#first did recursion, then optimized slightly to iteration because needed speed
def trinum n
  temp = 0
  for i in 1..n
    temp = temp + i
  end
  return temp
end

#needed optimization to finish before 1 minutes threshold
def count_factors num
  count = 0
  if num == 1
    return 1
  end

  lim = Math.sqrt(num)
  for i in 1...lim
    if num % i == 0
      count = count + 1
    end
  end

  if is_a_square?(num)
    return (2*count) + 1
  end

  return 2*count
end

#Find the first ten digits of the sum of one-hundred 50-digit numbers
def thirteen
  x = read_file_13
  x = x.to_s
  x = x[0,10]

  return x.to_i
end

def read_file_13
  file = File.open("13.txt")
  acc = 0
  file.each {|line|
    acc = acc + line.to_i
  }
  return acc
end

#Fid the longest sequence using a starting number under one milion
#fun problem with memoizing all at first hack, getting used to using ruby for code
def fourteen
  max = 0
  index = 0
  for i in 1..1000000
    if ((temp = collatz(i)) > max)
      max = temp
      index = i
      puts "The max so far is i=#{index} producing a chain n=#{temp} long"
    end
  end
  return index
end

def collatz(n)
  @@collatz_hash = Hash.new
  return collatz_helper(n, 1)
end

def collatz_helper(n, count)
  if n == 1
    return count
  end

  if @@collatz_hash.has_key?(n)
    return @@collatz_hash[n]
  end

  if n.odd?
    return (@@collatz_hash[n] = collatz_helper(3*n + 1, count + 1))
  else
    return (@@collatz_hash[n] = collatz_helper(n/2, count + 1))
  end

end 

#Starting in the top left corner in a 20 by 20 grid, how many routes are there to the bottom right corner?
#this solves but it takes too long... Notice that the solution is just Choose(2n, n)
def fifteen 
  size_x = 10 
  size_y = 10
  row = []
  for i in 1..size_x
    row.push(0)
  end

  @@mat = []

  for i in 1..size_y
    @@mat.push(row.clone)
  end
  
  move(0,0)

  return @@mat[size_x-1][size_y-1]

end

def move(x, y)
  if done?(x, y)
    return 0
  end
  print_graph
  move_right(x,y)
  #move_up(x,y)
  move_down(x, y)
end

def move_right(x,y)
  if safe_mat?(x,y)
    mark(x,y+1)
    move(x, y+1)
  end
end

def done?(x, y)
  max_height = @@mat.length-1
  max_width = @@mat[max_height].length-1

  return ((x == max_height) && (y == max_width))
end

def move_up(x,y)
  if safe_mat?(x,y)
    mark(x-1,y)
    move(x-1, y)
  end
end

def move_down(x,y)
  if safe_mat?(x,y)
    mark(x+1,y)
    move(x+1, y)
  end
end

def print_graph
  @@mat.each {|row|
    print "#{row}\n"
  }
  print "\n"
  return nil
end

def mark(x, y)
 if (safe_mat?(x,y))
    @@mat[x][y] = @@mat[x][y]+1
  end
end

def safe_mat?(x, y)
  height = @@mat.size
  width = @@mat[0].size
  return (((x < width) && (x >= 0) && (y < height) && (y >= 0)) && (@@mat[x][y] >= 0))
end

#What is the sum of the digits of the number 2^1000?
def sixteen
  sum_of_digits 2**1000
end

def sum_of_digits n
  if n==0
    return 0
  end
  
  return (n%10) + sum_of_digits(n / 10) 
end

#How many letters would be needed to write all the numbers in words from 1 to 1000?
def seventeen
  acc = 0
  for i in 1..1000
    acc = acc + count_letters(read_numbers(i))
  end

  return acc
end

#given a string, will count the number of letters not '-' or ' ' in it
def count_letters str
  count = 0
  str.chars{|char|
    if (char != ' ' && char != '-')
      count = count + 1
    end
  }
  return count
end

#given a number 1..1000, will return a string of the "spoken" number
def read_numbers n
  if(n == 0)
    return ""
  end
  
  hash = number_to_words_hash
  num_str = n.to_s
  len = num_str.length
  placeholder = " " 
  
  if (len == 4)
    placeholder = " thousand " 
  end

  if (len == 3)
    placeholder = " hundred "
    if (n % 100 != 0)
      placeholder = placeholder + "and "
    end
  end

  if (len == 2)
    if hash.has_key?(n)
      return hash[n]      
    end
    return hash[(num_str[0].to_s+"0").to_i] + "-" + hash[num_str[1].to_i]

  end
   
  return (hash[num_str[0].to_i] + placeholder + read_numbers(num_str[1, len].to_i)).rstrip 
end

#creates a map between certain numbers and their english word
def number_to_words_hash
  num_hash = Hash.new
  num_hash[0] = "zero"
  num_hash[1] = "one"
  num_hash[2] = "two"
  num_hash[3] = "three"
  num_hash[4] = "four"
  num_hash[5] = "five"
  num_hash[6] = "six"
  num_hash[7] = "seven"
  num_hash[8] = "eight"
  num_hash[9] = "nine"
  num_hash[10] = "ten"
  num_hash[11] = "eleven"
  num_hash[12] = "twelve"
  num_hash[13] = "thirteen"
  num_hash[14] = "fourteen"
  num_hash[15] = "fifteen"
  num_hash[16] = "sixteen"
  num_hash[17] = "seventeen"
  num_hash[18] = "eighteen"
  num_hash[19] = "nineteen"
  num_hash[20] = "twenty"
  num_hash[30] = "thirty"
  num_hash[40] = "forty"
  num_hash[50] = "fifty"
  num_hash[60] = "sixty"
  num_hash[70] = "seventy"
  num_hash[80] = "eighty"
  num_hash[90] = "ninety"
  
  return num_hash
end

#Find the maximum sum travelling from the top of the triangle to the base.
#Bottom up dynamic programming to find the maximum path in the tree, I tried top-down but it was more complicated and not worth the time.
def eighteen
  @@triangle = read_file_18
  @@lookup_table = initTable #the dp table  
  maxpath(0,0) 
  print_table 
  return @@lookup_table[0][0]
end

def initTable
  table = []
  for i in 1..@@triangle.length
    table.push(Array.new(i, 0)) 
  end
  return table
end

def maxpath(row, col)
  puts "maxpath(#{row},#{col})"
  print_table
  if !(safe_tri_access?(row, col))  
    return 0
  else
      @@lookup_table[row][col] = @@triangle[row][col] + max_val(maxpath(row+1,col+1), maxpath(row+1, col)) 
  end 
  return @@lookup_table[row][col]
end

def print_triangle
  for i in 0..@@triangle.length-1
    for j in 0..@@triangle[i].length-1
      print @@triangle[i][j].to_s+" "
    end
    print "\n"
  end
end

def print_table
  for i in 0..@@lookup_table.length-1
    for j in 0..@@lookup_table[i].length-1
      print @@lookup_table[i][j].to_s+" "
     end
     print "\n"
  end 
end

def max_val(x, y)
  if x > y
    return x
  end
    return y
end

def safe_tri_access?(row, col)

  return ((row >= 0 && row < @@triangle.length) && (col >= 0 && col < @@triangle[row].length))
end

def read_file_18
  arr = []
  file = File.open("18.txt")
  file.each{ |line|
    arr.push(line.split(" ").map!{|x| x.to_i})
  }
  return arr
end

#How many Sundays fell on the first of the month during the twentieth century?
#This is an example of a problem that can be solved in ruby in < 15 lines but would take much longer in other 
#languages that do not have such a large and robust standard library (.sunday? :-) )
require 'date'
def nineteen
  count = 0
  for year in 1901..2000
    for month in 1..12 
      if (Date.new(year, month, 1)).sunday?
        count = count + 1
      end
    end
  end
  return count
end

#Find the sum of digits in 100!
def twenty
  sum_of_digits(factorial(100))
end

#Another "cute" ruby trick, instead of writing out the factorial as a recursive 
#function, just "inject" the * operator into the sequence!
def factorial n
  if n == 0
    return 1
  end
  return (1..n).inject(:*)
end
