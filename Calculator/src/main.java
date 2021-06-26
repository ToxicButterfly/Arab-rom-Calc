import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class main 
{

  public static void main(String args[])
  {
  

    main.calculate();
  }
  
  
  private static void calculate() {
	    Scanner in = new Scanner(System.in);

	    boolean arFlag = false, romFlag = false; 
	    
	    int op=-1;	    
	    String str = in.nextLine(), result2;
	    int length = str.length(), num1 = -1, num2 = -1, n1=-1,n2 = -1, m1 = -1, m2=-1, i = 0;
	    float result=-1;
	    char save;

	    while(i < length)
	    {
	    	save = str.charAt(i);
	    	if(save == ' ')
	    	{
	    		i++;
	    		continue;
	    	}
	    	
	    	if(num1 == -1)
	    	{
			    if ((save == 'I' || save == 'V' || save == 'X') && n1 == -1)
			    	romFlag = true;
			    else if(Character.getNumericValue(save) >= 0 && Character.getNumericValue(save) <= 9)
			    	arFlag = true;
			    
			    if(arFlag == true && (Character.getNumericValue(save) < 0 || Character.getNumericValue(save) > 9))
	    		{
	    			if(n1 == -1)
	    			{
	    				System.out.printf("¬ведено неккоректное значение");
	    			    System.exit(0);
	    			}
	    		    String str1 = str.substring(n1, n2+1);
	    		    num1 = Integer.parseInt (str1);
	    		    continue;
	    		}

			    
			    if(romFlag == true && (save != 'I' && save != 'V' && save != 'X'))
	    		{
	    			if(n1 == -1)
	    			{
	    				System.out.printf("¬ведено неккоректное значение");
	    			    System.exit(0);
	    			}
	    		    String str1 = str.substring(n1, n2+1);
	    		    if(str1.equals("I"))
	    		    	num1 = 1;
	    		   	else if(str1.equals("II"))
	    		    	num1 = 2;
	    		    else if(str1.equals("III"))
	    		    	num1 = 3;
	    		    else if(str1.equals("IV"))
	    		    	num1 = 4;
	    		    else if(str1.equals("V"))
	    		    	num1 = 5;
	    		    else if(str1.equals("VI"))
	    		    	num1 = 6;
	    		    else if(str1.equals("VII"))
	    		    	num1 = 7;
	    		    else if(str1.equals("VIII"))
	    		    	num1 = 8;
	    		    else if(str1.equals("IX"))
	    		    	num1 = 9;
	    		    else if(str1.equals("X"))
	    		    	num1 = 10;
	    		    else
	    		    {
	    				System.out.printf("¬ведено неккоректное значение");
	    				System.exit(0);
	    		    }
	    		    continue;
	    		}

	    		
	    		if(n1 == -1)
	    			n2 = n1 = i;
	    		else
	    			n2 = i;
	    	}
	    	else if(op == -1)
	    	{
	    	    if(save == '+')
	    	    	op = 1;
	    	    else if(save == '-')
	    	    	op = 2;
	    	    else if(save == '*')
	    	    	op = 3;
	    	    else if(save == '/')
	    	    	op = 4;
	    	    else 
	    	    {
	    			System.out.printf("¬ведено неккоректное выражение");
	    		    System.exit(0);
	    	    }
	    	}
	    	else 
	    	{
	    		if(m1 == -1)
	    		{
	    			if(save == 'I' || save == 'V' || save == 'X')
	    				romFlag = true;
	    			else if(Character.getNumericValue(save) >= 0 && Character.getNumericValue(save) <= 9)
	    				arFlag = true;
	    			
	    			m2 = m1 = i;
	    			
	    		}
	    		else
	    			m2 = i;
	    	}
	    	i++;
	    }
	    String str2 = str.substring(m1, m2+1);

	    if(arFlag ^ !romFlag)
	    {
			System.out.printf("¬ведены числа из разных систем");
		    System.exit(0);
	    }
	    else if(romFlag)
	    {
		    if(str2.equals("I"))
		    	num2 = 1;
		   	else if(str2.equals("II"))
		    	num2 = 2;
		    else if(str2.equals("III"))
		    	num2 = 3;
		    else if(str2.equals("IV"))
		    	num2 = 4;
		    else if(str2.equals("V"))
		    	num2 = 5;
		    else if(str2.equals("VI"))
		    	num2 = 6;
		    else if(str2.equals("VII"))
		    	num2 = 7;
		    else if(str2.equals("VIII"))
		    	num2 = 8;
		    else if(str2.equals("IX"))
		    	num2 = 9;
		    else if(str2.equals("X"))
		    	num2 = 10;
		    else
		    {
				System.out.printf("¬ведено неккоректное значение");
				System.exit(0);
		    }

	    }
	    else
	    	num2 = Integer.parseInt (str2);

	    if(num1>10)
	    {
			System.out.printf("¬ведено неккоректное значение");
		    System.exit(0);
	    }
	    
	    if(num2>10)
	    {
			System.out.printf("¬ведено неккоректное значение");
		    System.exit(0);
	    }
	    
	    switch(op)
	    {
	    case 1:
	    	result = num1 + num2;
	    	break;
	    case 2:
	    	result = num1 - num2;
	    	break;
	    case 3:
	    	result = num1 * num2;
	    	break;
	    case 4:
	    	result = (float) num1 / num2;
	    	break;
	    }
	    result = (int) result;
	    if(romFlag)
	    {
	    	result2 = convert((int) result);
		    System.out.printf("Result: %s", result2);
	    }
	    else
	    {
		    NumberFormat nf = new DecimalFormat("#.######");
		    System.out.printf(nf.format(result));
	    }
	    in.close();
  }
  
  public static String convert(int number)
  {

	    String romanOnes = romanDigit( number%10, "I", "V", "X");
	    number /=10;
	    String romanTens = romanDigit( number%10, "X", "L", "C");
	    number /=10;
	    String romanHundreds = romanDigit(number%10, "C", "D", "M");
	    number /=10;
	    String romanThousands = romanDigit(number%10, "M", "", "");

	    String result = romanThousands + romanHundreds + romanTens + romanOnes;
	    return result;
}

  public static String romanDigit(int n, String one, String five, String ten)
  {

	  if(n >= 1)
	  {
		  if(n == 1)
			  return one;
		  else if (n == 2)
			  return one + one;
		  else if (n == 3)
			  return one + one + one;
		  else if (n==4)
			  return one + five;
		  else if (n == 5)
			  return five;
		  else if (n == 6)
			  return five + one;
		  else if (n == 7)
			  return five + one + one;
		  else if (n == 8)
			  return five + one + one + one;
		  else if (n == 9)
			  return one + ten;
	  }
	  return "";
  }
}


