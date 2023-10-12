package personnage
import main
import cotteDeMaille
import dague
import edict
import item.*


class Personnage(
    val nom: String,
    var pointDeVie: Int,
    val pointDeVieMax: Int,
    var attaque: Int,
    var defense: Int,
    var endurance: Int,
    var vitesse: Int,
    var armePrincipal: Arme = edict,
    var armure: Armure? = cotteDeMaille,
    var armeEquipee: Arme? = null,
    var inventaire: MutableList<Item> = mutableListOf()) {


    fun equipArme(arme: Arme) {

        if (inventaire.contains(arme)) {
            this.armePrincipal = arme
            println("$nom équipe ${arme.nom}")
        } else {
            println("$nom ne peut pas etre equiper ${arme.nom} car il n'est pas dans l'inventaire")
        }
    }

    fun equipArmure(armure: Armure) {

        if (inventaire.contains(armure)) {
            this.armure = armure
            println("$nom équipe ${armure.nom}")
        } else {
            println("$nom ne peut pas etre equiper ${armure.nom} car il n'est pas dans l'inventaire")
        }
    }

    fun calculeTotalDefense(): Int {
        val defenseDeBase = this.defense / 2

        if (this.armure != null) {
            val bonusProtection = this.armure!!.calculProtection()
            return defenseDeBase + bonusProtection
        } else {
            return defenseDeBase;
        }
    }

    // Méthode pour attaquer un adversaire
    fun attaque(adversaire: Personnage) {
        if (armeEquipee != null) {
            val degatsBase = attaque / 2
            val degatsArme = armeEquipee!!.calculerDegats()

            val totalDegats = degatsBase + degatsArme

            val degatsInfliges = maxOf(1, totalDegats - adversaire.calculeTotalDefense())

            adversaire.pointDeVie -= degatsInfliges


            println("$nom attaque ${adversaire.nom} avec ${armeEquipee?.nom ?: "une attaque de base"} et inflige $degatsInfliges points de dégâts.")
        } else {
            val degatsBase = attaque / 2
            val degatsInfliges = maxOf(1, degatsBase - adversaire.calculeTotalDefense())

            adversaire.pointDeVie -= degatsInfliges
            println("$nom attaque ${adversaire.nom} avec une attaque de base et inflige $degatsInfliges points de dégâts.")
        }
    }

    override fun toString(): String {
        return "$nom (PV: $pointDeVie/$pointDeVieMax, Attaque: $attaque, Défense: $defense, Endurance: $endurance, Vitesse: $vitesse)"
    }


    fun avoirPotion(): Boolean {
        for (unObjet in this.inventaire) {
            return if (unObjet is Potion) true else false
        }
        return false
    }

    fun avoirBombe(): Boolean {
        for (unObjet in this.inventaire) {
            return if (unObjet is Bombe) true else false
        }
        return false

    }


    fun boirePotion():Potion? {
        if (avoirPotion() == true) {
            for (unObjet in this.inventaire)
                if (unObjet is Potion) {
                        var soins = unObjet.soin
                        this.pointDeVie += soins
                    if (this.pointDeVie > this.pointDeVieMax){
                        this.pointDeVie = this.pointDeVieMax}
                println("La potion est $unObjet et le nombre de point de soins recuperé est $soins" )
                inventaire.remove(unObjet)
                return unObjet

                }
        }else{
            print("Pas de potion dans l'inventaire")

        }
    return null
    }

    fun afficherInventaire() {

        println("Inventaire de $nom")
        inventaire.forEachIndexed { index, element ->
            println("[$index] $element")

        }
    }




    fun loot(cible: Personnage){
        if(pointDeVie <=0){
            cible.armure = null
            cible.armeEquipee = null
            cible.inventaire.addAll(inventaire)
        }
    }
}
