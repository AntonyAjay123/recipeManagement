package com.example.recipeManagement.service;

import com.example.recipeManagement.dao.RecipeRepository;
import com.example.recipeManagement.model.Recipe;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    public int saveRecipe(Recipe recipe){
        recipeRepository.save(recipe);
        return recipe.getId();
    }

    public List<Recipe> getAll(){
        return recipeRepository.findAll();
    }

    public ResponseEntity findId(int id){
        if(recipeRepository.findById(id).isPresent())
            return new ResponseEntity(recipeRepository.findById(id).get(), HttpStatus.OK);
        else return new ResponseEntity("enter valid id",HttpStatus.BAD_REQUEST);
    }
     public  ResponseEntity deleteId(int id){
         if(!recipeRepository.findById(id).isPresent())
             return new ResponseEntity("enter valid id",HttpStatus.BAD_REQUEST);
         else{
             recipeRepository.deleteById(id);
             return new ResponseEntity("Recipe deleted",HttpStatus.ACCEPTED);
         }
     }

    public List<String> checkRecipe(JSONObject recipe){
        List<String> errors = new ArrayList<>();
        if(!recipe.has("name"))
            errors.add("enter name of recipe");
        if(!recipe.has("instructions"))
            errors.add("enter instructions");
        if(!recipe.has("ingredients"))
            errors.add("ingredients");
        return errors;
    }

    public ResponseEntity updateRecipe(Recipe recipe){
        Integer id= recipe.getId();
        String output="";
        if(id==null)return new ResponseEntity("id cannot be null",HttpStatus.BAD_REQUEST);
        else{
            log.info(id+"");
           if(!recipeRepository.findById(id).isPresent())
               return new ResponseEntity("enter valid id",HttpStatus.BAD_REQUEST);
           Recipe existing = recipeRepository.findById(id).get();
            if(recipe.getName()!=null)
                existing.setName(recipe.getName());
            if(recipe.getInstructions()!=null)
                existing.setInstructions(recipe.getInstructions());
            if(recipe.getIngredients()!=null)
                existing.setIngredients(recipe.getIngredients());
            recipeRepository.save(existing);
            return new ResponseEntity("Updated successfully",HttpStatus.OK);
        }
    }
}
