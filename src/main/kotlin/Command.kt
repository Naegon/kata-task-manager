import Command.Operator.*

class Command(val operator: Operator, val argument: String? = null) {

    enum class Operator {
        ADD, REMOVE, SET_TODO, SET_DONE, EXIT
    }

    companion object {
        fun parse(input: String): Command? {
            val command = input.split(Regex(" "), 2)
            return when (command[0]) {
                "+" -> Command(ADD, command[1])
                "-" -> Command(REMOVE, command[1])
                "x" -> Command(SET_TODO, command[1])
                "o" -> Command(SET_DONE, command[1])
                "q" -> Command(EXIT)
                else -> null
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Command

        return (operator == other.operator && argument == other.argument)
    }

    override fun hashCode(): Int = operator.hashCode()

}
