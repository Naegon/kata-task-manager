class Command(private val operator: Operator, private val argument: String? = null) {

    enum class Operator {
        ADD, REMOVE
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Command

        return (operator == other.operator && argument == other.argument)
    }

    override fun hashCode(): Int = operator.hashCode()

}
