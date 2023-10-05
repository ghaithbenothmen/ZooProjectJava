package tn.esprit.gestionZoo.entities;

public class Zoo {
    private Animal[] animals;
    private String name;
    private String city;
    private final int nbrCages=25;
 private int nbrAnimaux;

     static int countAnimalCree=0;

    public Animal[] getAnimals() {
        return animals;
    }

    public void setAnimals(Animal[] animals) {
        this.animals = animals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()){
            System.out.println("le nom ne doit pas etre vide !");
        }
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNbrCages() {
        return nbrCages;
    }

    public int getNbrAnimaux() {
        return nbrAnimaux;
    }

    public void setNbrAnimaux(int nbrAnimaux) {
        this.nbrAnimaux = nbrAnimaux;
    }

    public static int getCountAnimalCree() {
        return countAnimalCree;
    }

    public static void setCountAnimalCree(int countAnimalCree) {
        Zoo.countAnimalCree = countAnimalCree;
    }

    public Zoo(int nbrAnimaux, String name, String city) {
        this.animals = new Animal[nbrAnimaux];


        this.name = name;
        this.city = city;



    }


    @Override
    public String toString() {
        String v = "Zoo{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", nbrCages=" + nbrCages +
                ", nbrAnimaux=" + animals.length +
                '}'+ "\n Tab animals :[";
        StringBuilder c = new StringBuilder(" ");
        for(int i =0;i<countAnimalCree;i++){
            c.append(animals[i].toString()).append("  ");

        }

        return  v + "  "+ c +"]";


    }
    public boolean addAnimal(Animal animal) {

            if (animals.length>countAnimalCree && (searchAnimal(animal)==-1)&&(!isZooFull()) ){
                    animals[countAnimalCree] = animal;
                countAnimalCree++;

                    return true;
            }
        return false;
    }

    public int searchAnimal(Animal animal) {
        for (int i = 0; i < countAnimalCree; i++) {
            if (animal.getName().equals(animals[i].getName()) ) {
                return i;
            }
        }
        return -1;
    }
//la redefinition reutiliser fontion heriter de class(comme tostring from class objet)
public boolean removeAnimal(Animal animal) {
    int indexAnimal = searchAnimal(animal);
    if (indexAnimal == -1)
        return false;
    for (int i = indexAnimal; i < countAnimalCree; i++) {
        animals[i] = animals[i + 1];
        animals[countAnimalCree] = null;
        countAnimalCree--;
    }
    return true;
}

public boolean isZooFull(){
        if (animals.length>=nbrCages){
            return true;
        }
        return false;
}
  public static Zoo comparerZoo(Zoo z1, Zoo z2){
        if(z1.nbrAnimaux> z2.nbrAnimaux){
            return z1;} else if (z1.nbrAnimaux< z2.nbrAnimaux) {
            return z2;
        }
      return z2;
  }

}
