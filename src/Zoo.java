import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Zoo {
    public Animal[] animals;
    public String name;
    public String city;
    public final int nbrCages=25;
 private int nbrAnimaux;

     static int countAnimalCree=0;


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

            if (animals.length>countAnimalCree && (searchAnimal(animal)==-1) ){
                    animals[countAnimalCree] = animal;
                countAnimalCree++;

                    return true;
            }
        return false;
    }

    public int searchAnimal(Animal animal) {
        for (int i = 0; i < countAnimalCree; i++) {
            if (animal.name.equals(animals[i].name) ) {
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
