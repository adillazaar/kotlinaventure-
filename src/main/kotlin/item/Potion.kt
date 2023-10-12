package item

import personnage.Personnage

open class Potion(nom:String, val soin: Int, description : String):Item(nom,description){


    override fun utiliser(cible: Personnage){
        println("$nom boit la potion.")

    }
}