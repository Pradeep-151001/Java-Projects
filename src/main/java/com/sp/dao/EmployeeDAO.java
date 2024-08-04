package com.sp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sp.model.Employee;
import com.sp.constants.Constants;


public class EmployeeDAO {

	
	public Connection dbConnection() throws SQLException, ClassNotFoundException {
		Class.forName(Constants.DB_DRIVER_NAME);
		Connection connection = DriverManager.getConnection(Constants.DB_URL,Constants.DB_USER, Constants.DB_PASS);
		return connection;

	}
	
	public void createEmployee(Employee emp) throws SQLException {
		
		try(Connection connection = dbConnection();
			PreparedStatement ps = connection.prepareStatement(Constants.INSERT_QUERY))
		{
			ps.setString(1,emp.getName());
			ps.setString(2, emp.getEmail());
			ps.setString(3, emp.getCountry()); 
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public List<Employee> showExployee() {
		
		List<Employee> list = new ArrayList<>();
		try(Connection connection = dbConnection();
		PreparedStatement ps = connection.prepareStatement(Constants.SELECT_ALL)){
		
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				long id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				
				Employee emp = new Employee();
				emp.setId(id);
				emp.setName(name);
				emp.setCountry(country);
				emp.setEmail(email);
				
				list.add(emp);
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list; 
	}
	
						
}

