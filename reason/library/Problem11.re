type direction =
  | Up
  | Down
  | Left
  | Right
  | Backslash
  | Slash;

let problem = {
  let processFile = () => {
    let file = Util.readFile("text/Problem11.txt");
    let lines = file |> String.trim |> String.split_on_char('\n');
    let cells =
      lines
      |> List.map(row =>
           row |> String.split_on_char(' ') |> List.map(int_of_string)
         );
    cells;
  };

  let processCells = (cells, table) =>
    cells
    |> List.iteri((rowIndex, row) =>
         row
         |> List.iteri((colIndex, value) => table[rowIndex][colIndex] = value)
       );

  let rec scan = (direction, x, y, table, count, product) =>
    if (count == 0) {
      product;
    } else if (x < 0
               || x >= Array.length(table)
               || y < 0
               || y >= Array.length(table[0])) {
      (-1);
    } else {
      let currentValue = table[x][y];
      switch (direction) {
      | Up => scan(Up, x - 1, y, table, count - 1, product * currentValue)
      | Down => scan(Down, x + 1, y, table, count - 1, product * currentValue)
      | Left => scan(Left, x, y - 1, table, count - 1, product * currentValue)
      | Right =>
        scan(Right, x, y + 1, table, count - 1, product * currentValue)
      | Backslash =>
        scan(
          Backslash,
          x + 1,
          y + 1,
          table,
          count - 1,
          product * currentValue,
        )
      | Slash =>
        scan(Slash, x - 1, y + 1, table, count - 1, product * currentValue)
      };
    };

  () => {
    let cells = processFile();
    let numRows = cells |> List.length;
    let numCols = cells |> List.hd |> List.length;
    let table = Array.make_matrix(numRows, numCols, 0);
    processCells(cells, table);
    let answerTable = Array.make_matrix(numRows, numCols, -1);
    let numAdjacent = 4;
    for (i in 0 to numRows - 1) {
      for (j in 0 to numCols - 1) {
        answerTable[i][j] =
          max(
            max(
              max(
                max(
                  max(
                    scan(Right, i, j, table, numAdjacent, 1),
                    scan(Left, i, j, table, numAdjacent, 1),
                  ),
                  scan(Up, i, j, table, numAdjacent, 1),
                ),
                scan(Down, i, j, table, numAdjacent, 1),
              ),
              scan(Slash, i, j, table, numAdjacent, 1),
            ),
            scan(Backslash, i, j, table, numAdjacent, 1),
          );
      };
    };
    answerTable
    |> Array.to_list
    |> Array.concat
    |> Array.fold_left(max, 0)
    |> string_of_int;
  };
};
