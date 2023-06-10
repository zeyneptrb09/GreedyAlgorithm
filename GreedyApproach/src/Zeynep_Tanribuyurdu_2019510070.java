import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Zeynep_Tanribuyurdu_2019510070 {
	

	public static void Greedy(int p, int n, int[] y, int c, int[] salaries) {
		 
		int min_cost=0;// minimum total for greedy approach
		
	    int[] dp = new int[n];// array for keep minimum total for each years  
	  
	    for (int i = 0; i < n ; i++) {//n year
	    	System.out.println();
	    	System.out.print(i+1 + ".year: ");
	    	
	    	if(y[i] >= p) {// if demand is more than max value(p)
	    		dp[i] = (y[i] - p)*c;
	    	}
	    	else {// if demand is less than max value(p)
	    		int dist=p-y[i];// difference of p and demand
	    		for(int j=0;j<dist;j++) {//for calculating the probabilities of use more players than the demand 
	    			dp[i] = Math.min(salaries[j],0);// minimum value choosing players or no players for using other years
	    		}
	    		
	    	}
	    	System.out.print(y[i] + " demand : " + dp[i] + " cost");
	    	System.out.println();
	    	min_cost+=dp[i];// sum for every year minimum value
	    }
	    
	    
	   System.out.println();
	 System.out.println("MÝN COST : " + min_cost);
	}
	
	


	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		
		int p=5;
		int n=50;
		int c=10;
		int[] salaries = new int[310];
		int[] y = new int[50];
		
		try {
           File file = new File("demand.txt");
           Scanner scanner1 = new Scanner(file);

           
           int index = 0;
           while (scanner1.hasNextLine()) {
           	String line = scanner1.nextLine();
           	if(index!=0) {
               
               String[] parts = line.split("\t"); // divide line with tab

               int demand = Integer.parseInt(parts[1]);
               y[index-1] = demand;
               
           	}
           	
               index++;
           }

           scanner1.close();

           

       } catch (FileNotFoundException e) {
           System.out.println("File can not found.");
       }
		
		
		
		try {
           File file = new File("salary.txt");
           Scanner scanner2 = new Scanner(file);

           
           int index = 0;
           while (scanner2.hasNextLine()) {
           	String line = scanner2.nextLine();
           	if(index!=0) {
               
               String[] parts = line.split("\t"); 
               int salary = Integer.parseInt(parts[1]); 
               salaries[index-1] = salary;
               
           	}
           	
               index++;
           }

           scanner2.close();

          
       } catch (FileNotFoundException e) {
           System.out.println("File can not found.");
       }
		
		
		Greedy(p, n, y, c, salaries);
		
}
	
}
