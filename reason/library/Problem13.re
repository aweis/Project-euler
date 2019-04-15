let problem = {
  let file = Util.readFile("text/Problem13.txt");
  let lines =
    file
    |> String.split_on_char('\n')
    |> List.filter(x => String.length(x) > 0);
  let sum =
    lines
    |> List.map(Big_int.big_int_of_string)
    |> List.fold_left(Big_int.add_big_int, Big_int.zero_big_int)
    |> Big_int.string_of_big_int;
  () => String.sub(sum, 0, 10);
};
