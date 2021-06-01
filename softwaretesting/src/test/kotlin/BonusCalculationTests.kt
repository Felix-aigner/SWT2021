import bonuszahlungsuebung.Employee
import bonuszahlungsuebung.PlausibilityCheckException
import bonuszahlungsuebung.Position
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

// Neustaedter Johannes & Aigner Felix-Xaver

class BonusCalculationTests {

    // Default Position
    @Test
    fun `if employed for negative number of years, PlausibilityException should be thrown`() {
        val employee = Employee(-1)
        assertThrows<PlausibilityCheckException> { employee.getBonus() }
    }

    @Test
    fun `if employed for 0 years, no bonus should be added`() {
        val employee = Employee(0)
        assertEquals(0, employee.getBonus())
    }

    @Test
    fun `if employed for 1 years, no bonus should be added`() {
        val employee = Employee(1)
        assertEquals(0, employee.getBonus())
    }

    @Test
    fun `if employed for 2 years, 50 percent bonus should be added`() {
        val employee = Employee(2)
        assertEquals(50, employee.getBonus())
    }

    @Test
    fun `if employed for 3 years, 50 percent bonus should be added`() {
        val employee = Employee(3)
        assertEquals(50, employee.getBonus())
    }

    @Test
    fun `if employed for 4 years, 80 percent bonus should be added`() {
        val employee = Employee(4)
        assertEquals(80, employee.getBonus())
    }

    @Test
    fun `if employed for 9 years, 80 percent bonus should be added`() {
        val employee = Employee(9)
        assertEquals(80, employee.getBonus())
    }

    @Test
    fun `if employed for 10 years, 120 percent bonus should be added`() {
        val employee = Employee(10)
        assertEquals(120, employee.getBonus())
    }

    @Test
    fun `if employed for 74 years, 120 percent bonus should be added`() {
        val employee = Employee(74)
        assertEquals(120, employee.getBonus())
    }

    @Test
    fun `if employed for 75 years, PlausibilityException should be thrown`() {
        val employee = Employee(75)
        assertThrows<PlausibilityCheckException> { employee.getBonus() }
    }

    // Mail Department Position
    @Test
    fun `if employed for negative number of years in Mail Department, PlausibilityException should be thrown`() {
        val employee = Employee(-1, Position.MAILDEP)
        assertThrows<PlausibilityCheckException> { employee.getBonus() }
    }

    @Test
    fun `if employed for 0 years in Mail Department, no bonus should be added`() {
        val employee = Employee(0, Position.MAILDEP)
        assertEquals(0, employee.getBonus())
    }

    @Test
    fun `if employed for 1 years in Mail Department, no bonus should be added`() {
        val employee = Employee(1, Position.MAILDEP)
        assertEquals(0, employee.getBonus())
    }

    @Test
    fun `if employed for 2 years in Mail Department, 100 percent bonus should be added`() {
        val employee = Employee(2, Position.MAILDEP)
        assertEquals(100, employee.getBonus())
    }

    @Test
    fun `if employed for 3 years in Mail Department, 100 percent bonus should be added`() {
        val employee = Employee(3, Position.MAILDEP)
        assertEquals(100, employee.getBonus())
    }

    @Test
    fun `if employed for 4 years in Mail Department, 160 percent bonus should be added`() {
        val employee = Employee(4, Position.MAILDEP)
        assertEquals(160, employee.getBonus())
    }

    @Test
    fun `if employed for 9 years in Mail Department, 160 percent bonus should be added`() {
        val employee = Employee(9, Position.MAILDEP)
        assertEquals(160, employee.getBonus())
    }

    @Test
    fun `if employed for 10 years in Mail Department, 240 percent bonus should be added`() {
        val employee = Employee(10, Position.MAILDEP)
        assertEquals(240, employee.getBonus())
    }

    @Test
    fun `if employed for 74 years in Mail Department, 240 percent bonus should be added`() {
        val employee = Employee(74, Position.MAILDEP)
        assertEquals(240, employee.getBonus())
    }

    @Test
    fun `if employed for 75 years in Mail Department, PlausibilityException should be thrown`() {
        val employee = Employee(75, Position.MAILDEP)
        assertThrows<PlausibilityCheckException> { employee.getBonus() }
    }


    // Office Position
    @Test
    fun `if employed for negative number of years in Office, PlausibilityException should be thrown`() {
        val employee = Employee(-1, Position.OFFICE)
        assertThrows<PlausibilityCheckException> { employee.getBonus() }
    }

    @Test
    fun `if employed for 0 years in Office, no bonus should be added`() {
        val employee = Employee(0, Position.OFFICE)
        assertEquals(0, employee.getBonus())
    }

    @Test
    fun `if employed for 1 years in Office, no bonus should be added`() {
        val employee = Employee(1, Position.OFFICE)
        assertEquals(0, employee.getBonus())
    }

    @Test
    fun `if employed for 2 years in Office, 100 percent bonus should be added`() {
        val employee = Employee(2, Position.OFFICE)
        assertEquals(100, employee.getBonus())
    }

    @Test
    fun `if employed for 3 years in Office, 100 percent bonus should be added`() {
        val employee = Employee(3, Position.OFFICE)
        assertEquals(100, employee.getBonus())
    }

    @Test
    fun `if employed for 4 years in Office, 160 percent bonus should be added`() {
        val employee = Employee(4, Position.OFFICE)
        assertEquals(160, employee.getBonus())
    }

    @Test
    fun `if employed for 9 years in Office, 160 percent bonus should be added`() {
        val employee = Employee(9, Position.OFFICE)
        assertEquals(160, employee.getBonus())
    }

    @Test
    fun `if employed for 10 years in Office, 240 percent bonus should be added`() {
        val employee = Employee(10, Position.OFFICE)
        assertEquals(240, employee.getBonus())
    }

    @Test
    fun `if employed for 74 years in Office, 240 percent bonus should be added`() {
        val employee = Employee(74, Position.OFFICE)
        assertEquals(240, employee.getBonus())
    }

    @Test
    fun `if employed for 75 years in Office, PlausibilityException should be thrown`() {
        val employee = Employee(75, Position.OFFICE)
        assertThrows<PlausibilityCheckException> { employee.getBonus() }
    }


}
