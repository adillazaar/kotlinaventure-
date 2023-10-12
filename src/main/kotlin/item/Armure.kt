package item

import personnage.Personnage


class Armure(nom: String,
             val objQualiteArmure: Qualite  ,
             val objTypeArmure: TypeArmure,
             description: String,) :Item(nom,description) {

    fun calculProtection(): Int {
        val bonusProtection = objTypeArmure.bonustype + objQualiteArmure.bonusRarete
        return bonusProtection
    }

    override fun utiliser(personnage: Personnage){


    }
}