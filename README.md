# Gamer Language
A stupid esoteric programming language where you program the same way a gamer talks lmaoo.

Imagine yourself in a Twitch chat but you're also coding and for a second you forget that they're different things.

It's also weird and difficult to program in but whatever it's kinda fun and it comes with a compiler and executor yay.

## Documentation and Examples
[Check out the documentation pls.](DOCUMENTATION.md)

## Compiling and Running with the Gamer Language CLI
You'll need to install the epic Gamer Language Command Line Interface (CLI) to compile and run gamer language code. Dw it's easy.

### macOS
With macOS's cracked unix system, it's easy to install the entire command line stuff with only a few terminal commands, and keep it updated with only one command.

1. Make sure you have [Homebrew](https://brew.sh) installed (if you're a true gamer you should already have it installed).
2. Open up your terminal and `cd` to a nice folder where you want to put the gamer language compiler files.

3. Run the following command to download all the gamer files.
```
git clone https://github.com/dilanx/GamerLanguage.git
```
4. Switch into the CLI folder like this.
```
cd GamerLanguage/cli
```
5. Set everything else up with this.
```
sh update.sh
```

Now you're done! You don't have be in the CLI folder to run anything btw.

You'll be able to run the `gamer` command in your terminal from anywhere.

Try running this to make sure.
```
gamer version
```

Run a Gamer Language file using `gamer pog <example.gl>`.

Oh and keep your client up to date by updating your gamer with `gamer update`.

### Windows
Due to the anti-cracked nature of the Windows operating system (although ok ig for gaming it's good lmao), Windows can't handle the absolutely insanely amazing Gamer Language compiler by default. You'll have to install a few things that are normally already included with macOS. If you're a developer, you probably have a bunch of the following stuff installed already. If not, there's no harm in installing them (plus you get to run Gamer Language yayy).

1. You'll need to install [Git](https://git-scm.com/) for Windows.
2. You'll also need to install [Ruby](https://www.ruby-lang.org/en/) using [RubyInstaller](https://rubyinstaller.org/) for Windows.
3. If your command prompt is open (which it might be from installing Ruby), close out of it and reopen it.
4. Run the following command to download all the gamer files.
```
git clone https://github.com/dilanx/GamerLanguage.git
```
5. Switch into the CLI folder like this.
```
cd GamerLanguage\cli
```
6. Set everything else up by typing this into your command prompt.
```
update.sh
```

Yay! Everything should be set up now. On macOS, you can use the `gamer` command from anywhere. However, on Windows, you'll need to be in the 'cli' folder. If you closed out of and reopened your command prompt in step 3, Gamer Language should have downloaded to your default user folder, so you'll be able to use the `GamerLanguage\cli\gamer` command as long as you're in that default directory (which should contain the 'GamerLanguage', which should contain the 'cli' folder, hence the two slashes).

To make sure everything works, close out of your command prompt and reopen it. Then do the following.
```
GamerLanguage\cli\gamer version
```

When you run it for the first time, it might ask you what program to use to open it. Ruby should be an option, so make sure to pick that. It should only ask you about that once, if at all. Then you'll be able to use the command line to run Gamer Language files with `GamerLanguage\cli\gamer pog <file-name.gl>`.

Although it says `gamer update` is a valid command, unfortunately Windows users don't get access to that luxury (not my fault sorryyyy). Here's how you check for updates and update Gamer Language.
```
cd <the GamerLanguage cli directory>
update.sh
```

TIP:

If you're current working directory (directory set using `cd`) is that 'cli' folder, then you'd just type `gamer` instead of the backslash stuff.


## Editing with Syntax Coloring
Gamer Language has some syntax coloring in some text editors. It's not really necessary but you might want it.

#### BBEdit (macOS)
If you use [BBEdit](https://www.barebones.com/products/bbedit/) for macOS, you can install the Gamer Language Codeless Language Module (CLM).

1. Download the [Gamer Language CLM](https://github.com/dilanx/GamerLanguage/blob/main/mac/gamerlanguage-bbedit.plist) file.
2. Move it into `~/Library/Application Support/BBEdit/Language Modules/`.
3. Restart BBEdit.

Now whenever you open a `.gl` file, it should syntax color for you.

#### Notepad++ (Windows)
If you use [Notepad++](https://notepad-plus-plus.org/) for Windows, you can install the Gamer Language User Defined Language (UDL).

1. Download the [Gamer Language UDL](https://github.com/dilanx/GamerLanguage/blob/main/win/gamerlanguage-notepadplusplus.xml) file.
2. Move it into `%AppData%\Notepad++\userDefineLangs`.
3. Restart Notepad++.

Now whenever you open a `.gl` file, it should syntax color for you (I think - if it doesn't you can select it manually from the language list).
