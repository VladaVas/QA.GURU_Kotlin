package previous_lessons.lesson_2.lesson_6

data class Student(
    val studentId: Int,
    val firstName: String,
    val lastName: String,
    val role: Boolean,
    val age: Int,
)

val defaultStudent = Student(
    studentId = 1,
    firstName = "John",
    lastName = "Smith",
    role = false,
    age = 18,
)

enum class DefaultStudent(val student: Student) {
    STUDENT1(Student(1, "John", "Smith", false, 18)),
    STUDENT2(Student(2, "Nancy", "Wheeler", false, 20));

    fun toStudent(): Student = student
}