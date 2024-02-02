package com.mphasis.interview.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.mphasis.interview.common.CommonUtils;
import com.mphasis.interview.common.Employee;

public class FunctionTRAndThenExample {
    
    public static void main(String args[]){
	    Function<Employee, String> funcEmpToString= (Employee e)-> {return e.getName();};
	    List<Employee> employeeList= CommonUtils.getEmployeesList();
	    Function<String,String> initialFunction= (String s)->s.substring(0,1);
//	    List<String> empNameListInitials=convertEmpListToNamesList(employeeList, funcEmpToString.andThen(initialFunction));
//	    empNameListInitials.forEach(str->{System.out.print(" "+str);});
	    employeeList.forEach(System.out::println);
	    employeeList.stream().map(funcEmpToString.andThen(initialFunction)).forEach(System.out::println);
	    
	 }
	  public static List<String> convertEmpListToNamesList(List<Employee> employeeList, Function<Employee, String> funcEmpToString){
	   List<String> empNameList=new ArrayList<String>(); 
	   for(Employee emp:employeeList){
	     empNameList.add(funcEmpToString.apply(emp));
	   }
	   return empNameList;
	  }

}
