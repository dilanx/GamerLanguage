#!/usr/bin/env ruby

$VERSION = "0.0.4"

if ARGV.length == 1
	
	Dir.chdir(__dir__) do

		if ARGV[0] == "update"
		
			system("chmod +x update.sh")
			system("./update.sh")
			return
			
		elsif ARGV[0] == "version"
		
			puts " "
			puts "Gamer Language #$VERSION"
			puts "Command Line Interface"
			puts "Dilan N - dilanxd.com"
			puts " "
			return
			
		end
		
	end
	
end


if ARGV.length == 2
	if ARGV[0] == "pog"
	
		$filepog = File.expand_path(ARGV[1])
		Dir.chdir(__dir__) do
			system("java -cp compile com.dilanxd.gamerlanguage.compiler.GamerLanguage \"#$filepog\"")
			return
		end
		
	end
end

puts "gamer poggers command line yooo"
puts " "
puts "$ gamer pog <file-name.gl> - execute a gamer language file"
puts "$ gamer update - check for gamer language updates"
puts "$ gamer version - view gamer information"
