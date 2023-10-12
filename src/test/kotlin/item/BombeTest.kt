package item

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import feuGregeois
import personnage.Personnage

class BombeTest {

    @Test
    fun utiliser() {

        val gobelin = Personnage(
                "XXX le gobelin",
                pointDeVie = 20,
                pointDeVieMax = 20,
                attaque = 5,
                defense = 4,
                vitesse = 11,
                endurance = 6)

        // Test sur une arme Edict
        val degatsArme = feuGregeois.utiliser(cible = gobelin)

        Assertions.assertTrue(gobelin.pointDeVie >= 1)
        Assertions.assertTrue(gobelin.pointDeVie <= 12)
    }
}