import java.util.Date

class User(
    var firstName: String,
    var lastName: String,
    var fatherName: String,
    var birthDay: Date,
    var telegram: String
) :
    Comparable<User> {

    fun write() {
        println(
            "Пользователь\n" +
                    "Фамилия : $lastName\n" +
                    "Имя : $firstName\n" +
                    "Отчество : $fatherName\n" +
                    "Телега : $telegram\n" +
                    "Дата рождения: ${birthDay}\n"
        )
    }

    override fun equals(other: Any?): Boolean = if (other is User) {
        (firstName == other.firstName) &&
                (lastName == other.lastName) &&
                (fatherName == other.fatherName) &&
                (birthDay == other.birthDay)
    } else false

    override fun compareTo(other: User): Int {
        return compareValuesBy(
            this, other,
            User::birthDay, User::lastName, User::firstName, User::fatherName
        )
    }

    override fun hashCode(): Int {
        var result = birthDay.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + firstName.hashCode()
        result = 31 * result + fatherName.hashCode()
        result = 31 * result + telegram.hashCode()
        return result
    }

}