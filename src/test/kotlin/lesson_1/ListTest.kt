package lesson_1

import io.kotest.matchers.shouldBe
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

@Feature("Basic Tests")
@Story("Test of merging two lists")
@Tags (Tag("regression"), Tag("list"))

class ListTest {
    @Test
    @DisplayName("Test of merging two integer lists into one")

    fun mergingTwoList() {
        val list1 = listOf(1, 2, 3, 4, 5)
        val list2 = listOf(6, 7, 8, 9, 10)
        val exceptionList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val actualList = list1 + list2

        exceptionList shouldBe actualList
    }
}