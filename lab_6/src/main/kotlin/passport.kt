import java.util.Date
import java.util.TreeSet

class VehiclePass(val series: String, val number: String, val issueDate: Date):
    Comparable<VehiclePass> {
    init {
        require(series.matches(Regex("[A-Z]{2}"))){ "\n" + "Серия должна состоять из 2 заглавных букв." }
        require(number.matches(Regex("\\d{6}"))){ "\n" + "Номер должен состоять из 6 цифр" }
    }

    fun write() {
        println("Транспортный пасспорт \nСерия: $series\nНомер: $number\nДата регистрации: $issueDate")
    }

    override fun compareTo(other: VehiclePass): Int {
        return compareValuesBy(
            this, other,
            VehiclePass::issueDate, VehiclePass::series
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is VehiclePass) return false
        return series == other.series && number == other.number
    }

    override fun hashCode(): Int {
        var result = series.hashCode()
        result = 31 * result + number.hashCode()
        return result
    }
}


fun main() {
    val doc1 = VehiclePass("AA", "123456", Date(2021, 10, 15))
    val doc2 = VehiclePass("BB", "654321", Date(2020, 5, 20))

    // Вывод документа на экран
    doc1.write()
    doc2.write()

    // Проверка равенства документов
    println("Проверка равенства: ${doc1 == doc2}")

    // Создание HashSet и TreeSet с элементами класса VehicleRegistrationDocument
    val documentsHashSet = hashSetOf(doc1, doc2)

    val documentsTreeSet = TreeSet<VehiclePass>()
    documentsTreeSet.addAll(listOf(doc1, doc2 ))

    // Поиск элементов в HashSet и TreeSet
    val searchDoc = VehiclePass("AA", "123456", Date(2021, 10, 15))
    println("HashSet contains searchDoc: ${documentsHashSet.contains(searchDoc)}")
    println("TreeSet contains searchDoc: ${documentsTreeSet.contains(searchDoc)}")
}