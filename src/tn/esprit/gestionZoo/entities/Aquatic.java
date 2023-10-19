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
        return super.toString()+
                "\n habitat=" + habitat ;
    }

    public void swim(){
        if (this instanceof Penguin){
            System.out.println("This Penguin animal is swimming.");
        } else if (this instanceof Dolphin) {
            System.out.println("This Dolphin animal is swimming.");
        } else {
            System.out.println("This Aquatic animal is swimming.");
        }

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
           return true;
        }

        if(this == null){
            return false;
        }

        //getClass() lors de l'execution il va considerer que l'obj est Dolphin ou Penguin
        //if(obj.getClass() == Aquatic.class){
            //instance of donc il va considerer que obj est Aquatic
            if(obj instanceof  Aquatic){
            Aquatic aquatic=(Aquatic) obj;
            return  aquatic.getName()==this.getName() && aquatic.getAge()==this.getAge() && aquatic.habitat==this.habitat;
        }
        return false;


    }
}
