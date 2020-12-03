package BikeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bikeEntity.Bikes;

public class BikeInfoDao {
	
	private Connection connection;
	private final String GET_BIKES_QUERY = "SELECT * FROM bikes";
	//private final String GET_BIKES_BY_BRAND_ID_QUERY = "SELECT * FROM bikes WHERE id = ?";
	private final String DELETE_BIKE_BY_ID_QUERY = "DELETE FROM bikes WHERE id = ?";
	private final String CREATE_NEW_BIKE_QUERY = "INSERT INTO bikes(brand, niche, model_name, price) VALUES(?,?,?,?)";
	private final String UPDATE_PRICE_BY_ID_QUERY = "UPDATE bikes SET price = ? WHERE id = ?";

	public BikeInfoDao() {
		connection = DBConnection.getConnection();
	}

	public List<Bikes> getBikes() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_BIKES_QUERY).executeQuery();
		List<Bikes> bikes = new ArrayList<Bikes>();
		
		while (rs.next()) {
			bikes.add(new Bikes(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
		}
		return bikes;
	}
	
	public void deleteBikeById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_BIKE_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	public void createNewBike(String brand, String niche, String modelName, int price) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_BIKE_QUERY);
		ps.setString(1, brand);
		ps.setString(2, niche);
		ps.setString(3, modelName);
		ps.setInt(4, price);
		ps.executeUpdate();
	}
	
	public void updatePriceById(int id, int price) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_PRICE_BY_ID_QUERY);
		ps.setInt(1, price);
		ps.setInt(2, id);
		ps.executeUpdate();
	}
}
 