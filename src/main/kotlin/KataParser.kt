class KataParser {
    companion object {
        fun parse(input: String): Command? {
            val command = input.split(Regex(" "), 2)
            return when (command[0]) {
                "+" -> Command(Command.Operator.ADD, command[1])
                "-" -> Command(Command.Operator.REMOVE, command[1])
                "x" -> Command(Command.Operator.SET_TODO, command[1])
                "o" -> Command(Command.Operator.SET_DONE, command[1])
                "q" -> Command(Command.Operator.EXIT, command[1])
                else -> null
            }
        }
    }
}
