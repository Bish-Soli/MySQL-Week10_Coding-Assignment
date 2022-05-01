package entity;

public class Fruit {
    private  final int fruitId;
    private  final String name;
    private final  String scientific_name;

    public Fruit(int fruitId ,  String name , String scientific_name)
    {
        this.fruitId = fruitId;
        this.name = name;
        this.scientific_name = scientific_name;
    }

    public int getFruitId() {
        return fruitId;
    }



    public String getName() {
        return name;
    }



    public String getScientific_name() {
        return scientific_name;
    }


}
