package com.example.recipeManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.json.JSONArray;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NotNull(message = "name must not be null")
    String name;

    @NotEmpty(message = "instructions cannot be null")
    List<String> instructions;

    @NotNull(message = "ingredients cannot be null")
    List<String> ingredients;

    @CreationTimestamp
    Date createdDate;

    @UpdateTimestamp
    Date updatedDate;
}
