package com.estafet.learning.sprint7;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Globals {
    public static final String[] STUDENTNAMES = new String[]{"Faiz Hoffman", "Mahira Byers", "Oskar Mack", "Fraya Branch", "Marta Nash", "Dollie Whitney", "Izabelle Bate", "Kendrick Robertson", "Jasper Savage", "Sadia Drew", "Felicity Mcfarlane", "Melody Martinez", "Keir Mcclure", "Onur Howell", "Georgina O'Doherty", "Regina Ahmad", "Kallum Brookes", "Lukasz Barr", "Ada Marsden", "Malik Thorpe", "Sienna-Rose Peck", "Ayaz Diaz", "Richie Hampton", "Humza Faulkner", "Lamar Cooley", "Murat Blaese", "Gage Wormald", "Jacqueline Cisneros", "Branden Maguire", "Hallie Dale", "Tyrique Mcculloch", "Blair Preece", "Carrie-Ann Coulson", "Amy Boone", "Marsha Sharples", "Ananya Tucker", "Reon Munoz", "Kodi Plummer", "Georgia Stout", "Mikayla Meyers", "Umer Frye", "Calista Kirk", "Vicki Ayers", "Saeed Haigh", "Mila Gross", "Shanai Laing", "Chaim Roach", "Jean-Luc Moss", "Charis Oneill", "Nela Colon", "Tahmina Odom", "Gabrielle Joyce", "Cheryl Conley", "Maaria Macias", "Emme Peel", "Brandan Velazquez", "Komal Landry", "Teo Hussain", "Darcie-Mae Gay", "Esmai Melia", "Shamas French", "Areeb Nicholls", "Safah Charles", "Karla Jones", "Osama Henderson", "Roman Reid", "Margaret Simon", "Nolan Walter", "Alex Rush", "Tara Neal", "Eira Schultz", "Ceara Kaufman", "Andreea Hodgson", "Hashir Chan", "Sanjay Horne", "Usamah Harper", "Luci Penn", "Elise Holt", "Iylah Harwood", "Akaash Stacey", "Amritpal Drummond", "Raj Harrington", "Bob Farrow", "Aurora Day", "Rylan Montes", "Eboni Mcfarland", "Brady Stark", "Conah Mac", "Zakary Reyna", "Pauline Lowry", "Arandeep Conway", "Rohit Hendricks", "Carlton Hooper", "Anisah Love", "Shanna Spencer", "Stefanie Whelan", "Ellenor Case", "Simona Browne", "Krzysztof Whitfield", "Alissa Carroll"};
    public static final String[] SUBJECTS = new String[]{"Accounting and Finance", "Aerospace Engineering", "Agriculture", "Air Transport Management", "American Studies", "Animation", "Anthropology", "Architecture", "Architecture and Environmental Design", "Art", "Biotechnology", "Business and Management", "Chemistry", "Computer Science", "Criminology", "Dance", "Dentistry", "Design and Crafts", "Development Studies", "Digital Media", "Drama", "Economics", "Education Studies", "Engineering", "English Literature", "Fashion Design", "Film Production", "Film Studies", "Floristry", "Food Science", "Forensic Science", "Geography", "Hospitality and Tourism", "Hotel Management", "Human Resources Management", "Interior Design", "International Relations", "Journalism", "Liberal Arts", "Linguistics", "Bachelor of Laws", "Master of Laws", "Marketing", "Mathematics", "Media and Communications", "Medicine", "Music", "Nursing", "Oil and Gas Engineering", "Oil and Gas Management", "Pharmacy", "Physiotherapy", "Politics", "Psychology", "Social Work", "Sociology", "Sports Science", "Supply Chain and Logistics", "TESOL", "Veterinary Medicine"};
    public static final String[] tablesToWorkWith = {"students", "subjects", "gradebooks"};
    public static final Map<String, ArrayList<String>> tablesToWorkWith2 = new LinkedHashMap<>();
    public static final String[][] tablesToWorkWith3 = {
            {"students", "name VARCHAR(50)", "studentId VARCHAR(50)", "classYear INT"},
            {"subjects", "name VARCHAR(50)", "subjectId VARCHAR(50)", "year INT"},
            {"gradebooks", "studentId VARCHAR(50)", "subjectId VARCHAR(50)", "grade INT"}
    };
    public static Connection connection = ConnectComponent.openConnection();

}
