import item.Qualite
import jeu.Jeu
import personnage.Personnage
import item.TypeArme
import item.Arme
import item.TypeArmure
import item.Armure
import item.Bombe
import item.Potion

// instanciation des qualités des objets
val qualiteCommun = Qualite("commun", 0, "\u001B[32m")
val qualiteRare = Qualite("rare", 1, couleur = "\u001B[34m")
val qualiteEpic = Qualite("epic", 2, "\u001B[35m")
val qualiteLegendaire = Qualite("legendaire", 3, "\u001B[33m")


// Instances de TypeArme :
val dague = TypeArme(1, 4, 3, 18)
val baton = TypeArme(1,6,2,20)
val lance = TypeArme(1,8,3,20)
val arbaleteLegere = TypeArme(1,8,2,19)
val epeeCourte = TypeArme(1,6,2,19)
val hache = TypeArme(1,8,3,20)
val epeeLongue = TypeArme(1,8,2,19)
val marteauDeGuerre = TypeArme(1,8,3,20)
val arcLong = TypeArme(1,8,3,20)

// Instances de Arme :
val edict = Arme("Edict", qualiteLegendaire, dague, "Une dague légendaire en mithril")

// Instances du TypeArmures:
val rembourre = TypeArmure("Rembourré",1)
val cuir = TypeArmure("Cuir",2)
val cuirCloute = TypeArmure("Cuir clouté",3)
val chemiseAChaine = TypeArmure("Chemise à Chaine",4)
val pectoral = TypeArmure("Pectoral",5)
val cotteDeMailles = TypeArmure("Cotte de Mailles",6)

// Instances d'Armure:
val cotteDeMaille = Armure("Cotte de mailles en adamantine +1", qualiteRare,cotteDeMailles,"Cotte de mailles plus lourde mais aussi plus solide.")
val leManteauDeLaNuit = Armure("Le manteau de la nuit",qualiteEpic,cuir,"Une armure en cuir obscure comme la nuit")
val armureDuGobelin = Armure("Armure du gobelin ",qualiteCommun, cuir, "Armure en cuir rudimentaire" )

// Instance de bombe
val feuGregeois = Bombe("Feu Gregeois",4,6,"Une flasque qui contient un liquide inflammable.")
val flasqueDAcide = Bombe("Flasque d’acide",2,8,"Une flasque qui contient une puissante substance corrosive.")
val grenade = Bombe("Grenade",5,6,"Une contraception qui explose une fois lancée. ")

// Instance de potion
val potionDeSoins = Potion("Potion de soins",20,"Une potion qui contient un liquide rouge.")
val grandePotionDeSoins = Potion("Grande potion de soins",30,"Une grande potion qui contient un liquide rouge.")


fun main(args: Array<String>) {
    //Instantiation des monstres
    val gobelin = Personnage(
        "XXX le gobelin",
        pointDeVie = 20,
        pointDeVieMax = 20,
        attaque = 5,
        defense = 4,
        vitesse = 11,
        endurance = 6
        )
    val sorcier = Personnage(
            "XXX le sorcier",
            pointDeVie = 20,
            pointDeVieMax = 20,
            attaque = 7,
            defense = 5,
            vitesse = 20,
            endurance = 9)
    // TODO Intermission 1 Ajouter d'autres monstres
    //On ajoute les monstres a la liste de monstres du jeu
    val jeu = Jeu(listOf( gobelin , sorcier))
    //Lancement du jeu
    jeu.lancerCombat()
}