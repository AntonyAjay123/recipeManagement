package com.example.recipeManagement.controller;

import com.example.recipeManagement.dao.RecipeRepository;
import com.example.recipeManagement.model.Recipe;
import com.example.recipeManagement.service.RecipeService;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/recipe")
public class RecipeController {
    @Autowired
    RecipeService recipeService;

    @PostMapping
    public ResponseEntity saveRecipe(@Valid @RequestBody Recipe recipe, Errors errors){
        JSONObject json = new JSONObject(recipe);
       //List<String> errors = recipeService.checkRecipe(json);
        if(errors.hasErrors()){
            return new ResponseEntity(errors.toString(),HttpStatus.BAD_REQUEST);
        }
        else {
            int id = recipeService.saveRecipe(recipe);
            return new ResponseEntity("recipe saved with id " + id, HttpStatus.CREATED);
        }
    }

    @GetMapping
    public ResponseEntity getRecipe(@Nullable @RequestParam Integer id){
        if(id==null)
            return new ResponseEntity(recipeService.getAll(),HttpStatus.OK);
        else{
            return recipeService.findId(id);
        }
    }

    @DeleteMapping
    public ResponseEntity deleteRecipe(@RequestParam int id){
        return recipeService.deleteId(id);
    }

    @PutMapping
    public ResponseEntity updateRecipe(@RequestBody Recipe recipe){
        return recipeService.updateRecipe(recipe);
    }
}
