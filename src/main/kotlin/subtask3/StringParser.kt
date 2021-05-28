package subtask3

import java.lang.StringBuilder
import java.util.*

class StringParser {

    fun getResult(inputString: String): Array<String> {
        val brackets = mapOf('(' to ')', '[' to ']', '<' to '>')
        val array = arrayListOf<String>()
        for (i in inputString.indices) {
            if (brackets.containsKey(inputString[i])) {
                val mainBracket = inputString[i]
                var counterOfTheSame = 0
                val stringBuilder = StringBuilder()
                for (j in i + 1 until inputString.length) {
                    if (inputString[j] == brackets[mainBracket]) {
                        if (counterOfTheSame == 0) {
                            array.add(stringBuilder.toString())
                            break
                        }
                        else {
                            stringBuilder.append(inputString[j])
                            counterOfTheSame--
                        }
                    } else {
                        stringBuilder.append(inputString[j])
                        if (inputString[j] == mainBracket)
                            counterOfTheSame++
                    }
                }
            }
        }
        return array.toTypedArray()
    }
}
