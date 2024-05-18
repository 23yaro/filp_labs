import java.io.File
abstract class DocumentCollection<Doc> {
    abstract fun searchDoc(doc: Doc): Boolean

    fun measureSearchTime(doc: Doc): Long {
        val startTime = System.currentTimeMillis()
        searchDoc(doc)
        return System.currentTimeMillis() - startTime
    }
}

// Наследник для массива
class ArrayDocumentCollection : DocumentCollection<String>() {
    private val documents = arrayOf("doc1", "doc2", "doc3") // Пример данных

    override fun searchDoc(doc: String): Boolean {
        return documents.contains(doc)
    }
}

// Наследник для списка
class ListDocumentCollection : DocumentCollection<String>() {
    private val documents = listOf("doc1", "doc2", "doc3") // Пример данных

    override fun searchDoc(doc: String): Boolean {
        return documents.contains(doc)
    }
}

// Наследник для двоичного списка
class BinaryListDocumentCollection : DocumentCollection<String>() {
    private val documents = listOf("doc1", "doc2", "doc3").sorted() // Пример данных

    override fun searchDoc(doc: String): Boolean {
        return documents.binarySearch(doc) >= 0
    }
}

fun main() {
    val docSeries = mutableListOf<String>()
    File("C:\\Users\\wqeqewqwe\\Desktop\\filp_labs\\lab_6\\src\\main\\kotlin\\docToSearch.txt").forEachLine { line ->
        docSeries.add(line)
    }

    val collections = listOf(
        ArrayDocumentCollection(),
        ListDocumentCollection(),
        BinaryListDocumentCollection()
        // Добавьте HashSetDocumentCollection и TreeSetDocumentCollection
    )

    for (docToSearch in docSeries) {
        println("Поиск для серии номера: $docToSearch")
        for (collection in collections) {
            val searchTime = collection.measureSearchTime(docToSearch)
            if (collection.searchDoc(docToSearch)) {
                println("$docToSearch - Корректная серия номера, элемент существует в базе")
            } else {
                println("$docToSearch - Некорректная серия номера, элемент не существует в базе")
            }
            println("Время поиска в коллекции ${collection.javaClass.simpleName}: $searchTime мс")
        }
    }
}