package week11Assignment;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import BikeDao.BikeInfoDao;
import bikeEntity.Bikes;

public class BikeMenu {
	
	private BikeInfoDao bikeInfoDao = new BikeInfoDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display Bike brands",
			"Update price of a bike",
			"Add a bike to the list ",
			"Delete a bike from the list");
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
				if (selection.equals("1")) {
				  displayBikeBrands();
				}else if (selection.equals("2")) {
				  updateBikePriceById();
				}else if (selection.equals("3")) {
				  addBike();
				}else if (selection.equals("4")) {
				  deleteBikeById();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("Press enter to continue....");
			scanner.nextLine();
		} while (!selection.equals("-1"));
	}

	private void printMenu() {
		System.out.println("Select an option:\n------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i+1 + ") " + options.get(i));
		}
	}

	private void displayBikeBrands() throws SQLException {
		List<Bikes> bikes = bikeInfoDao.getBikes();
		for (Bikes bike : bikes) {
			System.out.println(bike.getId() + ") Brand: " + bike.getBrand() + " niche: " + bike.getNiche() + " Model: " + bike.getModelName() + " Price $" + bike.getPrice());
		}
	}
	
	private void updateBikePriceById() throws SQLException {
		System.out.print("Enter bike id: ");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter new bike price: ");
		int price = Integer.parseInt(scanner.nextLine());
		bikeInfoDao.updatePriceById(id, price);
	}
	
	private void addBike() throws SQLException {
		System.out.print("Enter bike brand: ");
		String brand = scanner.nextLine();
		System.out.print("Enter bike niche: ");
		String niche = scanner.nextLine();
		System.out.print("Enter bike model: ");
		String model = scanner.nextLine();
		System.out.print("Enter bike price: ");
		int price = Integer.parseInt(scanner.nextLine());
		bikeInfoDao.createNewBike(brand, niche, model, price);
	}
	
	private void deleteBikeById() throws SQLException {
		System.out.print("Enter bike id to delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		bikeInfoDao.deleteBikeById(id);
	}
	
}
