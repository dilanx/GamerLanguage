#!/bin/bash

echo "Checking for remote updates..."
git pull
echo " "

echo "Removing old garbage..."
rm /usr/local/bin/gamer
rm gamer
rm -r compile

echo "Recompiling the compiler for gamer language..."
javac ../compiler/src/com/dilanxd/gamerlanguage/compiler/*.java -d compile

echo "Refreshing epic gamer command..."
cp gamer.rb gamer2.rb
chmod +x gamer2.rb
mv gamer2.rb gamer
ln -s "$(pwd)/gamer" /usr/local/bin/gamer

echo "Everything's updated now (you're welcome)."