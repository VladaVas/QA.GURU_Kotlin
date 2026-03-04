package previous_lessons.lesson_2.lesson_5


fun String.isPhoneNumberValid(): Boolean {
    val regex = Regex("^\\+?[1-9]\\d{1,14}$")
    return regex.matches(this)
}

fun String.shouldBeUpperCase(): Boolean {
    if (this == this.uppercase()) return true else return false
}

infix fun PersonData.shouldHaveName(expected: String) {
    if (name.isEmpty()) {
        println("Name should not be empty. Please enter your name.")
    } else if (name != expected) {
        println("Name is not equal to $expected")
    }
}