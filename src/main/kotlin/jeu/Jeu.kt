package jeu

import personnage.Personnage



class Jeu(monstres: List<Personnage>) {
    lateinit var joueur: Personnage
     var combats: MutableList<Combat> = mutableListOf()
    var score: Int = 0

    // Corps du constructeur
    init {
        // Lancement de la création du personage du joueur
        this.creerPersonnage()
        // Pour chaque monstre dans la liste de monstres
        for (unMonstre in monstres){
            // On créer un combat
            val unCombat= Combat(this,unMonstre)
            combats.add(unCombat)
        }
    }

    fun lancerCombat() {
        for (unCombat in this.combats) {
            unCombat.executerCombat()
            // Mettre à jour le score en fonction du nombre de tours
            val tours = unCombat.nombreTours
            score += calculerScore(tours)
        }
        println("Score final du joueur: $score")
    }

    private fun calculerScore(tours: Int): Int {
        // Par exemple, vous pouvez attribuer plus de points pour moins de tours
        return 500 - tours * 10
    }

    /**
     *  Méthode pour créer le personnage du joueur en demandant les informations à l'utilisateur
     */


    fun creerPersonnage(): Personnage {
        println("Création de votre personnage:")

        // Initialiser les attribues
        var nom: String = ""
        var attaque: Int = 0
        var defense: Int = 0
        var endurance: Int = 0
        var vitesse: Int = 0

        // demander le nom du joueur
        println("Entrez le nom du personnage:")
        nom = readLine() ?: ""

        // repartir l'ensemble des 40 points


        while (true) {
            var restantPoints = 40
            println("Points restants: $restantPoints")

            print("Points d'attaque (0-$restantPoints): ")
            attaque = readLine()?.toIntOrNull() ?: 0
            restantPoints = restantPoints - attaque
            print("Points de défense (0-$restantPoints): ")
            defense = readLine()?.toIntOrNull() ?: 0
            restantPoints = restantPoints - defense
            print("Points d'endurance (0-$restantPoints): ")
            endurance = readLine()?.toIntOrNull() ?: 0
            restantPoints = restantPoints - endurance
            print("Points de vitesse (0-$restantPoints): ")
            vitesse = readLine()?.toIntOrNull() ?: 0
            restantPoints = restantPoints - vitesse
            val totalPoints = attaque + defense + endurance + vitesse

            if (restantPoints >= 0) {
                break
            } else {
                println("Le total des points d'attributs ne doit pas dépasser 40.")
            }
        }

        // calcul de la vie selon l'endurance
        val maxvie = 50 + endurance * 10

        // creation des atribue
        val joueuratribut = Personnage(nom, maxvie, maxvie, attaque, defense, endurance, vitesse, )

        // Assigner la creation du personnage au attribue du joueur character to the joueur attribute
        joueur = joueuratribut

        return joueuratribut
    }
    

}