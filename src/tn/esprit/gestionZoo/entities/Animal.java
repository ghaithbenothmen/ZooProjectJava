package tn.esprit.gestionZoo.entities;

public class Animal {
    private String family;
    private String name;
    private int age;
    private boolean isMammal;

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age<0){
            System.out.println("l'age ne doit pas etres negatif");
        }
        this.age = age;
    }

    public boolean isMammal() {
        return isMammal;
    }

    public void setMammal(boolean mammal) {
        isMammal = mammal;
    }

    public Animal(){};
    public Animal(String family, String name, int age, boolean isMammal){
        this.family=family;
        this.name=name;
        this.age=age;
        this.isMammal=isMammal;

    }

    public void displayAnimal(){
        System.out.println("Animal : \n" +
                " name :" +name
                +"\n family :"+
                family+"\n age :"
                +age+"\n isMammal :"
                +isMammal);
    }
    public void MakeSound(){
        System.out.println("ghvgffy");
    }

    @Override
    public String toString(){
        return  "\nAnimal : \n" +
                " name :" +name
                +"\n family :"+
                family+"\n age :"
                +age+"\n isMammal :"
                +isMammal ;
    }
}
