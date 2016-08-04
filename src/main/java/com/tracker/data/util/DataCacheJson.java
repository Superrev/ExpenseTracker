package com.tracker.data.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tracker.data.Expenses;
import com.tracker.data.Test;
import com.tracker.servlets.DatabaseServlet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Superduo on 8/4/16.
 */
public class DataCacheJson {
    private static DataCacheJson instance = null;
    //private static HashMap<String, Test> testHashMap;
    private static HashMap<String, Expenses> expensesHashMap;
    private static Path expensesfilepath = Paths.get("/Users/KevNoall/expenses.json"); //katiebunnell

    private DataCacheJson() {
        // Exists only to defeat instantiation.
    }

    public static synchronized DataCacheJson getInstance() {
        if (instance == null) {
            instance = new DataCacheJson();
        }
        return instance;
    }

    private static void checkLoaded() {
        if (expensesHashMap == null || expensesHashMap.isEmpty()) {
            loadDataCache();
        }
    }

    public static ArrayList<Expenses> getExpenses() {
        checkLoaded();
        return new ArrayList<>(expensesHashMap.values());
    }

    public static Expenses getExpenses(String expenseID) {
        checkLoaded();
        Expenses expenses = null;
        if (expensesHashMap.containsKey(expenseID)) {
            expenses = expensesHashMap.get(expenseID);
        }
        return expenses;
    }

    public static void setExpenses(Expenses expenses) {
        checkLoaded();
        expensesHashMap.put(expenses.getExpenseID() + "", expenses);
        saveAllToFiles();
    }

    public static ArrayList<Test> getAllTests() {
        ArrayList<Test> tests = new ArrayList<>();
        try {
            Connection connection = DatabaseServlet.getConnection();

            Statement stmt = connection.createStatement();
            String query = "SELECT id FROM test";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Test t = new Test(rs.getInt("id"));
                tests.add(t);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return tests;
    }


    private static void saveAllToFiles() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(Files.newOutputStream(expensesfilepath), expensesHashMap);
        } catch (IOException ioe) {
            System.out.println("Issue writing HashMaps to JSON files in DataCacheJson.saveAllToFiles()");
            ioe.printStackTrace();
        }
    }

    private static void loadDataCache() {
        if (!Files.exists(expensesfilepath)) {
            initalLoadDataCache();
            saveAllToFiles();
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            expensesHashMap = mapper.readValue(Files.newInputStream(expensesfilepath), new TypeReference<HashMap<String, Expenses>>() {
            });
        } catch (IOException ioe) {
            System.out.println("Issue reading HashMaps from JSON files in DataCacheJson.loadDataCache()");
            ioe.printStackTrace();
        }
    }

    private static void initalLoadDataCache() {
        expensesHashMap = new HashMap<>();
        //testHashMap = new HashMap<>();
//        String ownerId = System.currentTimeMillis()+"-bd";
//        ownersHashMap.put(ownerId,new Owner(ownerId,"Bob","Denver","801-111-2222","123 Desert Island"));
//
//        String petId = System.currentTimeMillis()+"-n";
//        petsHashMap.put(petId, new Pet(petId,"Nemo",Pet.PetType.FISH,ownerId));
//
//        ownerId = System.currentTimeMillis()+"-jd";
//        ownersHashMap.put(ownerId,new Owner(ownerId,"Jane","Doe","801-333-4444","345 Avenue A."));
//
//        petId = System.currentTimeMillis()+"-k";
//        petsHashMap.put(petId, new Pet(petId,"Kat",Pet.PetType.CAT,ownerId));
//
//        ownerId = System.currentTimeMillis()+"-mc";
//        ownersHashMap.put(ownerId,new Owner(ownerId,"Master","Chief","801-555-6666","678 Halo Way"));
//
//        petId = System.currentTimeMillis()+"-c";
//        petsHashMap.put(petId, new Pet(petId,"Cortana",Pet.PetType.BIRD,ownerId));
//
//        ownerId = System.currentTimeMillis()+"-sc";
//        ownersHashMap.put(ownerId,new Owner(ownerId,"Santa","Clause","801-777-8888","1 North Pole"));
//
//        petId = System.currentTimeMillis()+"-r";
//        petsHashMap.put(petId, new Pet(petId,"Rudolph",Pet.PetType.DOG,ownerId));
//    }
    }
}
