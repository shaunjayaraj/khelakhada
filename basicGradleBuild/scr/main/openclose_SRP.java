package main;


import java.util.ArrayList;

import java.util.List;


public class openclose_SRP {

    static CategoryService categoryService;

    public static void main(String args[])
    {
        categoryService = new CategoryServiceImpl();
        List<String> properties = new ArrayList<String>();

        for(String arg : args)
        {
            if(!isValidValue(arg)) {
                System.out.println("invalid inputs: " + arg);
                System.exit(0);
            }

            properties.add(arg);
        }
        for(Bird bird : categoryService.findPotentialMatches(properties))
        {
            System.out.println(bird.getName());
        }
        System.exit(0);

    }

    public static boolean isValidValue(String input) {


        for(List<String> categories : categoryService.getCategoriesAndValue().values())
        {
            for(String value : categories)
            {
                if(value.compareToIgnoreCase(input) == 0)
                {
                    return true;
                }
            }
        }
        return false;
    }
}


