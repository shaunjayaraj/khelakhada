package main;

import java.util.List;

/**
 * Created by jshanmug on 24/07/15.
 */
public class InputValidator {

    private CategoryService categoryservice;

    public InputValidator(CategoryService cs) {
        categoryservice = cs;
    }


    public void getJSONForInputString(String args[])
    {
        for(String input : args)
        {
            if(isValidValue(input))
            {
                
            }
        }
    }

    public boolean isValidValue(String input) {


        for(List<String> categories : categoryservice.getCategoriesAndValue().values())
        {
            for(String value : categories)
            {
                if(value == input)
                {
                    return true;
                }
            }
        }
        return false;
    }

}
