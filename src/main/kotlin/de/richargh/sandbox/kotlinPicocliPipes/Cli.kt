package de.richargh.sandbox.kotlinPicocliPipes

import picocli.CommandLine.*
import java.io.IOException
import java.io.InputStream
import java.io.PrintStream
import java.util.*
import java.util.concurrent.Callable

@Command(
        name = "Cli",
        description = ["generates cc.JSON from source code"])
class Cli(private val input: InputStream, private val output: PrintStream): Callable<Void> {

    @Option(names = ["-h", "--help"], usageHelp = true, description = ["displays this help and exits"])
    private var help = false

    @Throws(IOException::class)
    override fun call(): Void? {
        output.println("Supppp")

        val sc = Scanner(input)
        output.println("Passed in was:")
        while (sc.hasNextLine()) output.println(sc.nextLine())

        return null
    }
}

fun main(args: Array<String>) {
    mainWithInOut(System.`in`, System.out, args)
}

fun mainWithInOut(input: InputStream, output: PrintStream, args: Array<String>) {
    call(Cli(input, output), output, *args)
}