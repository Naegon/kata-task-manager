import Command.Operator.*

class TaskManager {
    val tasks: ArrayList<Task> = arrayListOf()

    fun execute(command: Command) {
        when (command.operator) {
            ADD -> createNewTask(command.argument)
            REMOVE -> TODO()
            SET_TODO -> TODO()
            SET_DONE -> TODO()
            EXIT -> TODO()
        }
    }

    private fun createNewTask(description: String?) {
        tasks.add(Task(description ?: ""))
    }

}
