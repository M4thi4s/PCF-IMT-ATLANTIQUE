if [ ! -d "out" ]; then
  mkdir -p out/production/PCF-IMT-ATLANTIQUE;
fi
sbt clean compile;

echo "1 + 2" > pcf/main.pcf;

sbt "run pcf/main.pcf";
wat2wasm pcf/main.wat -o pcf/main.wasm;
wasm-interp pcf/main.wasm --run-all-exports;
rm pcf/main.pcf pcf/main.wat pcf/main.wasm;
