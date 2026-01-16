package com.pethaven.controller;

import com.pethaven.model.PetModel;
import com.pethaven.model.UserModel;
import java.util.ArrayList;
import java.io.*;

public class PetController {

    // ==========================================================
    // 1. SEARCH ALGORITHMS
    // ==========================================================

    /**
     * BINARY SEARCH (Search by ID)
     * Requirement: List MUST be sorted by ID first.
     */
    public int binarySearchByID(ArrayList<PetModel> list, int targetId) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid).getPetId() == targetId) {
                return mid; // Found it!
            } else if (list.get(mid).getPetId() < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // Not found
    }

    // ==========================================================
    // 2. SORTING ALGORITHMS [cite: 2026-01-15]
    // ==========================================================

    /**
     * SELECTION SORT (Sort by ID)
     */
    public void sortByID(ArrayList<PetModel> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getPetId() < list.get(minIdx).getPetId()) {
                    minIdx = j;
                }
            }
            PetModel temp = list.get(i);
            list.set(i, list.get(minIdx));
            list.set(minIdx, temp);
        }
    }

    /**
     * INSERTION SORT (Sort by Name alphabetically)
     */
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

    /**
     * MERGE SORT (Sort by Age)
     */
    public void sortByAge(ArrayList<PetModel> list) {
        if (list.size() <= 1) return;

        int mid = list.size() / 2;
        ArrayList<PetModel> left = new ArrayList<>(list.subList(0, mid));
        ArrayList<PetModel> right = new ArrayList<>(list.subList(mid, list.size()));

        sortByAge(left);
        sortByAge(right);
        merge(list, left, right);
    }

    private void merge(ArrayList<PetModel> list, ArrayList<PetModel> left, ArrayList<PetModel> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getAge() <= right.get(j).getAge()) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) list.set(k++, left.get(i++));
        while (j < right.size()) list.set(k++, right.get(j++));
    }

    // ==========================================================
    // 3. FILE PERSISTENCE (PETS)
    // ==========================================================

    public void savePetsToFile(ArrayList<PetModel> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("pets.txt"))) {
            for (PetModel p : list) {
                bw.write(p.getPetId() + "," + p.getName() + "," + p.getAge() + "," + p.getBreed());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Pet Save Error: " + e.getMessage());
        }
    }

    public ArrayList<PetModel> loadPetsFromFile() {
        ArrayList<PetModel> list = new ArrayList<>();
        File file = new File("pets.txt");
        if (!file.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    list.add(new PetModel(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]), data[3]));
                }
            }
        } catch (Exception e) {
            System.out.println("Pet Load Error: " + e.getMessage());
        }
        return list;
    }

    // ==========================================================
    // 4. FILE PERSISTENCE (USERS)
    // ==========================================================

    public void saveUsersToFile(ArrayList<UserModel> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("users.txt"))) {
            for (UserModel u : list) {
                bw.write(u.getUsername() + "," + u.getPassword());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("User Save Error: " + e.getMessage());
        }
    }

    public ArrayList<UserModel> loadUsersFromFile() {
        ArrayList<UserModel> list = new ArrayList<>();
        File file = new File("users.txt");
        if (!file.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    list.add(new UserModel(data[0], data[1]));
                }
            }
        } catch (Exception e) {
            System.out.println("User Load Error: " + e.getMessage());
        }
        return list;
    }
}