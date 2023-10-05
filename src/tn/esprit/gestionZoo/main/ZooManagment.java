package tn.esprit.gestionZoo.main;
import tn.esprit.gestionZoo.entities.*;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ZooManagment {

    public static void main(String[] args) {

        Animal lion=new Animal("cat","Simba",10,true); //ajouter dans tableau
        //lion.displayAnimal();

        Animal tigre=new Animal("cat","mimi",2,true); //ajouter dans tableau
        //tigre.displayAnimal();


        Animal mimi=new Animal("cato","mimo",3,true); //n'est pas dans tableau


      Zoo bilvidaire=new Zoo(20,"bilvidaire","tunis");
        Zoo Africa=new Zoo(24,"Africa","bizert");

        //System.out.println(bilvidaire.toString());  //display with methode toString
        //System.out.println(bilvidaire);           //we can also display it with appel Classname

        Zoo zooWithMoreAnimals = Zoo.comparerZoo(bilvidaire, Africa);

        System.out.println("Zoo a plus d'animaux est: " + zooWithMoreAnimals.getName());


        FullAnimal(tigre, bilvidaire);

        FullAnimal(lion, bilvidaire); //declarer fonction static

        /*boolean addAni3=bilvidaire.addAnimal(lion);
        if (addAni3){
            System.out.println("l'annimal "+mimi.name+"est ajouté");
        }else {
            System.out.println("l'annimal "+mimi.name+" exist déja ou zoo complet ");
        }*/


        boolean removed = bilvidaire.removeAnimal(lion);
        if (removed) {
            System.out.println("L'annimal "+lion.getName()+"a été supprimé du zoo.");
            System.out.println("Animaux dans le zoo après la suppression :");
            System.out.println(bilvidaire);
        } else {
            System.out.println("L'animal n'a pas pu être trouvé ou supprimé du zoo.");
        }


     /*   boolean full=bilvidaire.isZooFull();
        if (full) {
            System.out.println("La Zoo est plein.");
        } else {
            System.out.println("Vous pouvez ajoutez autres animaux.");
        }*/


    }

    private static void FullAnimal(Animal lion, Zoo bilvidaire) {
        if (!bilvidaire.isZooFull()) {
            boolean addAni2=bilvidaire.addAnimal(lion);
            if (addAni2){
                System.out.println("l'annimal "+lion.getName()+" est ajouté");
            }else {
                System.out.println("l'annimal "+lion.getName()+" exist déja ou zoo complet ");
            }
        }else{
            System.out.println("Le zoo est plein. Impossible d'ajouter un nouvel animal.");
        }


    }



}