package test;


import org.junit.Test;
import org.junit.Assert;
import static org.mockito.Mockito.*;
import main.*;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jshanmug on 24/07/15.
 */
public class TestinputValidatorTest {

    @Test
    public void testisValidValueReturnTrueOnValidValues()
    {
        List<String> colors = new ArrayList<String>();
        colors.add("rufus");
        colors.add("yellow");
        colors.add("brown");
        colors.add("black");

        HashMap<String, List<String>> categoriesAndvalues = new HashMap<String, List<String>>();
        categoriesAndvalues.put("color", colors);

        CategoryService mockedService = mock(CategoryService.class);

        //when(mockedService.getValuesForCategory("color")).thenReturn(colors);
        when(mockedService.getCategoriesAndValue()).thenReturn(categoriesAndvalues);

        InputValidator validator = new InputValidator(mockedService);

        Assert.assertTrue(validator.isValidValue("brown"));


    }

}