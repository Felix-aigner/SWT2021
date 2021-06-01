package TDDTellerwaermer

class Tellerwaermer(initialAmount: Int, initialState: Boolean = false, maxCount: Int = 10) {

    var maximum = maxCount
    var turnedOn = initialState
    var tellerCount: Int = initialAmount

    fun viewCheck(): String {
        if (this.tellerCount >= 1)
            return "success"
        return "failed"
    }

    fun add(amount: Int): String {
        if (this.turnedOn &&
            (this.tellerCount + amount) <= maximum
        ) {
            this.tellerCount += amount
            return "success"
        }
        return "failed"
    }

    fun take(amount: Int): String {
        if (this.turnedOn &&
            (this.tellerCount - amount) >= 0
        ) {
            this.tellerCount -= amount
            return "success"
        }
        return "failed"
    }

    fun turnOn(): String {
        this.turnedOn = true
        return "turned On"
    }

    fun turnOff(): String {
        if (this.tellerCount > 0)
            return "one or more plates remaining, not able to turn off"
        this.turnedOn = false
        return "turned Off"
    }
}
