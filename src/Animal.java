public class Animal {
    private String family;
    public String name;
    private int age;
    private boolean isMammal;

    public Animal(String family,String name,int age,boolean isMammal){
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
