package item

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import edict
import org.junit.jupiter.api.Assertions

class ArmeTest {

    @Test
    fun calculerDegats() {

        // Test sur une arme Edict
        val degatsArme = edict.calculerDegats()

        Assertions.assertTrue(degatsArme>= 1)
        Assertions.assertTrue(degatsArme <= 12)
    }}