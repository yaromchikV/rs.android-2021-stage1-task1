package subtask1

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {
        val happyArray: MutableList<Int> = mutableListOf()
        var sourceArray = sadArray
        while (true) {
            val tempArray = sourceArray
            for (i in tempArray.indices) {
                if (i == 0 || i == tempArray.size - 1) {
                    happyArray.add(tempArray[i])
                } else if (tempArray[i] <= tempArray[i - 1] + tempArray[i + 1]) {
                    happyArray.add(tempArray[i])
                }
            }
            val happy = happyArray.toIntArray()
            if (sourceArray contentEquals happy)
                break
            sourceArray = happy
            happyArray.clear()
        }
        return sourceArray
    }
}
