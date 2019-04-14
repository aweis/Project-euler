let problem = () => {
  let explode = s => List.init(String.length(s), String.get(s));
  let fileString = Util.readFile("text/Problem8.txt");
  let listRepresentation = explode(fileString) |> List.filter(c => c != '\n');
  let filteredString =
    String.concat(
      "",
      listRepresentation |> List.map(c => String.make(1, c)),
    );
  let rec genSubstrings = (startIndex, length, str, acc) =>
    if (startIndex + length > String.length(str)) {
      acc;
    } else {
      let substring = String.sub(str, startIndex, length);
      genSubstrings(startIndex + 1, length, str, acc @ [substring]);
    };
  let substrings = genSubstrings(0, 13, filteredString, []);
  let products =
    substrings
    |> List.map(str => {
         let charList = explode(str);
         let intList =
           charList |> List.map(ch => Char.code(ch) - Char.code('0'));
         intList;
       })
    |> List.map(subList => subList |> List.fold_left(( * ), 1));
  let max = products |> List.fold_left(max, 0);
  string_of_int(max);
};
