/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pethaven.controller;

import com.pethaven.model.PetModel;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Controller handling ArrayList and Queue logic
 */
public class PetController {
    // Storage for all pets
    private ArrayList<PetModel> petList = new ArrayList<>();
    
    // Queue for the "Recently Added" Requirement
    private Queue<PetModel> recentQueue = new LinkedList<>();

    public void addPet(PetModel pet) {
        petList.add(pet);
        
        // Keep only the last 5 pets in the queue
        if (recentQueue.size() >= 5) {
            recentQueue.poll();
        }
        recentQueue.add(pet);
    }

    public ArrayList<PetModel> getAllPets() {
        return petList;
    }

    public Queue<PetModel> getRecentQueue() {
        return recentQueue;
    }

    public void deletePet(String id) {
        petList.removeIf(p -> p.getId().equals(id));
    }
}