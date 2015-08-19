package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jshanmug on 24/07/15.
 */
public interface CategoryService {
    HashMap<String,List<String>> getCategoriesAndValue();
    List<Bird> findPotentialMatches (List<String> p);
}
