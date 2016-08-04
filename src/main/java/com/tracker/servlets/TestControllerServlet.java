package com.tracker.servlets;

import com.tracker.data.Expenses;
import com.tracker.data.Test;
import com.tracker.data.util.DataCacheJson;
//import com.tracker.data.util.TestDataUtil;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.ArrayList;

import static com.tracker.data.util.TestDataUtil.getAllTests;

public class TestControllerServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        String uri = request.getRequestURI();
        System.out.println("Requested URI: " + uri);

        String jspName = uri.substring(uri.lastIndexOf('/') + 1);
        System.out.println("JSP Name: " + jspName);

        if (jspName.equalsIgnoreCase("viewAllTestData")) {
            ArrayList<Test> tests =getAllTests();
            request.setAttribute("tests", tests);

        } else if (jspName.equalsIgnoreCase("viewTestData")) {
            String testId = request.getParameter("id");
            Test test = new Test(Integer.parseInt(testId));
            request.setAttribute("test", test);

        } else if (jspName.equalsIgnoreCase("addNewExpense")) {
            request.setAttribute("CategoryTypes", Expenses.CategoryType.values());

        }else if (jspName. equalsIgnoreCase("viewAllExpenses")) {
            ArrayList<Expenses> expenses = DataCacheJson.getExpenses();
            request.setAttribute("Expenses", expenses);

        } else if (jspName.equalsIgnoreCase("viewExpense")) {
            String expenseID = request.getParameter("expenseID");
            Expenses expenses = DataCacheJson.getExpenses(expenseID);
            request.setAttribute("expenses",expenses);


        } else if (jspName.equalsIgnoreCase("editExpense")) {
                String expenseID = request.getParameter("expenseid");
                Expenses expenses = DataCacheJson.getExpenses(expenseID);
                request.setAttribute("expenses", expenses);

        } else if (jspName.equalsIgnoreCase("saveNewExpense")){
            Expenses saveNewExpense = new Expenses();
            saveNewExpense.setExpenseAmount(request.getParameter("expenseamont"));
            saveNewExpense.setExpenseName(request.getParameter("expensename"));
            saveNewExpense.setExpenseDate(request.getParameter("expensedate"));
            saveNewExpense.setCategoryType(Expenses.CategoryType.valueOf(request.getParameter("categorytype")));
            saveNewExpense.setExpenseID(System.currentTimeMillis()+"-"+saveNewExpense.getExpenseName().charAt(0));
            DataCacheJson.setExpenses(saveNewExpense);
            jspName = "viewAllPets";

        } else if (jspName.equalsIgnoreCase("updateExpense")) {
            String expenseID = request.getParameter("expenseID");
            Expenses updateExpenses = DataCacheJson.getExpenses(expenseID);
            updateExpenses.setExpenseID(request.getParameter("expenseID"));
            updateExpenses.setExpenseName(request.getParameter("expensename"));
            updateExpenses.setCategoryType(Expenses.CategoryType.valueOf(request.getParameter("categorytype")));
            updateExpenses.setExpenseAmount(request.getParameter("expenseamount"));
            updateExpenses.setExpenseDate(request.getParameter("expensedate"));
            DataCacheJson.setExpenses(updateExpenses);
            jspName = "viewAllExpenses";
        }


        RequestDispatcher view = request.getRequestDispatcher("/testViews/" + jspName + ".jsp");

        view.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }
}


