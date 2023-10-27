package javatutorial;

import java.util.Arrays;

import java.util.List;
import java.util.stream.Collectors;

public class Streamsimple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	// Program 1(Stream filters)
		List<String>names = Arrays.asList("Ganesh","Ramesh","Ram","Shyam");
		List<String>longnames = names.stream().filter(name ->name.length()>3)
		.collect(Collectors.toList());
		System.out.println(longnames);
	
		
		
		
		// program 2
		
		List<Integer>trans = Arrays.asList(10,20,-33,55,-66,99);
	List<Integer>deposits = trans.stream().filter(t -> t > 0)
			.collect(Collectors.toList());
	System.out.println(deposits);
	
	List<Integer>withdrawls = trans.stream().filter(t -> t< 0)
			.collect(Collectors.toList());
	System.out.println(withdrawls);
	
	
	// Program 3(Reduce)
	
	List<Integer>numbers = Arrays.asList(1,2,3,4,5);
	int sum = numbers.stream().reduce(0,(x,y) ->x+y);
	System.out.println(sum);
	
	
	
	// Program 4 (Adding text)
	

	  List<String> names1 = Arrays.asList("ganesh","ram","shyam","ravi");
	  names1.stream().forEach(name -> System.out.println("welcome "+name));
	
	// Program 5 (Stream Map)
	  

	  List<Integer> birthYear = Arrays.asList(1979,1986,1991,1999);
	  List<Integer> ages = birthYear.stream().map(x -> 2023 - x).collect(Collectors.toList());
	  System.out.println(ages);
	
	  // Program 6
	  
	  List<Integer> tables = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	  List<Integer> threeTable = tables.stream().map(x -> x * 3)
	.collect(Collectors.toList());
	  System.out.println(threeTable);
	 
	  // 
	  
	  
	  
	  
	}

}
