class Node(var data: String) {
    var left: Node? = null
    var right: Node? = null
}

class BinaryTree {
    var root: Node? = null
    fun insertList(list: List<String>, comparator: Comparator<String?>) {
        for (str in list) {
            root = insertRec(root, str, comparator)
        }
    }

    private fun insertRec(root: Node?, data: String?, comparator: Comparator<String?>): Node {
        var root = root
        if (root == null) {
            root = Node(data!!)
            return root
        }

        if (comparator.compare(data, root.data) < 0) {
            root.left = insertRec(root.left, data, comparator)
        } else if (comparator.compare(data, root.data) > 0) {
            root.right = insertRec(root.right, data, comparator)
        }

        return root
    }

    fun toList():List<String> {
        return inOrderRec(root)
    }

    private fun inOrderRec(root: Node?, list: MutableList<String> = mutableListOf()):List<String> {
        if (root != null) {
            inOrderRec(root.left,list)
            list.add(root.data)
            inOrderRec(root.right,list)
        }
        return list
    }


}

fun main() {
    val inputStrings = listOf("2 3 ", " 1 ", "4 5 6", "0", "7 8 9")

    val wordCountComparator = Comparator { str1: String, str2: String ->
        val wordCountCompare = Integer.compare(str1.split(" ".toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray().size, str2.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().size)
        if (wordCountCompare == 0) {
            return@Comparator str1.compareTo(str2)
        }
        wordCountCompare
    }
    val tree = BinaryTree()

    tree.insertList(inputStrings,wordCountComparator)

    println(tree.toList())
}