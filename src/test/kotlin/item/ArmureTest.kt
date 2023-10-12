package item

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import cotteDeMaille
import org.junit.jupiter.api.Assertions

class ArmureTest {

    @Test
    fun calculProtection() {
        // Test sur une armure cottedemaille
        val bonusProtection = cotteDeMaille.calculProtection()
        Assertions.assertEquals(7, bonusProtection)

    }
}