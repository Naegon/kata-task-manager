import Command.Operator.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CommandTest {
    @Test
    fun parse_WithAdd() {
        // Given
        val input = "+ description"

        // When
        val command = Command.parse(input)

        // Then
        assertEquals(command, Command(ADD, "description"))
    }

    @Test
    fun parse_WithRemove() {
        // Given
        val input = "- 2"

        // When
        val command = Command.parse(input)

        // Then
        assertEquals(command, Command(REMOVE, "2"))
    }

    @Test
    fun parse_WithSetTodo() {
        // Given
        val input = "x 2"

        // When
        val command = Command.parse(input)

        // Then
        assertEquals(command, Command(SET_TODO, "2"))
    }

    @Test
    fun parse_WithSetDone() {
        // Given
        val input = "o 2"

        // When
        val command = Command.parse(input)

        // Then
        assertEquals(command, Command(SET_DONE, "2"))
    }

    @Test
    fun parse_WithExit() {
        // Given
        val input = "q"

        // When
        val command = Command.parse(input)

        // Then
        assertEquals(command, Command(EXIT))
    }

    @Test
    fun executeAddAction() {
        // Given
        val command = Command(ADD, "description")
        val taskManager = TaskManager()

        // When
        taskManager.execute(command)

        // Then
        assertEquals(taskManager.tasks[0], Task("description"))
    }

    @Test
    fun executeRemoveAction() {
        // Given
        val command = Command(REMOVE, "0")
        val commandAdd = Command(ADD, "description1")
        val commandAdd2 = Command(ADD, "description2")

        val taskManager = TaskManager()
        taskManager.execute(commandAdd)
        taskManager.execute(commandAdd2)

        assertTrue(taskManager.tasks.contains(Task("description1")))
        // When
        taskManager.execute(command)

        // Then
        assertFalse(taskManager.tasks.contains(Task("description1")))
    }
}
