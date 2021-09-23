package com.estafet.learning.sprint7;

import java.io.IOException;
import java.util.*;

import static com.estafet.learning.sprint7.Globals.STUDENTNAMES;

public class Main {

    public static void main(String[] args) throws Exception {

        RandomGenerator dataa = new RandomGenerator();
        dataa.generateMeSome();
        System.out.println("krai i na meina");

        Scanner sc = new Scanner(System.in);
        List<String> menu = new ArrayList<>();
        System.out.println("sprint7");
        menu.add("\n0. Exit.");
        menu.add("1. Create the following working tables: students, subjects and gradebooks tables.");
        menu.add("2. Delete the working tables.");
        menu.add("3. Fill the working tables with dummy data.");
        menu.add("4. Empty the working tables.");
        menu.add("5. Add a new subject to study.");

        boolean isRunning = true;

        String[] tablesToWorkWith = {"students", "subjects", "gradebooks"};
        Map<String, ArrayList<String>> tablesToWorkWith2 = new LinkedHashMap<>();
        String[][] tablesToWorkWith3 = {
                {"students", "name VARCHAR(50)", "studentId VARCHAR(50)", "classYear INT"},
                {"subjects", "name VARCHAR(50)", "year INT"},
                {"gradebooks", "studentId VARCHAR(50)", "subjectId VARCHAR(50)", "grade INT"}
        };

        while (isRunning) {
            menu.forEach(option -> System.out.println(option));
            System.out.print("\nEnter the selected func(): ");
            int option = sc.nextInt();
            switch (option) {
                case 0:
                    isRunning = false;
                    break;
                case 1:
                    // Should we always make a new instance of this or just once?
                    try {
                        ConnectComponent comp = new ConnectComponent();
                        comp.createTables(tablesToWorkWith3);
                        //comp.tryConnection(5, 6);
                    } catch (Exception ex) {
                        ExceptionHandler.handleException(ex);
                    }
                    break;
                case 2:
                    // Should we always make a new instance of this or just once?
                    try {
                        ConnectComponent comp = new ConnectComponent();
                        comp.deleteTables(tablesToWorkWith3);
                        //comp.tryConnection(5, 6);
                    } catch (Exception ex) {
                        ExceptionHandler.handleException(ex);
                    }
                    break;
                case 3:
                    // Should we always make a new instance of this or just once?
                    try {
                        ConnectComponent comp = new ConnectComponent();
                        RandomGenerator randData = new RandomGenerator();
                        randData.generateMeSome();
                        comp.insertStudentsData(tablesToWorkWith, randData);
                        comp.insertSubjectsData(tablesToWorkWith, randData);

                    } catch (Exception ex) {
                        ExceptionHandler.handleException(ex);
                    }
                    break;
                case 4:
                    // Should we always make a new instance of this or just once?
                    try {
                        ConnectComponent comp = new ConnectComponent();
                        comp.truncateTable(tablesToWorkWith);
                    } catch (Exception ex) {
                        ExceptionHandler.handleException(ex);
                    }
                    break;
                case 5:
                    try {
                        ConnectComponent comp = new ConnectComponent();
                        System.out.println("Enter the name: ");
                        String newSubject = sc.next();
                        System.out.println("Enter the year in which the subject will be studied: ");
                        int subjectYear = sc.nextInt();
                        comp.insertNewSubject(tablesToWorkWith, newSubject, subjectYear);

                    } catch (Exception ex) {
                        ExceptionHandler.handleException(ex);
                    }
                    break;



            }
        }

    }
}
