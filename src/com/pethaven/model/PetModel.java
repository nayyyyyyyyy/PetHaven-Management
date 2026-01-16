package com.pethaven.model;

/**
 * PetModel class to store pet data.
 * Used for Selection, Insertion, Merge Sort, and Binary Search [cite: 2026-01-15].
 */
public class PetModel {
    private int petId;
    private String name;
    private int age;
    private String breed;

    public PetModel(int petId, String name, int age, String breed) {
        this.petId = petId;
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    // --- GETTERS ---
    // Necessary for Sort and Search algorithms [cite: 2026-01-15]
    
    public int getPetId() { 
        return petId; 
    }
    
    public String getName() { 
        return name; 
    }
    
    public int getAge() { 
        return age; 
    }
    
    public String getBreed() { 
        return breed; 
    }

    // --- SETTERS ---
    // Necessary for the "Update" CRUD operation
    
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public void setPetId(int petId) {
        this.petId = petId;
    }
    
    public void setBreed(String breed) {
        this.breed = breed;
    }
}