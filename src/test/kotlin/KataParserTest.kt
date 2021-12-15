import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class KataParserTest {
    @Test
    fun parse_WithAdd() {
        // Given
        val input = "+ description"

        // When
        val command = Command.parse(input)

        // Then
        assertEquals(command, Command(Command.Operator.ADD, "description"))
    }

    @Test
    fun parse_WithRemove() {
        // Given
        val input = "- 2"

        // When
        val command = Command.parse(input)

        // Then
        assertEquals(command, Command(Command.Operator.REMOVE, "2"))
    }

    @Test
    fun parse_WithSetTodo() {
        // Given
        val input = "x 2"

        // When
        val command = Command.parse(input)

        // Then
        assertEquals(command, Command(Command.Operator.SET_TODO, "2"))
    }

    @Test
    fun parse_WithSetDone() {
        // Given
        val input = "o 2"

        // When
        val command = Command.parse(input)

        // Then
        assertEquals(command, Command(Command.Operator.SET_DONE, "2"))
    }

    @Test
    fun parse_WithExit() {
        // Given
        val input = "q"

        // When
        val command = Command.parse(input)

        // Then
        assertEquals(command, Command(Command.Operator.EXIT))
    }

}
