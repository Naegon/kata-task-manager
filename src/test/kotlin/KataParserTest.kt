import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class KataParserTest {
    @Test
    fun parse() {
        // Given
        val input = "+ description"

        // When
        val command = KataParser.parse(input)

        // Then
        assertEquals(command, Command(Command.Operator.ADD, "description"))
    }

}
