package tn.esprit.gestionZoo.entities;

public class Aquatic extends Animal{
private String habitat;

public Aquatic(){
    //System.out.println("Aquatic created");
};

    public Aquatic(String family, String name, int age, boolean isMammal,String habitat) {
        super(family, name, age, isMammal);
        this.habitat=habitat;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    @Override
    public String toString() {
        return "Aquatic{" +
                "habitat='" + habitat + '\'' +
                '}'+super.toString();
    }

    public void swim(){
        System.out.println("This aquatic animal is swimming.");
    }


}