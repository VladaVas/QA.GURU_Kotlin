package previous_lessons.lesson_2.lesson_6

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
    @DisplayName("Verify STUDENT1 data")
    fun verifyStudent1() {

        val enumStudent = DefaultStudent.STUDENT1.toStudent()

        enumStudent.age shouldBe defaultStudent.age
        enumStudent.firstName shouldBe defaultStudent.firstName
        enumStudent.lastName shouldBe defaultStudent.lastName
        enumStudent.role shouldBe false
    }

    @Test
    @DisplayName("Verify STUDENT2 data")
    fun verifyStudent2() {

        val enumStudent = DefaultStudent.STUDENT1.toStudent()

        enumStudent.age shouldBe defaultStudent.age
        enumStudent.firstName shouldBe defaultStudent.firstName
        enumStudent.lastName shouldBe defaultStudent.lastName
        enumStudent.role shouldBe false
    }
}
