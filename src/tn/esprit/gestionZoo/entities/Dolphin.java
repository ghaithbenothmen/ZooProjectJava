package tn.esprit.gestionZoo.entities;

public class Dolphin extends Aquatic{
    private float swimmingSpeed;

    public Dolphin(){

        System.out.println("doolphin created");
    };
    public Dolphin(String family, String name, int age, boolean isMammal, String habitat,float swimmingSpeed) {
        super(family, name, age, isMammal, habitat);
        this.swimmingSpeed=swimmingSpeed;
    }

    public float getSwimmingSpeed() {
        return swimmingSpeed;
    }

    public void setSwimmingSpeed(float swimmingSpeed) {
        this.swimmingSpeed = swimmingSpeed;
    }

    @Override
    public String toString() {
        return super.toString()+" \nswimmingSpeed=" + swimmingSpeed ;
    }


    @Override
    public void swim(){
        System.out.println("This Dolphin animal is swimming.");
    }

}
