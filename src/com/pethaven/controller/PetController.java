package com.pethaven.controller;
import com.pethaven.model.PetModel;
import java.util.ArrayList;

public class PetController {
    
    // 1. SELECTION SORT (Sort by ID) [cite: 2026-01-15]
    public void sortByID(ArrayList<PetModel> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getPetId() < list.get(minIdx).getPetId()) {
                    minIdx = j;
                }
            }
            PetModel temp = list.get(minIdx);
            list.set(minIdx, list.get(i));
            list.set(i, temp);
        }
    }
    
    // 2. INSERTION SORT (Sort by Name) [cite: 2026-01-15]
    public void sortByName(ArrayList<PetModel> list) {
        for (int i = 1; i < list.size(); i++) {
            PetModel key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).getName().compareToIgnoreCase(key.getName()) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }
}