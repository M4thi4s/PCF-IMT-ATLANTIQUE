if [ ! -d "out" ]; then
  mkdir -p out/production/PCF-IMT-ATLANTIQUE;
fi
sbt clean compile;

echo "let i = (fun x -> (x + 1)) in (1 : 2 : 3 : [])" > pcf/main.pcf;
#echo "let i = (fun x -> (x + 1)) in [1, 2, 3]" > pcf/main.pcf;
#echo "(2 : 3 : [])" > pcf/main.pcf;

sbt "run pcf/main.pcf";
wat2wasm pcf/main.wat -o pcf/main.wasm;
wasm-interp pcf/main.wasm --run-all-exports;
rm pcf/main.pcf pcf/main.wat pcf/main.wasm;
