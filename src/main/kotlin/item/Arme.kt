package item

import jeu.TirageDes
import personnage.Personnage
import item.Armure

    class Arme (nom:String,
            val qualiteArme: Qualite,
            val typeArme: TypeArme,
             description:String, ):Item(nom,description){
        val mcrit = typeArme.multiplicateurCritique
        val crit = typeArme.activationCritique
        val rarearme = qualiteArme.bonusRarete


    fun calculerDegats() :Int{
        val deg = TirageDes(this.typeArme.nombreDes,this.typeArme.valeurDeMax).lance()
        val deCritique = TirageDes(1,20).lance()
        var degat = deg


        if ( deCritique>= crit ) {
            degat = degat * mcrit
            println ("coup critique!")
        }
        degat = degat + rarearme

        return degat
    }


        override fun utiliser(personnage: Personnage){
        personnage.equipArme(this)



        }




}