//            // TODO: do something here
//        } else if (jspName.equalsIgnoreCase("addNewPet")) {
//            request.setAttribute("petTypes", Pet.PetType.values());
//
//        } else if (jspName.equalsIgnoreCase("editPet")) {
//            String petId = request.getParameter("petid");
//            Pet pet = DataCacheJson.getPet(petId);
//            request.setAttribute("pet",pet);
//
//        } else if (jspName.equalsIgnoreCase("viewAllOwners")) {
//            ArrayList<Owner> owners = DataCacheJson.getOwners();
//            request.setAttribute("owners",owners);
//            // TODO: do something here
//        } else if (jspName.equalsIgnoreCase("viewOwner")) {
//            String ownerId = request.getParameter("ownerid");
//            Owner owner = DataCacheJson.getOwner(ownerId);
//            request.setAttribute("owner",owner);
//
//        } else if (jspName.equalsIgnoreCase("addNewOwner")) {
//
//        } else if (jspName.equalsIgnoreCase("editOwner")) {
//            String ownerId = request.getParameter("ownerid");
//            Owner owner = DataCacheJson.getOwner(ownerId);
//            request.setAttribute("owner",owner);
//
//        } else if (jspName.equalsIgnoreCase("saveNewOwner")) {
//            Owner saveNewOwner = new Owner();
//            saveNewOwner.setFirstName(request.getParameter("firstname"));
//            saveNewOwner.setLastName(request.getParameter("lastname"));
//            saveNewOwner.setPhone(request.getParameter("phone"));
//            saveNewOwner.setAddress(request.getParameter("address"));
//            saveNewOwner.setOwnerId(System.currentTimeMillis()+"-"+saveNewOwner.getFirstName().charAt(0)+saveNewOwner.getLastName().charAt(0));
//            DataCacheJson.setOwner(saveNewOwner);
//            jspName = "viewAllOwners";
//            // ... add the if-else logic for the owner views...
//        } else if (jspName.equalsIgnoreCase("updateOwner")) {
//            String ownerId = request.getParameter("ownerid");
//            Owner updateOwner = DataCacheJson.getOwner(ownerId);
//            updateOwner.setFirstName(request.getParameter("firstname"));
//            updateOwner.setLastName(request.getParameter("lastname"));
//            updateOwner.setPhone(request.getParameter("phone"));
//            updateOwner.setAddress(request.getParameter("address"));
//            DataCacheJson.setOwner(updateOwner);
//            jspName = "viewAllOwners";
//        } else if (jspName.equalsIgnoreCase("saveNewPet")){
//            Pet saveNewPet = new Pet();
//            saveNewPet.setName(request.getParameter("name"));
//            saveNewPet.setOwnerId(request.getParameter("ownerid"));
//            saveNewPet.setPetType(Pet.PetType.valueOf(request.getParameter("pettype")));
//            saveNewPet.setPetId(System.currentTimeMillis()+"-"+saveNewPet.getName().charAt(0));
//            DataCacheJson.setPet(saveNewPet);
//            jspName = "viewAllPets";
//
//        } else if (jspName.equalsIgnoreCase("updatePet")) {
//            String petId = request.getParameter("petid");
//            Pet updatePet = DataCacheJson.getPet(petId);
//            updatePet.setPetId(request.getParameter("petid"));
//            updatePet.setName(request.getParameter("name"));
//            updatePet.setPetType(Pet.PetType.valueOf(request.getParameter("pettype")));
//            updatePet.setOwnerId(request.getParameter("ownerid"));
//            DataCacheJson.setPet(updatePet);
//            jspName = "viewAllPet";
//        }
//
//        //RequestDispatcher view = request.getRequestDispatcher("/test/test.jsp");
//        RequestDispatcher view = request.getRequestDispatcher("/customer/" + jspName + ".jsp");
////    RequestDispatcher view = request.getRequestDispatcher("/customers/" + jspName + ".jsp");
//        view.forward(request,response);
//
//    }
//
//
//
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        doPost(request,response);
//    }
//}
//    public void createTable() {
//        try {
//            Class.forName("");
//            Connection conn = DriverManager.getConnection("jdbc:hsqldb:troopers","sa","");
//            Statement stmt = conn.createStatement();
//            stmt.executeUpdate("CREATE TABLE trooper_tracker ( id INTEGER IDENTITY, troopCode VARCHAR(256), signinDate VARCHAR(256),note VARCHAR(256))");
//
//            stmt.close();
//            conn.close();
//        } catch(Exception e) {
//            System.out.println("Table Already Exists");
//        }
//    }}
