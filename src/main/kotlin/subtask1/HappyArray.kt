package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {
        val happyArray = sadArray.toMutableList()
        var i = 0
        while (i < happyArray.size) {
            if (i != 0 && i != happyArray.size - 1) {
                if (happyArray[i] > happyArray[i - 1] + happyArray[i + 1]) {
                    happyArray.removeAt(i)
                    i -= 2
                }
            }
            i += 1
        }
        return happyArray.toIntArray()
    }
}
