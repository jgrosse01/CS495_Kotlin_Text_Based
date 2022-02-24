package main

import kotlin.system.exitProcess

/**
 * A basic guessing game.
 *
 * This kotlin file contains all the code for a rudimentary guess a number game.
 * This is considering that I started learning Kotlin all of 20 minutes ago.
 *
 * @param args string of arguments to pass in, list position 0 is a debug tool (true/false)
 */
fun main(args: Array<String>) {
    // idea for guess a number game is from conversation with Josiah, code is all mine (did not brainstorm or
    // collaborate with anyone before or during the process to write the code)

    init@ while (true) {
        // Some credit to IntelliJ for its suggestions! (Kotlin is cool)
        // THIS PROGRAM EXCEEDS THE MINIMUM REQUIREMENT!!!!
        // IT IS MORE THAN JUST HELLO WORLD!!!
        // And being that "as little code as possible" is the supposed spirit of the language,
        // I think I did great for the task! It did take me a while to figure things out.

        // Begin Program
        println("Welcome to Guess-A-Number!")

        // tracker variable for number of correct guesses in a row
        var numCorrect = 0

        // loop with flag for continue statements
        loop@ while (true) {
            // just printing things
            println("Guess a number between one and ten! If you get it right you get a prize!")
            println("And if you guess 10 in a row, you get an extra special prize!!! Enter -1 to exit.")

            // initialize userInput to an integer that requires a safe call to assign
            var userInput: Int
            // initialize number to an integer without safe call requirements

            // temp variable to read a line in as a string
            val readIn = readLine()

            // attempt to cast the read line to an int. if it fails then the value is either string or null so print
            // the invalid input message and continue to the next step of the priorly marked loop
            try {
                // null-asserted meaning this cannot be null. removes need for safe call (fixed in class)
                userInput = readIn!!.toInt()
            } catch (e: Exception) {
                println("Invalid Input. Input an INTEGER between ONE and TEN. (or -1 to exit).")
                continue@loop
            }

            if (userInput < -1 || userInput > 10 || userInput == 0) {
                println("Invalid Input. Input an INTEGER between ONE and TEN. (or -1 to exit).")
                continue@loop
            }

            // assignment statement for number
            // if there is nothing in args it is random
            // if there is a value in args the first value should be a boolean so check to see if it is then assign
            // 1 if true and random if false
            val number = if (args.isEmpty()) {
                (0..10).random()
            } else {
                if (args[0].toBoolean()) {
                    1
                } else {
                    (0..10).random()
                }
            }

            // switch statement
            // if it equals the number move into a sub block
            // if it is -1 then exit
            // if it is anything else then print the wrong guess statement and reset the correct answer counter
            when (userInput) {

                // if input is -1 then exit
                -1 -> {
                    exitProcess(0)
                }

                number -> {
                    // if the value is the number
                    // and the streak is currently at 9 (10 values from 0)
                    if (numCorrect == 9) {
                        // give super secret prize
                        println("You found the super seeeeecret prize!! ")
                        println(
                            "         .--.             .---.\n" +
                                    "        /:.  '.         .' ..  '._.---.\n" +
                                    "       /:::-.  \\.-\"\"\"-;` .-:::.     .::\\\n" +
                                    "      /::'|  `\\/  _ _  \\'   `\\:'   ::::|\n" +
                                    "  __.'    |   /  (o|o)  \\     `'.   ':/\n" +
                                    " /    .:. /   |   ___   |        '---'\n" +
                                    "|    ::::'   /:  (._.) .:\\\n" +
                                    "\\    .='    |:'        :::|\n" +
                                    " `\"\"`       \\     .-.   ':/\n" +
                                    "             '---`|I|`---'\n" +
                                    "                  '-'"
                        )
                        // Credit to asciiart.eu
                        println("Here's an ASCII art of a dog!")

                        // loop to check if the user wants to play again
                        playAgain@ while (true) {
                            // print question
                            println("Would you like to play again? (Y/N)")
                            // switch to check cases
                            when (readLine()?.lowercase()) {
                                // yes answers continue to the top level loop after printing lines to make space
                                // no answers exit the process
                                "y" -> {
                                    printLines(18)
                                    continue@init
                                }
                                "n" -> {exitProcess(0)}
                                // else ask the user to input a valid input and repeat the loop we are in
                                else -> {
                                    println("Please input a literal \"Y\" or \"N\".")
                                    continue@playAgain
                                }
                            }
                        }

                    // if it isn't the 10th correct answer, then just print that the answer was correct and how many
                    } else {
                        println("You guessed right! That's ${++numCorrect} in a row!")
                    }

                }

                // if any other input then it's a wrong guess and numCorrect should be set to 0
                else -> {
                    println("You guessed wrong! Try again!")
                    numCorrect = 0
                }
            }
        }
    }
}


/**
 * Method to print a specified number of lines
 *
 * @param numLines the number of lines to print to the console (default 10)
 */
fun printLines(numLines : Int = 10) {
    for (i in 1..numLines) {
        println()
    }
}

