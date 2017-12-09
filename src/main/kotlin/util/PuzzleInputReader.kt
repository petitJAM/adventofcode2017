package util

import java.io.File
import java.util.*

class PuzzleInputReader(private val fileName: String) {

    fun readFile(): String {
        val sb = StringBuilder()

        val classLoader = PuzzleInputReader::class.java.classLoader
        val file = File(classLoader.getResource(fileName).file)

        Scanner(file).use {
            while (it.hasNextLine()) {
                sb.append(it.nextLine()).append("\n")
            }
            it.close()
        }

        return sb.toString()
    }
}