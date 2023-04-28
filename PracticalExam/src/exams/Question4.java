package exams;

public class Question4 {

	public static void main(String[] args) {
		
		int n = 5;
	    for(int i = 1; i <= n; i++){
	      System.out.print(printFibb(i)+ " ");
	    }

	}
	
	public static int printFibb(int n)
	  {
	    if(n == 0){
	      return 0;
	    }
	    else if(n == 1){
	      return 1;
	    }
	    else{
	      return printFibb(n-2) + printFibb(n-1);
	    }
	  }

}
