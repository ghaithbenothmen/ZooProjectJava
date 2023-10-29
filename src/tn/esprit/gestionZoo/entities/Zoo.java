package tn.esprit.gestionZoo.entities;

public class Zoo {
    private Animal[] animals;

    private Aquatic[] aquaticAnimals;
    private String name;
    private String city;
    private final int nbrCages=3;
    private int nbrAnimaux;

    public static int countAnimalCree=0;
    public static int countAquaticCree=0;


    public Aquatic[] getAquaticAnimals() {
        return aquaticAnimals;
    }

    public void setAquaticAnimals(Aquatic[] aquaticAnimals) {
        this.aquaticAnimals = aquaticAnimals;
    }

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
        this.aquaticAnimals=new Aquatic[10];

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
    public void addAnimal(Animal animal) throws ZooFullException ,InvalidAgeException {
        if (isZooFull()) {
            throw new ZooFullException("zoo est plein. Cannot add more animals.");
        }
        if (animal.getAge() < 0) {
            throw new InvalidAgeException("Invalid age. Age cannot be negative.");
        }
            if (animals.length>countAnimalCree && (searchAnimal(animal)==-1)){
                    animals[countAnimalCree] = animal;
                    countAnimalCree++;
                System.out.println("annimal bien ajouter au zoo");
            }

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
            return z1;}
        else if (z1.nbrAnimaux< z2.nbrAnimaux) {
            return z2;
        }
      return z2;
  }

    public boolean addAquaticAnimal(Aquatic aquatic) {

        if (countAquaticCree<aquaticAnimals.length &&(!isZooFull())){
            aquaticAnimals[countAquaticCree] = aquatic;
            countAquaticCree++;
            countAnimalCree++;
            return true;
        }

        return false;
    }

    public void showAllswim(){
        for(int i=0;i<countAquaticCree;i++){
            aquaticAnimals[i].swim();
        }
    }

    public float maxPenguinSwimmingDepth(){
        float maxDepth=-1;
        for(int i=0;i<countAquaticCree;i++){
            if(aquaticAnimals[i] instanceof Penguin){
                Penguin penguin = (Penguin) aquaticAnimals[i];
                if((penguin.getSwimmingDepth() > maxDepth)) {
                    maxDepth = ((Penguin) aquaticAnimals[i]).getSwimmingDepth();
                }
            }
        }
        return maxDepth;
    }

    public void displayNumberOfAquaticsByType(){
        int nbrDolphin=0;
        int nbrPenguin=0;
        for(int i=0;i<countAquaticCree;i++){
            if (aquaticAnimals[i] instanceof Dolphin){
                nbrDolphin++;
            }else {
                nbrPenguin++;
            }
        }
        System.out.println("le nombre des Dolphin est :"+nbrDolphin);
        System.out.println("le nombre des penguins est :"+nbrPenguin);
    }
}
