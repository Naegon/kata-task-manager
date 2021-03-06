class Task(private val description: String) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Task
        return description == other.description
    }

    override fun hashCode(): Int {
        return description.hashCode()
    }

}
