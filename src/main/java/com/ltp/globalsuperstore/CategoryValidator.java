package com.ltp.globalsuperstore;

import java.util.HashMap;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryValidator implements ConstraintValidator<Category, String> {
    private HashMap<String,Integer> categories;
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        this.categories = fillcategory();
        return categories.get(value) != null;
    }
    private HashMap<String,Integer> fillcategory(){
        String[] categoriesConst = Constants.CATEGORIES;
        HashMap<String,Integer> categoriesFinal = new HashMap<>();
        for(int i = 0;i<=(categoriesConst.length-1);i++){
            categoriesFinal.put(categoriesConst[i],i);
        }
        return categoriesFinal;
    }
    
}
