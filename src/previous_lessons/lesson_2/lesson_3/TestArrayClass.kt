package previous_lessons.lesson_2.lesson_3

import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.shouldBe
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName

@Feature("SecondClass")
@Story("Test checking arrays")
@Tag("arrays")
class TestArrayClass {

    @Test
    @DisplayName("Test checking array is empty")
    fun arrayIsEmpty() {
        val array = arrayOf<Int>()
        array.shouldBeEmpty()
    }

    @Test
    @DisplayName("Test checking array is NOT empty")
    fun arrayIsNotEmpty() {
        val array = arrayOf<Int>(1, 2, 3)
        array.shouldNotBeEmpty()
    }

    @Test
    @DisplayName("Test taking the first element from the array and check expecting result")
    fun firstElementArray() {
        val array = arrayOf(1, 2, 3)
        val firstIndex = array.get(0)

        firstIndex shouldBe 1
    }
}