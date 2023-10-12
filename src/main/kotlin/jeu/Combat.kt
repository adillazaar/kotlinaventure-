package jeu

import item.Bombe
import item.Item
import item.Potion
import personnage.Personnage
import java.util.Random

class Combat(
    val jeu :Jeu,
    val monstre: Personnage,
    var inventaire: MutableList<Item> = mutableListOf()) {


    var nombreTours: Int = 1

    // Méthode pour simuler un tour de combat du joueur
    fun tourDeJoueur() {
        println("\u001B[34m ---Tour de ${this.jeu.joueur.nom} (pv: ${this.jeu.joueur.pointDeVie}) ---")

        // Afficher les options d'action disponibles avec des numéros
        println("Actions disponibles :")
        println("0 => Attaquer")
        println("1 => Passer")
        println("2 => Boire Potion")
        println("3 => Choisir un objet de son inventaire ")

        // Inviter le joueur à choisir une action
        print("Choisissez une action (0 ou 1 ou 2 ou 3) : ")
        val choixAction = readLine()

        // Traiter le choix de l'action
        when (choixAction) {
            "0" -> {
                // Le joueur choisit d'attaquer
                this.jeu.joueur.attaque(monstre)
            }

            "1" -> {
                // Le joueur choisit de passer
                println("Vous avez choisi de passer.")
            }

            "2" -> {
                // Le joueur choisit dze boire une potion
                this.jeu.joueur.boirePotion()
            }
            "3" -> {
            // Le joueur choisis d'utliser un objet de son inventaire
               println( this.jeu.joueur.afficherInventaire())
                val choixInventaire = readln().toInt()
                val tailleInventaire = this.jeu.joueur.inventaire.size

                if ( choixInventaire <= tailleInventaire) {

                    val item = this.jeu.joueur.inventaire[choixInventaire]
                    if (item is Bombe) {
                        item.utiliser(monstre)
                    } else {
                        item.utiliser(this.jeu.joueur)
                    }
                }
            }
            else -> {
                // Action invalide
                println("Action invalide. Veuillez choisir une action valide.")
            }
        }

        println("\u001b[0m")
    }

    // Méthode pour simuler un tour de combat du monstre

    fun tourDeMonstre() {
        println("\u001B[31m---Tour de ${monstre.nom} (pv: ${monstre.pointDeVie}) ---")

        // Générer un nombre aléatoire entre 1 et 100
        val randomDecision = (1..100).random()

        if (randomDecision <= 70) {
            // Le monstre choisit d'attaquer
            monstre.attaque(jeu.joueur)

        } else if (monstre.pointDeVie <= monstre.pointDeVieMax / 2 && randomDecision <= 80) {


            monstre.boirePotion()


        } else {
            // Le monstre choisit de passer
            println("Le monstre ${monstre.nom} a choisi de passer son tour.")
        }

        println("\u001b[0m")
    }


    // Méthode pour exécuter le combat complet
    fun executerCombat() {
        println("Début du combat : ${this.jeu.joueur.nom} vs ${monstre.nom}")
        //La vitesse indique qui commence
        var tourJoueur = this.jeu.joueur.vitesse >= this.monstre.vitesse
        //Tant que le joueur et le monstre sont vivants
        while (this.jeu.joueur.pointDeVie > 0 && monstre.pointDeVie > 0) {
            println("Tours de jeu : ${nombreTours}")
            if (tourJoueur) {
                tourDeJoueur()
            } else {
                tourDeMonstre()
            }
            nombreTours++
            tourJoueur = !tourJoueur // Alternance des tours entre le joueur et le monstre
            println("${this.jeu.joueur.nom}: ${this.jeu.joueur.pointDeVie} points de vie | ${monstre.nom}: ${monstre.pointDeVie} points de vie")
            println("")
        }

        if (this.jeu.joueur.pointDeVie <= 0) {
            println("Game over ! ${this.jeu.joueur.nom} a été vaincu !")
            println("Le combat recommence")

            this.jeu.joueur.pointDeVie = this.jeu.joueur.pointDeVieMax
            this.monstre.pointDeVie = this.monstre.pointDeVieMax
            this.executerCombat()
        } else {
            println("BRAVO ! ${monstre.nom} a été vaincu !")
        }
    }
}