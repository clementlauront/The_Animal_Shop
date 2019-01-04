package fr.clauront;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/the_animal_shop?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String DATABASE_LOGIN = "root";
	private static final String DATABASE_SECRET = "activ";

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		afficherAnimaux();
		
		input.close();
	}
	
	private static final void afficherAnimaux() {
		try {
			Connection connexion = DriverManager.getConnection(DATABASE_URL, DATABASE_LOGIN, DATABASE_SECRET);
			String requete = "SELECT * FROM Animal;";
			Statement executeur = connexion.createStatement();
			ResultSet resultat = executeur.executeQuery(requete);
			
			System.out.println(String.format("%-4s", "ID") + " | " + String.format("%-25s", "Species") + " | " + String.format("%-25s", "Name") + " | " + String.format("%-6s", "Gender") + " | " + String.format("%-3s", "Age") + " | " + String.format("%-9s", "Sale") + " | " + String.format("%-5s", "Price"));
			System.out.println(String.format("%-4s", "____") + "_|_" + String.format("%-25s", "_________________________") + "_|_" + String.format("%-25s", "_________________________") + "_|_" + String.format("%-6s", "______") + "_|_" + String.format("%-3s", "___") + "_|_" + String.format("%-9s", "_________") + "_|_" + String.format("%-5s", "_____"));
			while (resultat.next()) {
				System.out.println(String.format("%-4s", resultat.getString("Id")) + " | " + String.format("%-25s", resultat.getString("Species")) + " | " + String.format("%-25s", resultat.getString("Name")) + " | " + String.format("%-6s", resultat.getString("Gender")) + " | " + String.format("%-3d", resultat.getInt("Age")) + " | " + String.format("%-9s", resultat.getString("Sale")) + " | " + String.format("%-5d", resultat.getInt("Price")));
			}
			
			resultat.close();
			executeur.close();
			connexion.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static final void ajouterAnimal(Scanner input) {
		boolean isRunning = true;
		String response = "";
		
		System.out.println("Vous souhaitez ajouter un animal.");
		
		try {
			Connection connexion = DriverManager.getConnection(DATABASE_URL, DATABASE_LOGIN, DATABASE_SECRET);
			String requete = "INSERT INTO Animal (Id, Species, Name, Gender, Age, Sale, Price) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparateur = connexion.prepareStatement(requete);
			
			while (isRunning) {
				// define ID
				while (!response.equalsIgnoreCase("quitter")) {
					System.out.println("Entrez l'ID du nouvel animal");
					response = input.nextLine();
					if (response.length()<5) {
						preparateur.setString(1, response);
						break;
					}
				}
				// define species
				while (!response.equalsIgnoreCase("quitter")) {
					System.out.println("Entrez l'ID du nouvel animal");
					response = input.nextLine();
					if (response.length()<5) {
						preparateur.setString(2, "dog");
						break;
					}
				}

			preparateur.setString(3, "Ouaf");
			preparateur.setString(4, "Male");
			preparateur.setInt(5, 8);
			preparateur.setString(6, "reserved");
			preparateur.setInt(7, 1045);
			
			preparateur.execute();
			}
			
			preparateur.close();
			connexion.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static final void ajouterEspece(Scanner input) {
		
	}
	
	
}
