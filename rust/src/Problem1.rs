fn main() {
    println!("{:?}", find_sum(10));
    println!("{:?}", find_sum(1000));
}

fn find_sum(num: u32) -> u32 {
    let mut sum = 0;
    for x in 1..num {
        if (x % 3 == 0) || (x % 5 == 0) {
            sum += x;
        }
    }
    return sum;
}
