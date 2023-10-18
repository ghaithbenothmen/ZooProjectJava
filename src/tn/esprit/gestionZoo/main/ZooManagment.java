package tn.esprit.gestionZoo.main;
import tn.esprit.gestionZoo.entities.*;
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



        /***************************Create Instance Zoo****************************/
        Zoo bilvidaire=new Zoo(20,"bilvidaire","tunis");
        Zoo Africa=new Zoo(24,"Africa","bizert");
        //System.out.println(bilvidaire.toString());  //display with methode toString
        //System.out.println(bilvidaire);           //we can also display it with appel Classname
                                    //Compare 2 zoo
        Zoo zooWithMoreAnimals = Zoo.comparerZoo(bilvidaire, Africa);
        System.out.println("Zoo a plus d'animaux est: " + zooWithMoreAnimals.getName());



        /***************************Add annimal with static methode****************************/
        FullAnimal(tigre, bilvidaire);
        FullAnimal(lion, bilvidaire); //declarer fonction static


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
        Penguin penguinParam =new Penguin("Penguin","penpen",3,true,"habitat",30);
        Aquatic aquaticParam = new Aquatic("Family","penpen",4,true,"habitat");
        //Terrestrial terrestrialParam= new Terrestrial("Terrestrial","tererstre",5,true,4);


        /********************************Methode with heritage **************************************************/
        System.out.println(dolphinParam);
        System.out.println(penguinParam);

        FullAnimal(dolphinParam, bilvidaire);
        FullAnimal(aquaticParam, bilvidaire);
        FullAnimal(aquaticParam, bilvidaire);

        dolphinParam.swim();
        penguinParam.swim();
        aquaticParam.swim();
    }





    /******************************************Static main methode for adding annimal **************************************************/
    private static void FullAnimal(Animal annimal, Zoo bilvidaire) {
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



}