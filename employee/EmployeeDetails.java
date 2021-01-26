package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class EmployeeDetails {
 public static Employee userInput() {
	 Scanner input = new Scanner(System.in);
	 System.out.println(" enter id");
	 int id= input.nextInt();
	 System.out.println("enter employee name:");
	 String ename= input.next();
	 System.out.println("enter employee salary");
	 int salary= input.nextInt();
	 Employee emp= new Employee();
	 emp.setEmpid(id);
	 emp.setEmpname(ename);
	 emp.setSalary(salary);
	 return emp;
 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeOperations eo= new EmployeeOperations();
		Scanner input= new Scanner(System.in);
		int x=0;
		while(true) {
		System.out.println("1.insert \n 2. update \n3. retrieve\n  4. delete\n 0. Exit \n enter yout choice");
		try {
			x= input.nextInt();
		} catch(InputMismatchException e) {
			e.getMessage();
		}
	
		if(x==1)
		{
		 Employee emp =userInput();
			eo.insert(emp);
		
		}
		else if(x==2)
		{
			Employee emp=userInput();
			eo.update(emp);
			
		}
		else if(x==3)
		{
			/*System.out.println("enter emp id:");
			Scanner in = new Scanner(System.in);
			int id= in.nextInt();*/
		//	Employee e = new Employee();
			//e.setEmpid(id);
			eo.retrive();
		}else if(x==4)
		{
			System.out.println("enter emp id:");
			Scanner in = new Scanner(System.in);
			int id= in.nextInt();
			Employee e = new Employee();
			e.setEmpid(id);
			eo.delete(e);
		}
		else
		{
			System.exit(0);
		}
		}
	}
	
		

	}


