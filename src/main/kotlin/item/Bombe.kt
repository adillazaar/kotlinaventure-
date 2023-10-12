package item
import jeu.TirageDes
import personnage.Personnage


class Bombe(nom:String, val nombreDes: Int, val valeurDeMax: Int, description:String,):Item(nom,description)

{
    override fun utiliser(cible: Personnage){
        val tirage = TirageDes(nombreDes,valeurDeMax)
        val degatbombe = tirage.lance()
        val protectionCible = cible.calculeTotalDefense()
        val degatFinaux = maxOf(degatbombe - protectionCible, 1)


        cible.pointDeVie -= degatFinaux

        println("vous avez perdu $degatFinaux")


}
}
