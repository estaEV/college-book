package com.estafet.learning.sprint7;

import java.io.IOException;
import java.util.*;

import static com.estafet.learning.sprint7.Globals.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        List<String> menu = new ArrayList<>();
        System.out.println("sprint7");
        menu.add("\n0. Exit.");
        menu.add("1. Create the following working tables: students, subjects and gradebooks tables.");
        menu.add("2. Delete the working tables.");
        menu.add("3. Fill the working tables with dummy data.");
        menu.add("4. Empty the working tables.");
        menu.add("5. Add a new subject to study.");
        menu.add("6. Math AVG grade for all student.");

        boolean isRunning = true;

        ConnectComponent comp = new ConnectComponent();

        while (isRunning) {
            menu.forEach(option -> System.out.println(option));
            System.out.print("\nEnter the selected func(): ");
            int option = sc.nextInt();
            switch (option) {
                case 0:
                    ConnectComponent.closeConnection();
                    isRunning = false;
                    break;
                case 1:
                    comp.createTables(tablesToWorkWith3);
                    break;
                case 2:
                    comp.deleteTables(tablesToWorkWith3);
                    break;
                case 3:
                    RandomGenerator randData = new RandomGenerator();
                    randData.generateMeSome();
                    comp.insertStudentsData(tablesToWorkWith, randData);
                    comp.insertSubjectsData(tablesToWorkWith, randData);
                    comp.insertGradebookData(tablesToWorkWith, randData);
                    break;
                case 4:
                    comp.truncateTable(tablesToWorkWith);
                    break;
                case 5:
                    System.out.print("Enter the name: ");
                    String newSubject = sc.next();
                    System.out.print("Enter the year in which the subject will be studied: ");
                    int subjectYear = sc.nextInt();
                    System.out.print("Enter a unique id for the new subject: ");
                    String subjectId = sc.next();
                    comp.insertNewSubject(tablesToWorkWith, newSubject, subjectId, subjectYear);
                    break;
                case 6:
                    System.out.print("AVG math grade for students from a specific year: ");
                    int studentsClassYear = sc.nextInt();
                    comp.mathAvgGrade(studentsClassYear);
                    break;
            }
        }

    }
}
