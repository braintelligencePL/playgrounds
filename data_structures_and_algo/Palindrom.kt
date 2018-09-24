fun main(args: Array<String>) {
    val char = "aaLAaa".toCharArray()


    print(istPalindrom(char))
}

fun istPalindrom(word: CharArray): Boolean {
    var front = 0
    var back = word.size - 1
    while (back > front) {
        if (word[front] != word[back]) {
            return false
        }
        front++
        back--
    }
    return true
}
