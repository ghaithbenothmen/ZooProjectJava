package tn.esprit.gestionZoo.main;
import tn.esprit.gestionZoo.entities.*;

import static tn.esprit.gestionZoo.entities.Zoo.countAnimalCree;
import static tn.esprit.gestionZoo.entities.Zoo.countAquaticCree;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ZooManagment {

    public static void main(String[] args) {

        /***************************Create Instance Animal****************************/
        Animal lion=new Animal("cat","Simba",10,true); //ajouter dans tableau
        //lion.displayAnimal();
        Animal tigre=new Animal("cat","mimi",2,true); //ajouter dans tableau
        //tigre.displayAnimal();
        Animal mimi=new Animal("cato","mimo",3,true); //n'est pas dans tableau

        Animal aniNeg=new Animal("nega","nego",-3,true); //n'est pas dans tableau

        /***************************Create Instance Zoo****************************/
        Zoo bilvidaire=new Zoo(10,"bilvidaire","tunis");
        Zoo Africa=new Zoo(24,"Africa","bizert");
        //System.out.println(bilvidaire.toString());  //display with methode toString
        //System.out.println(bilvidaire);           //we can also display it with appel Classname

                                    //Compare 2 zoo
        Zoo zooWithMoreAnimals = Zoo.comparerZoo(bilvidaire, Africa);
        System.out.println("Zoo a plus d'animaux est: " + zooWithMoreAnimals.getName());



        /***************************Add annimal with static methode****************************/
       // FullAnimal(tigre, bilvidaire);
        //FullAnimal(mimi, bilvidaire);
        //FullAnimal(lion, bilvidaire); //declarer fonction static

        try {
            bilvidaire.addAnimal(tigre);
            System.out.println("Number of animals in the zoo: " + bilvidaire.getCountAnimalCree());
            bilvidaire.addAnimal(aniNeg);


            System.out.println("Number of animals in the zoo: " + bilvidaire.getCountAnimalCree());
        } catch (ZooFullException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }


        /*************************** Show Animal table after delet************************************/
        boolean removed = bilvidaire.removeAnimal(lion);
        if (removed) {
            System.out.println("L'annimal "+lion.getName()+"a été supprimé du zoo.");
            System.out.println("Animaux dans le zoo après la suppression :");
            System.out.println(bilvidaire);
        } else {
            System.out.println("L'animal n'a pas pu être trouvé ou supprimé du zoo.");
        }


        /******************************** Prosit 5 : heritage **********************************/
        /******************************** instance Avec Heritage **********************************/

        /******************************************Default instance **************************************************/
        Dolphin dolphin=new Dolphin();
        Penguin penguin=new Penguin();
        Aquatic aquatic =new Aquatic();
        //Terrestrial terrestrial=new Terrestrial();

        /****************************************** instance charge**************************************************/
        Dolphin dolphinParam=new Dolphin("Dophin","boubou",2,true,"habitat",33);
        Dolphin dolphinParam2=new Dolphin("Dophin","boubou",2,true,"habitat",37);
        Dolphin dolphinParam3=new Dolphin("Dophin","laboon",2,false,"habitat",30);

        Penguin penguinParam =new Penguin("Penguin","penpen",3,true,"habitat",30);
        Aquatic aquaticParam = new Aquatic("Family","penpen",4,true,"habitat");
        //Terrestrial terrestrialParam= new Terrestrial("Terrestrial","tererstre",5,true,4);


        /********************************Methode with heritage **************************************************/
        System.out.println(dolphinParam);
        System.out.println(penguinParam);


       // dolphinParam.swim();
       // penguinParam.swim();
        aquaticParam.swim();

        /******************************** Prosit 6  **********************************/
        /**************************Add aquatic animal ***********************/
        FullAquaticAnimal(dolphinParam,bilvidaire);
        FullAquaticAnimal(penguinParam,bilvidaire);
        //int sommeAnimals=countAnimalCree+countAquaticCree;
        System.out.println("nbr annimals cree:"+ countAnimalCree);

        // Appel de la méthode showAllswim pour afficher la méthode swim() de tous les animaux aquatiques
        bilvidaire.showAllswim();//on remarque dans la classe penguin le resultat est this aquatic animal is swiming


        System.out.println("Max Penguin Swimming Depth : "+bilvidaire.maxPenguinSwimmingDepth());
        bilvidaire.displayNumberOfAquaticsByType();//nombre des dolphin et des penguins

        /************************ Use Equals ************************/
        System.out.println(dolphinParam3.equals(dolphinParam));
        System.out.println(dolphinParam2.equals(dolphinParam));


    }




    /******************************************Static main methode for adding annimal **************************************************/
   /* private static void FullAnimal(Animal annimal, Zoo bilvidaire) {
        if (!bilvidaire.isZooFull()) {
            boolean addAni2=bilvidaire.addAnimal(annimal);
            if (addAni2){
                System.out.println("l'annimal "+annimal.getName()+" est ajouté");
            }else {
                System.out.println("l'annimal "+annimal.getName()+" exist déja ou zoo complet ");
            }
        }else{
            System.out.println("Le zoo est plein. Impossible d'ajouter un nouvel animal.");
        }



    }

    */

    private static void FullAquaticAnimal(Aquatic annimal, Zoo bilvidaire) {
        if (!bilvidaire.isZooFull()) {
            boolean addAni2=bilvidaire.addAquaticAnimal(annimal);
            if (addAni2){
                System.out.println("l'annimal aquatic "+annimal.getName()+" est ajouté");
            }else {
                System.out.println("Impossible d'ajouter un aquatic,le nombre maximum des animals aquatique sont 10");
            }
        }else{
            System.out.println("Le zoo est plein. Impossible d'ajouter un nouvel animal.");
        }



    }

}