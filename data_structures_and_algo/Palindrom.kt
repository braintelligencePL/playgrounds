fun main(args: Array<String>) {
    val falseWord = "aaLQWAaa"
    val trueWord = "adeda"

    println( istPalindrom(falseWord) ) // false
    println( istPalindrom(trueWord) )  // true
}

fun istPalindrom(word: String): Boolean {
    var first = 0
    var last = word.length - 1
    while (last > first) {
        if (word[first] != word[last]) {
            return false
        }
        first++
        last--
    }
    return true
}
