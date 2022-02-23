import java.util.*;

class DFA
{
	static boolean isIdentifier(String str)
	{
		int state = 0, flag = 0, input = 0;
		int[][] table = {{1, 3, 2}, {1, 1, 3}, {1, 1, 3}};
		
		for(char symbol: str.toCharArray())
		{
			if(Character.isAlphabetic(symbol))
				flag = 0;
			else if(Character.isDigit(symbol))
				flag = 1;
			else if(symbol == '_')
				flag = 2;

			switch(flag)
			{
				case 0: input = 0; 
						break;
				case 1: input = 1;
				 		break;
				case 2: input = 2; 
						break;
			}
			
			state = table[state][input];
		}
		
		if(state == 1)
			return true;
		else
			return false;
	}

	static boolean isInteger(String str)
    {
		int state = 0, x = 0, input = 0;
		int[][] table = {{1, 2}, {3, 2}, {1, 2}, {3, 3}};
		
		for(char symbol: str.toCharArray())
		{
			if(symbol == '+' || symbol == '-')
				x = 0;
			else if(Character.isDigit(symbol))
				x = 1;

			switch(x)
			{
				case 0: input = 0; 
						break;
				case 1: input = 1; 
						break;
			}

			state = table[state][input];
		}
		
		if(state == 3)
			return true;
		else
			return false;
    }

	static boolean isFloat(String str)
    {
		int state = 0, x = 0, input = 0;
		int[][] table = {{1, 2, 3},{3, 2, 3},{1, 2, 1},{3, 3, 3}};
		
		for(char symbol: str.toCharArray())
		{
			if(symbol == '+' || symbol == '-')
				x = 0;
			else if(Character.isDigit(symbol))
				x = 1;
			else if(symbol == '.')
				x = 2;

			switch(x)
			{
				case 0: input = 0; 
						break;
				case 1: input = 1; 
						break;
				case 2: input = 2;
						break;
			}

			state = table[state][input];
		}
		
		if(state == 2)
			return true;
		else
			return false;
    }

	static boolean isValid(String input)
	{
		boolean isValid = false, semicolon = false;
		StringTokenizer tokenizer = null;
		int state = 0;
		String newStr = null;

		semicolon = input.contains(";");

		if (semicolon)
		{
			if (input.indexOf(";") == (input.length() - 1)) 
			{
				newStr = input.substring(0, input.indexOf(";"));
				newStr = newStr + " ;";
				tokenizer = new StringTokenizer(newStr, " ");
			}
		}
				
		while (semicolon && tokenizer.hasMoreTokens()) 
		{
			String temp = tokenizer.nextToken();

			switch (state) 
			{
				case 0: semicolon = isIdentifier(temp);
						if (semicolon)
							state++;
						else
							break;
						break;
				case 1: semicolon = temp.equals("=");
						if (semicolon)
							state++;
						else
							break;
						break;
				case 2:	semicolon = (isIdentifier(temp) || isInteger(temp) || isFloat(temp));
						if (semicolon)
							state++;
						else
							break;
						break;
				case 3: semicolon = temp.equals(";");
						if (tokenizer.hasMoreTokens())
							state = 0;
						else
							break;
			}
		}

		if (state == 3)
			isValid = true;

		return isValid;
	}

	public static void version1() 
	{
		Scanner in = new Scanner(System.in);
		String str = null, output = null;
		int choice = 0, choiceX= 0;
		boolean isValid = false;

		while (choiceX != 0) 
		{
			System.out.print("Choose a function: \n1. Identifier\n2. Integer\n3. Float\n\nChoice: ");
			choice = in.nextInt();
			in.nextLine();

			for (int i = 0; i < 5; i++) 
			{
				System.out.print("\nInput: ");
				str = in.nextLine();

				switch (choice) 
				{
				case 1:
					isValid = isIdentifier(str);
					output = isValid ? "Valid" : "Invalid";
					System.out.println("Output: " + output);
					break;
				case 2:
					isValid = isInteger(str);
					output = isValid ? "Valid" : "Invalid";
					System.out.println("Output: " + output);
					break;
				case 3:
					isValid = isFloat(str);
					output = isValid ? "Valid" : "Invalid";
					System.out.println("Output: " + output);
					break;
				}
			}

			System.out.print("\nTry again? (1|0): ");
			choiceX = in.nextInt();
			in.nextLine();
		} 

		in.close();
	}

    public static void main(String args[])
    {
        //int choice = 0, x = 0;
        Scanner in = new Scanner(System.in);
		version1();

        /*while (x != 3);
		{
            System.out.print("Version: \n1. Version 1.0\n2. Version 2.0 \n3. Exit\n\nChoice: ");
            choice = in.nextInt();
            in.nextLine();
			
            switch (choice) 
			{
				case 1:
					version1();
					break;
				//case 2:
				//	version2();
				//	break;
            }
        } */

        in.close();
    }
}
