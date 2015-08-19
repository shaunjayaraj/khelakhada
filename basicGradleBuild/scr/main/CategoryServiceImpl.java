package main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.BufferedReader;

/**
 * Created by jshanmug on 25/07/15.
 */
public class CategoryServiceImpl implements CategoryService {

    private HashMap<String, List<String>> categoriesAndValues;
    private List<String> values;

    public CategoryServiceImpl()
    {
        categoriesAndValues = new HashMap<String, List<String>>();
        values = new ArrayList<String>();

        List<String> colors = new ArrayList<String>();
        colors.add("black");
        colors.add("brown");
        colors.add("rufus");
        colors.add("yellow");
        colors.add("purple");

        List<String> habitat = new ArrayList<String>();
        habitat.add("water");
        habitat.add("arboreal");
        habitat.add("ariel");

        List<String> type = new ArrayList<String>();
        type.add("predator");
        type.add("sunbird");
        type.add("waterfowl");

        categoriesAndValues.put("color", colors);
        categoriesAndValues.put("habitat",habitat);
        categoriesAndValues.put("type",type);


    }
    @Override
    public HashMap<String, List<String>> getCategoriesAndValue() {
        return categoriesAndValues;
    }

    @Override
    public List<Bird> findPotentialMatches (List<String> properties)
    {
        List<Bird> ListOfAllBirds = loadAllBirds();
        List<Bird> identifiedBirds = new ArrayList<Bird>();

        for (Bird bird : ListOfAllBirds)
        {
            for(String property : properties)
            {
                if(bird.getColor().compareToIgnoreCase(property) == 0 || bird.getHabitat().compareToIgnoreCase(property) ==0 || bird.getType().compareToIgnoreCase(property) == 0)
                {
                    identifiedBirds.add(bird);
                }

            }

        }

        return identifiedBirds;

    }

    private List<Bird> loadAllBirds()
    {
        BufferedReader br = null;
        ArrayList<Bird> birds = new ArrayList<Bird>();

        try {

            String sCurrentLine;

            URL url = getClass().getResource("Birds.txt");
            File file = new File(url.getPath());

            br = new BufferedReader(new FileReader(file));

            while ((sCurrentLine = br.readLine()) != null) {
                String[] split = sCurrentLine.split(";");
                if(split.length == 4) {
                    Bird bird = new Bird(split[0], split[1], split[3], split[2]);
                    birds.add(bird);
                }
                System.out.println(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return birds;
    }



}
