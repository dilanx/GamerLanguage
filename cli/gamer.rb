#!/usr/bin/env ruby

if ARGV.length == 1
	system("java -cp compile com.dilanxd.gamerlanguage.compiler.GamerLanguage " + ARGV[0])
else
	puts "not a pogger number of arguments my guy."
end