# Gamer Language Documentation
Hello and welcome lovely humans to the documentation for the best language in the world. Gamer language has one several non-existent awards over the years and we hope to continue doing so.

Before you get started, you'll want to make sure you can actually run what you code by setting up your [compiler](https://github.com/dilanx/GamerLanguage#compiling-and-running-with-the-gamer-language-cli) and [editor](https://github.com/dilanx/GamerLanguage#compiling-and-running-with-the-gamer-language-cli) (editor doesn't have to be set up though you can just use a regular text editor if you want).

Here's a table of contents so you can get around faster.

## Table of Contents

1. [Creating and running a file](#Creating-and-running-a-file)
2. [Getting started](#Getting-started)
3. [Variables](#Variables)
4. [Simple expressions](#Simple-expressions)
5. [Conditionals](#Conditionals)
6. [Loops](#Loops)
7. [Functions](#Functions)
8. [Advanced expressions](#Advanced-expressions)
9. [I/O](#IO)
10. [Variable manipulation](#Variable-manipulation)
11. [Miscellaneous](#Miscellaneous)
12. [Examples](#Examples)
    * [Take 2 numbers from chat and drop their sum](#Take-2-numbers-from-chat-and-drop-their-sum)

## Creating and running a file
Create a normal text file with the extension `.gl`. 'gl' not only stands for Gamer Language but also for good luck because you're probably gonna need it when coding in this language lmao.

To run your completed program, making sure you have the [command line stuff](https://github.com/dilanx/GamerLanguage#compiling-and-running-with-the-gamer-language-cli) installed, then run this.
```
gamer pog <example.gl>
```

Anyway, now to the instructions.

## Getting started
Let's start with a super simple program that prints "Hello, world!" into the console. Check it out

```
server lobby

  drop "Hello, world!" in chat
  
dc
```

Super easy. `server`s are like [functions](#Functions), you join them and then you disconnect with `dc` at the end. Your program starts in the `lobby` server. You **cannot** have normal code in the global scope, meaning they have to be in functions. If you don't plan on using multiple functions, just put all of your code in the lobby. Then you can [print](#IO) a message by dropping it in the chat, where the chat is the console.

A few things to note about Gamer Language:
* Indentation doesn't matter nor do blank lines.
* Multiple spaces in between words on the same line (unless in a string) DO matter! Don't do that!
* A server cannot be named the same as a variable is.

## Variables
Assign variables like this.

```
<variable-name> mains <expression>
```

The keyword here is `mains`. The left side of the word is the variable name, and the right side is a [simple expression](#Simple-expressions) or [advanced expression](#Advanced-expressions).

You can [manipulate variables](#Variable-manipulation) and change their values, but we'll get into that later.

## Simple expressions
An expression is basically a set of things that equal one value. These include:
* Strings *`"hello!"`*
  * Strings are anything surrounded in "double quotes".
* Numbers *`1`, `-5`, `4.20`, `6.9`*
  * Numbers include any whole number, decimal number, negative number, etc.
* Booleans *`W`, `F`*
  * Booleans have been gamerified. Popping off and taking a `W` is true, while taking a fat `L` is false.
* Variables *`varname`*

## Conditionals
Run some code on a condition using the `lmao` word with a `?` at the end lol. Condition phrases are dependent on the type.

The basic format looks like this.

```
lmao <variable-name> <comparison-keywords...> <simple-expression>?

  <if true, code here runs>
  
gg

<continues...>
```
DON'T FORGET THE `?` AT THE END OF THE STATEMENT LINE AND THE `gg` AT THE END OF THE BLOCK.

The left side of the comparison keywords must always be a [variable](#Variables) name, but the right side can be any [simple expression](#Simple-Expression).

Here are the comparison keyword options.
* Comparing strings
  * `chats` - compares a string in a variable on the left to a string either in a variable or in double quotes on the right.
* Comparing numbers
  * `kdr stays` - checks if the number in the variable on the left is equal to the number either in a variable or just standalone on the right.
  * `kdr cracked` - same as above but for >.
  * `kdr jank` - same as above but for <.
* Comparing booleans
  * `takes` - checks if the boolean in the variable on the left is equal to the boolean either in a variable or just standalone (`W`/`L`) on the right.
* NOT
  * `anti` - prefix any of the above with this to take the opposite (for example, `anti kdr cracked` would take the opposite of >, which is <=).

## Loops
Loops are pretty necessary when programming, so of course I didn't skip out on make those work.

```
grinding while <condition>?

  <code here runs over and over again until condition takes L>
  
gg
```

The [condition](#Conditionals) is the same stuff you can put between the 'lmao' and the '?' in the if statement.

If you ever want to break out of the loop, all you've got to use is the `poggers` keyword. Check out this example if you want.

## Functions
So if you're coding in this amazing language, you've probably been using `server lobby` and `dc` to run the code. That's a server (function), but you can even make more servers. They have to be in the global scope though, so you can't put servers in servers.

```
server <name>

  <code>
  
dc
```

Don't forget to disconnect with `dc` at the end of each server.

Sure, this can be useful for organizing code, but what if you want to take arguments into one of these and/or return something? Easy (literally lol you'll see).

```
server <server-name>: <arg1> <arg2> <arg3> <and so on...>

  <code>
  
dc
```

When your server is called with those arguments (there'll be a problem if the caller doesn't give you a value for every argument), the values will be in [variables](#Variables) with what you named 'arg1', 'arg2', etc.

You can return out of a server using the `easy` keyword lol. You can follow it with a [simple expression](#Simple-expressions) to return a value like `easy <expression>` or you can just call `easy` to quit out of the server.

Check out [Advanced-Expressions](#Advanced-expressions) to see how to call these servers and get the return value.

## Advanced expressions
Advanced expressions can only be used in [variable](#Variables) assignment right now, and this is the only way to call servers.

Here's what an advanced expression looks like.

```
<server-name> as <arg1-simple-expression> <arg2-simple-expression> <arg3-simple-expression> <and so on...>
```

You'll have to use variable assignment to call it though.

```
<variable-name> mains <what i wrote in the code block above>
```

So, if you want to call a server named 'pogchampepicgamer' with two arguments, "hello world" and 2, and store it in a variable called 'test', you can do something like this.

```
test mains pogchampepicgamer as "hello world" 2
```

Of course, if 'pogchampepicgamer' doesn't return anything with `easy`, then 'test' will store nothing (but you still have to call servers this way). But, let's say it returned the value '5' or something with `easy 5`, that value will be stored in 'test'.

## I/O
Currently, you can read stuff from and print stuff into the chat (console).

To print:

```
drop <simple-expression> in chat
```

Don't forget that you'll need a [simple expression](#Simple-expressions) to drop in the chat.


To read:
```
read <read-type> from chat into <variable-name>
```

Reading is a bit different. You'll need to specify what you're reading. Here are the read type options.
* `stats` - read a number
* `msg` - read a string

This is also a scenario where you don't use `mains` to set a [variable](#Variables), and instead set it like shown above.

## Variable manipulation
You can change the values of variables.

* Modifying numbers
  * `<variable-name> good` - increases the number in the variable by one (and stores it back in the variable)
  * `<variable-name> bad` - decreases the number in the variable by one (and stores it back in the variable)
  * `<variable-name-1> mains <variable-name-2> but <simple-expression>` - add the number stored in the variable-name-2 [variable](#Variables) with the number produced by the [simple expression](#Simple-expressions) and store it in the variable-name-1 variable. Both variable names can be the same if you want to add another number with a variable and store it in the same variable.

TIP: You can modify the number of Os in `good` and the number of As in `bad` to change the number added or subtracted. The number is increased/decreased by one for *every extra vowel* in each. For example `<var> gooood` adds 3 (two extra Os to the two already there), and `<var> baaaad` subtracts 4 (three extra As to the one already there). You might want to do something like `<var> mains <var> but 25` or something for larger numbers though lmao.

## Miscellaneous 
You can exit out of your program by rage quitting with `rage`.

## Examples
Here are some fun examples with Gamer Language. I'll add more later.

### Take 2 numbers from chat and drop their sum
This program asks whether you want to add or quit, and will take two numbers and drop their sum. It'll then ask you if you want to add or quit and will keep going until you quit. You get the idea.

Here, I used an infinite loop to keep asking and call a separate function to get the sum.

```
server lobby

    infiniteloop mains L
    
    grinding while infiniteloop takes L?
        
        drop "add or quit?" in chat
        
        read msg from chat into option
        
        lmao option chats "add"?
        
            read stats from chat into num1
            read stats from chat into num2
            
            sum mains add as num1 num2
            
            drop sum in chat
            drop " " in chat
            
        gg
        
        lmao option chats "quit"?
        
            poggers
        
        gg
            
            
    gg
    
    drop "good bye" in chat
    
dc

server add: x y

    sum mains x but y
    
    easy sum
    
dc
```
