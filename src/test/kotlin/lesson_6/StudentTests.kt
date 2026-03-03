package lesson_6

import io.kotest.matchers.shouldBe
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Feature("Student Management")
@Story("Compare student objects")
@Tag("Student")
class StudentTests {

    @Test
    @DisplayName("Compare created student with defaultStudent")
    fun compareStudentData() {
        val student = Student(1, "John", "Smith", false, 18)

        student shouldBe defaultStudent
    }

    @Test
    @DisplayName("Check that Student matches DefaultStudents enum")
    fun compareStudentsWithEnum() {
        DefaultStudent.entries.forEach { enumStudent ->
            val studentFromTest = enumStudent.toStudent()
            studentFromTest shouldBe enumStudent.student

            when (studentFromTest.age) {
                18 -> println("Student should be 18")
                20 -> println("Student should be 20")
            }
        }
    }

    @Test
    @DisplayName("Create modified Student using copy()")
    fun copyStudetData() {
        val modifiedStudent = DefaultStudent.STUDENT1.student.copy(age = 19)
        modifiedStudent.age shouldBe 19
    }

    @Test
    @DisplayName("Check that Student matches DefaultStudents with when()")
    fun compareEnumStudentsWithWhen() {
        DefaultStudent.entries.forEach { enumStudent ->
            val studentFromTest = enumStudent.toStudent()

            when (enumStudent) {
                DefaultStudent.STUDENT1 -> {
                    studentFromTest.firstName shouldBe "John"
                    studentFromTest.lastName shouldBe "Smith"
                    studentFromTest.age shouldBe 18
                }

                DefaultStudent.STUDENT2 -> {
                    studentFromTest.firstName shouldBe "Nancy"
                    studentFromTest.lastName shouldBe "Wheeler"
                    studentFromTest.age shouldBe 20
                }
            }

        }

    }
}