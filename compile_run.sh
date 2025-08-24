#compile
javac -d Game/bin $(find Game/src -name "*.java") --module-path Game/bin

#run
java --module-path Game/bin -m Game/main.Main