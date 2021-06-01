import TDDTellerwaermer.Tellerwaermer
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class TellerwaermerTest {

    @Test
    fun turnOn() {
        val tw = Tellerwaermer(0)
        // Given das Wärmegerät ist ausgeschaltet
        assertEquals(tw.turnedOn, false)
        // When ich das Wärmegerät einschalte
        tw.turnOn()
        // Then ist das Wärmegerät betriebsbereit
        assertEquals(tw.turnedOn, true)
        // And der Tellerstapel ist leer
        assertEquals(tw.tellerCount, 0)
    }

    @Test
    fun turnEmptyOff() {
        val tw = Tellerwaermer(0, true)
        // Given das Wärmegerät ist eingeschaltet
        assertEquals(tw.turnedOn, true)
        // And das Wärmegerät ist leer
        assertEquals(tw.tellerCount, 0)
        // When ich das Wärmegerät ausschalte
        tw.turnOff()
        // Then ist das Wärmegerät ausser Betrieb
        assertEquals(tw.turnedOn, false)
        // And es können keine Teller hinzugefügt werden
        tw.add(1)
        assertNotEquals(tw.tellerCount, 1)
    }

    @Test
    fun turnOffFilled() {
        val tw = Tellerwaermer(0, true)
        // Given das Wärmegerät ist eingeschaltet
        assertEquals(tw.turnedOn, true)
        // And das Wärmegerät ist gefüllt
        tw.add(5)
        assertNotEquals(tw.tellerCount, 0)
        // When ich das Wärmegerät ausschalte
        val response = tw.turnOff()
        // Then erhalte ich einen Hinweis, dass das Wärmegerät noch gefüllt ist
        assert(response.contains("not able to turn off"))
        // And das Wärmegerät bleibt in Betrieb
        assertEquals(tw.turnedOn, true)
    }

    @Test
    fun turnOffMaxed() {
        val tw = Tellerwaermer(0, true)
        // Given das Wärmegerät ist eingeschaltet
        assertEquals(tw.turnedOn, true)
        // And das Wärmegerät ist gefüllt
        tw.add(10)
        assertNotEquals(tw.tellerCount, 0)
        // When ich das Wärmegerät ausschalte
        val response = tw.turnOff()
        // Then erhalte ich einen Hinweis, dass das Wärmegerät noch gefüllt ist
        assert(response.contains("not able to turn off"))
        // And das Wärmegerät bleibt in Betrieb
        assertEquals(tw.turnedOn, true)
    }

    @Test
    fun OutlineAddPlate() {
        val tw = Tellerwaermer(0, true)
        // Given das Wärmegerät ist eingeschaltet
        assertEquals(tw.turnedOn, true)
        // And die maximale Kapazität des Tellerstapels ist 10
        assertEquals(tw.maximum, 10)

        for (i in 1..11) {
            // And im Wärmegerät sind <Telleranzahl> Teller
            val initCount = tw.tellerCount
            // When ich einen Teller hinzufüge
            val response = tw.add(1)
            // Then sind <NeueTelleranzahl> Teller im Wärmegerät

            when (i) {
                11 -> assertEquals(10, tw.tellerCount)
                else -> assertEquals(i, tw.tellerCount)
            }
            // And eine <Hinweismeldung> informiert mich ob das hinzufügen erfolgreich war
            when (i) {
                11 -> assert(response.contains("failed"))
                else -> assert(response.contains("success"))
            }
        }
    }

    @Test
    fun OutlineTakePlate() {
        val tw = Tellerwaermer(10, true)
        // Given das Wärmegerät ist eingeschaltet
        assertEquals(tw.turnedOn, true)
        // And die maximale Kapazität des Tellerstapels ist 10
        assertEquals(tw.maximum, 10)
        assertEquals(tw.tellerCount, 10)
        for (i in 1..11) {
            // And im Wärmegerät sind <Telleranzahl> Teller
            val initCount = tw.tellerCount
            // When ich nehme einen Teller aus dem Stapel
            val response = tw.take(1)

            // Then sind <NeueTelleranzahl> Teller im Wärmegerät
            when (i) {
                11 -> assertEquals(0, tw.tellerCount)
                else -> assertEquals((initCount - 1), tw.tellerCount)
            }

            // And eine <Hinweismeldung> informiert mich ob das entnehmen erfolgreich war
            when (i) {
                11 -> assert(response.contains("failed"))
                else -> assert(response.contains("success"))
            }
        }
    }

    @Test
    fun OutlineViewCheck() {
        val tw = Tellerwaermer(10, true)
        // Given das Wärmegerät ist eingeschaltet
        assertEquals(tw.turnedOn, true)
        // And die maximale Kapazität des Tellerstapels ist 10
        assertEquals(tw.maximum, 10)

        for (i in 1..11) {
            // And im Wärmegerät sind <Telleranzahl> Teller
            val initCount = tw.tellerCount
            // When ich nehme einen Teller zur Ansicht entnehme
            val response = tw.viewCheck()
            // Then informiert mich eine <Hinweismeldung> ob dies möglich ist
            when (i) {
                11 -> assert(response.contains("failed"))
                else -> assert(response.contains("success"))
            }
            tw.take(1)
        }
    }
}
