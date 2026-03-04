package previous_lessons.lesson_2.lesson_5

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

data class PersonData(var name: String)


class PersonTest {

    @Test
    @DisplayName("Name is not empty")
    fun PersonNameIsNotEmpty() {
        val person = PersonData("Dmitry")

        person shouldHaveName "Dmitry"
    }

    @Test
    @DisplayName("Name is empty")
    fun PersonNameIsEmpty() {
        val person = PersonData("")

        person shouldHaveName "Dmitry"
    }
}


