let problem = () => {
  let explode = s => List.init(String.length(s), String.get(s));
  let two = Big_int.big_int_of_int(2);
  Big_int.power_big_int_positive_int(two, 1000)
  |> Big_int.string_of_big_int
  |> explode
  |> List.map(ch => Char.code(ch) - Char.code('0'))
  |> List.fold_left((+), 0)
  |> string_of_int;
};
