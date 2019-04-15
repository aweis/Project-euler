Console__ObjectPrinter.setMaxLength(5000);
Console__ObjectPrinter.setPrintWidth(5000);

let problem = {
  let rec col = (table, currentTerm) =>
    if (currentTerm == 1) {
      1;
    } else if (Hashtbl.mem(table, currentTerm)) {
      Hashtbl.find(table, currentTerm);
    } else if (currentTerm mod 2 == 1) {
      let nextTerm = currentTerm * 3 + 1;
      let value = 1 + col(table, nextTerm);
      Hashtbl.add(table, currentTerm, value);
      value;
    } else {
      let nextTerm = currentTerm / 2;
      let value = 1 + col(table, nextTerm);
      Hashtbl.add(table, currentTerm, value);
      value;
    };
  let _printHashTable = hash =>
    Hashtbl.iter((x, y) => Printf.printf("%d -> %d\n", x, y), hash);

  () => {
    let table = Hashtbl.create(1_000_000);
    let break = ref(false);

    let count = ref(1);

    while (! break^) {
      if (count^ > 1_000_000) {
        break := true;
      } else {
        ignore(col(table, count^));
      };
      count := count^ + 1;
    };

    let (key, _value) =
      Hashtbl.fold(
        (key, value, (k, v)) => v > value ? (k, v) : (key, value),
        table,
        (0, 0),
      );
    string_of_int(key);
  };
};
