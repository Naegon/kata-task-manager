import Command.Operator.*

class TaskManager {
    val tasks: ArrayList<Task> = arrayListOf()

    fun execute(command: Command) {
        when (command.operator) {
            ADD -> createNewTask(command.argument)
            REMOVE -> removeTask(command.argument)
            SET_TODO -> TODO()
            SET_DONE -> TODO()
            EXIT -> TODO()
        }
    }

    private fun removeTask(argument: String?) {
        argument?.let { tasks.removeAt(argument.toInt()) }
    }

    private fun createNewTask(description: String?) {
        tasks.add(Task(description ?: ""))
    }

}
