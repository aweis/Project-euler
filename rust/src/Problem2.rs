fn main() {
    fib();
}

fn fib() {
    let mut first: u32 = 1;
    let mut second: u32 = 2;
    let mut sum = first + second;
    let mut sum_of_evens = sum;
    while sum < 4_000_000 {
        sum = first + second;
        if sum % 2 == 0 {
            sum_of_evens += sum;
        }
        first = second;
        second = sum;
    }

    println!("{}", sum_of_evens);
}
