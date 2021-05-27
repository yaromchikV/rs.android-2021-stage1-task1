package subtask3

import java.util.*

class StringParser {

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        val list: MutableList<String> = mutableListOf()
        val stack = ArrayList<Char>()
        for (i in inputString.indices) {
            if (inputString[i] == '[' || inputString[i] == '<' || inputString[i] == '(') {
                var tempString = ""
                for (j in i until inputString.length) {
                    if (inputString[j] != '[' && inputString[j] != '<' && inputString[j] != '(' && stack.isEmpty()) {
                        continue
                    } else if (inputString[j] == '[' || inputString[j] == '<' || inputString[j] == '(') {
                        if (i != j)
                            tempString += inputString[j]
                        stack.add(inputString[j])
                    } else if (stack.contains('[') && inputString[j] == ']'
                        || stack.contains('<') && inputString[j] == '>'
                        || stack.contains('(') && inputString[j] == ')') {
                        if (stack.contains(inputString[i]))
                            list.add(tempString)
                        when {
                            inputString[j] == ']' -> stack.remove('[')
                            inputString[j] == '>' -> stack.remove('<')
                            inputString[j] == ')' -> stack.remove('(')
                        }
                        if (stack.isEmpty()) {
                            break
                        }
                        tempString += inputString[j]
                    } else {
                        tempString += inputString[j]
                    }
                }
            }
        }
        return list.toTypedArray()

        /*val list: MutableList<String> = mutableListOf()
        var stack = ArrayDeque<Char>()
        var tempString: String = ""
        for (i in inputString.indices) {
            if (inputString[i] == '[' || inputString[i] == '<' || inputString[i] == '(') {
                stack.push(inputString[i])
            } else if (inputString[i] == ']' && stack.peek() == '['
                || inputString[i] == '>' && stack.peek() == '<'
                || inputString[i] == ')' && stack.peek() == '(') {
                list.add(tempString)
                tempString = ""
                stack.pop()
            }
            else if (!stack.isEmpty()) {
                tempString+=inputString[i]
            }
        }
        return list.toTypedArray()*/
    }
}
