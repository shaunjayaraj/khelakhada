package main;

/**
 * Created by jshanmug on 09/08/15.
 */
public class Bird {

    private String color;
    private String type;
    private String habitat;

    public String getName() {
        return name;
    }

    private String name;

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public String getHabitat() {
        return habitat;
    }

    public Bird(String Name, String Color, String Type, String Habitat)
    {
        name = Name;
        color = Color;
        type = Type;
        habitat = Habitat;
    }


}
