class KataParser {
    companion object {
        fun parse(input: String): Command? {
            val command = input.split(Regex(" "), 2)
            return when (command[0]) {
                "+" -> Command(Command.Operator.ADD, command[1])
                else -> null
            }
        }
    }
}
