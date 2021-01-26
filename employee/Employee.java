package employee;

import java.util.Comparator;

public class Employee implements Comparable<Employee>{
	
		private int empid, salary;
		private String empname;
		
		public int getEmpid() {
			return empid;
		}

		public void setEmpid(int empid) {
			this.empid = empid;
		}

		public int getSalary() {
			return salary;
		}

		public void setSalary(int salary) {
			this.salary = salary;
		}

		public String getEmpname() {
			return empname;
		}

		public void setEmpname(String empname) {
			this.empname = empname;
		
		}
		Employee(){
			
		}
		public Employee(int id, String name, int salary) {
			this.empid=id;
			this.empname= name;
			this.salary=salary;
			
		}
		class EmpidCompare implements Comparator<Employee> 
		{ 
		public int compare(Employee e1, Employee e2) {
			if(e1.getEmpid()<e2.getEmpid())
			{
				return -1;
				
			}
			if(e1.getEmpid()>e2.getEmpid())
			{
				return 1;
				
			}
		else return 0;
		}
		
		}
		
		class EmpnameCompare implements Comparator<Employee> 
		{ 
		    public int compare(Employee e1, Employee e2) 
		    { 
		        return e1.getEmpname().compareTo(e2.getEmpname()); 
		    } 
		}


		@Override
		public int compareTo(Employee e) {
			// TODO Auto-generated method stub
			return this.salary-e.salary;
			
		} 

	}


