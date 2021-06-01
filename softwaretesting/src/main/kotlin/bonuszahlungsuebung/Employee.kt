package bonuszahlungsuebung

// Neustaedter Johannes & Aigner Felix-Xaver

data class Employee(
    val employmentYears: Int,
    val position: Position = Position.DEFAULT
) {
    fun getBonus(): Int {
        when (this.employmentYears) {
            in 0..1 -> 0
            in 2..3 -> 50
            in 4..9 -> 80
            in 10..74 -> 120
            else -> throw PlausibilityCheckException()
        }.let {
            return if (this.position != Position.DEFAULT) it * 2 else it
        }
    }
}

enum class Position {
    DEFAULT,
    MAILDEP,
    OFFICE
}

class PlausibilityCheckException : Exception()
