package fr.clauront;

import java.util.Scanner;

public final class Animal {
	// attributes
	private int id;
	private String species;
	private String name;
	private String gender;
	private int age;
	private String sale;
	private int price;
	
	// constructor
	public Animal(Scanner input) {
		boolean isRunning = true;
		String response = "";
		
		while (isRunning) {
			
			// define ID
			while (!response.equalsIgnoreCase("annuler")) {


			}
			
			// define species
			while (!response.equalsIgnoreCase("annuler")) {
				System.out.println("Entrez l'espèce du nouvel animal (limitée à 25 caractères) - tapez \"annuler\" pour annuler");
				response = input.nextLine();
				if (response.length()<26) {
					species = response;
					break;
				}
			}
			
			// define Name
			while (!response.equalsIgnoreCase("annuler")) {
				System.out.println("Entrez le nom du nouvel animal (limité à 25 caractères) - tapez \"annuler\" pour annuler");
				response = input.nextLine();
				if (response.length()<26) {
					name = response;
					break;
				}
			}
			
			// define Gender TODO
			while (!response.equalsIgnoreCase("annuler")) {
				System.out.println("Entrez le sexe du nouvel animal (\"male\" ou \"female\") - tapez \"annuler\" pour annuler");
				response = input.nextLine();
				if (response.length()<9 && (response.equalsIgnoreCase("Male") || response.equalsIgnoreCase("Female"))) {
					name = response.toLowerCase();
					break;
				}
			}
			
			// define age
			while (!response.equalsIgnoreCase("annuler")) {
				System.out.println("Entrez l'âge du nouvel animal (limité à 3 chiffres) - tapez \"annuler\" pour annuler");
				response = input.nextLine();
				boolean isANumber = true;
				if (response.length()<4) {
					for (int i = 0; i<response.length(); i++) {
						if ((int) response.charAt(i) < 48 || (int) response.charAt(i)> 57) { // check if only digits
							isANumber = false;
						}
					}
					if (isANumber) {
						age = Integer.parseInt(response);
						break;
					}
				}
			}
			
			// define sale TODO
			
			if (response.equalsIgnoreCase("annuler")) {
				isRunning = false;
			}
		}
	}
	
	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnimalSpecies() {
		return species;
	}

	public void setAnimalSpecies(String species) {
		this.species = species;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSale() {
		return sale;
	}

	public void setSale(String sale) {
		this.sale = sale;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
