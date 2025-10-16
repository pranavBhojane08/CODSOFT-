package com.pack2;

import java.util.Scanner;

public class StudentGradeCalculator {
	
	//method to calculate grade base on  percentage
	
	public static String calculateGrade(double percentage)
	{
		if(percentage>=90)
		{
			return "A+";
		}
		else if(percentage>=80)
		{
			return "A";
		}
		else if(percentage>=70)
		{
			return "B";
		}
		else if(percentage>=60)
		{
			 return "c";		
			 
		}
		else if(percentage>=50)
		{
			return "D";
			
		}
		else
		{
			return "f (Fail)";
		}
	}
	public static void main(String[]args)
	{
		Scanner sc= new Scanner(System.in);
		
		//input number of subjects
		System.out.println("Enter the number of subjects:");
		int n=sc.nextInt();
		
		int totalMarks=0;
		
		//input marks for each subject
		for (int i=1; i<=n; i++) {
		     System.out.println("Enter marks obtained in subject"+ i +"(out of 100)");
		     int marks=sc.nextInt();
		     
		     
		     //validate marks
		     if(marks<0 || marks>100)
		     {
		    	 System.out.println(" invalid marks ! please enter between 0 and 100");
		    	 i--;  
		    	 continue;
		     }
		     
		     totalMarks += marks;
		     
		}
		// calculate average percentage
		double average =(double)totalMarks /n;
		
		//determin grade
		String grade =calculateGrade(average);
		
		//display result
		
		System.out.println("\n===========📑 Result=====================");
		System.out.println("Total Marks:"+ totalMarks+"/" +(n*100));
		 System.out.println("Average Percentage: " + String.format("%.2f", average) + "%");
		System.out.println("Grade:"+grade);
		
		sc.close();
	}
	
	

}
