package employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

import employee.Employee.EmpidCompare;

import java.io.*; 
import java.util.*; 



public class EmployeeOperations implements EmployeeInterface{
	DatabaseConnection db= new DatabaseConnection();
Connection con= db.connection();
PreparedStatement  statement;
	@Override
	public void insert(Employee emp) {
		// TODO Auto-generated method stub
		try {
			//String sql ="INSERT INTO customer (idcustomer, accnountno,	customername, bankname, mobilenumber, address) VALUES (?, ?, ?, ?, ?, ?)";
			statement= con.prepareStatement("INSERT INTO employee ( empid, empname, salary) VALUES (?, ?, ?)");
			statement.setInt(1, emp.getEmpid());
			statement.setString(2, emp.getEmpname());
			statement.setInt(3, emp.getSalary());
			
			int row = statement.executeUpdate();
			if(row>0)
				System.out.println("user inserted");
			
		}catch(SQLException e) {
			e.getMessage();
		}
	}

	@Override
	public void update(Employee emp) {
		// TODO Auto-generated method stub
		try {
			statement= con.prepareStatement("UPDATE employee SET empname=?, salary=? WHERE empid=?");
			statement.setString(1, emp.getEmpname());
			statement.setInt(2, emp.getSalary());
			statement.setInt(3, emp.getEmpid());
			int rowsUpdated = statement.executeUpdate();
			if(rowsUpdated>0) {
				System.out.println("user updated");
			}
				
		}catch(SQLException e) {
			e.getMessage();
		}
		
	}

	@Override
	public void retrive() {
		// TODO Auto-generated method stub
		
			ArrayList<Employee> employeelist = new ArrayList<>();	
		       
			try {
				 Statement statement = con.createStatement();
		            ResultSet rs = statement.executeQuery("SELECT * FROM employee");
		            while (rs.next()) {
		            	Employee employee = new Employee();
		            	employee.setEmpid(rs.getInt("empid"));
		            	employee.setEmpname(rs.getString("empname"));
		            	employee.setSalary(rs.getInt("salary"));
		            	employeelist.add(employee);
		            }
		            //EmpidCompare ec= new EmpidCompare(emp);
		            //Collections.sort(employeelist, ec);
		            
		            for(Employee obj : employeelist) {
		            	 System.out.println("empoyeeid:" +obj.getEmpid() +"\temployee name:" +obj.getEmpname()+ " \temployee salary:"+obj.getSalary() );
		            	
		            }
		          
			}catch(SQLException ex) {
				ex.getMessage();
			}
		}
	

	@Override
	public void delete(Employee emp) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement statement = con.prepareStatement("DELETE FROM employee WHERE empid=?");
			statement.setInt(1, emp.getEmpid());
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A user was deleted successfully!");
			}
			
		}
		
	catch(SQLException e) {
		e.getMessage();
	}
	}

}
