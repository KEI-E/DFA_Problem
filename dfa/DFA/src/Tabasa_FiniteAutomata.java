
import java.util.Scanner;
import java.util.StringTokenizer;

public class Tabasa_FiniteAutomata {
    static Scanner in = new Scanner(System.in);

    public static boolean isIdentifier(String str) {
        boolean isValid = false;
        int input = 0, state = 0;
        int[][] transTable = { { 1, 3, 2, 3 }, { 1, 1, 1, 3 }, { 1, 1, 2, 3 }, { 3, 3, 3, 3 } };

        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch))
                input = 0;
            else if (Character.isDigit(ch))
                input = 1;
            else if (ch == '_')
                input = 2;
            else
                input = 3;
            state = transTable[state][input];
        }

        if (state == 1)
            isValid = true;
        return isValid;
    }

    public static boolean isInteger(String str) {
        boolean isValid = false;
        int input = 0, state = 0;
        int[][] transTable = { { 2, 1, 3 }, { 2, 3, 3, }, { 2, 3, 3 }, { 3, 3, 3 } };

        for (char ch : str.toCharArray()) {

            if (Character.isDigit(ch))
                input = 0;
            else if (ch == '+' || ch == '-')
                input = 1;
            else
                input = 2;
            state = transTable[state][input];

        }
        if (state == 2)
            isValid = true;
        return isValid;
    }

    public static boolean isFloat(String str) {
        boolean isValid = false;
        int input = 0, state = 0;
        int[][] transTable = { { 1, 3, 4, 5 }, { 1, 5, 2, 5 }, { 2, 5, 5, 5 }, { 1, 5, 4, 5 }, { 2, 5, 5, 5 },
                { 5, 5, 5, 5 } };

        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch))
                input = 0;
            else if (ch == '+' || ch == '-')
                input = 1;
            else if (ch == '.')
                input = 2;
            else
                input = 3;
            state = transTable[state][input];
        }

        if (state == 1 || state == 2)
            isValid = true;
        return isValid;
    }

    public static boolean isValidAssignment(String str) {
        boolean isValid = false, enterLoop = false;
        StringTokenizer tokenizer = null;
        int state = 0;
        String newStr = null;

        enterLoop = str.contains(";");

        if (enterLoop)
            if (str.indexOf(";") == (str.length() - 1)) {
                newStr = str.substring(0, str.indexOf(";"));
                newStr = newStr + " ;";
                tokenizer = new StringTokenizer(newStr, " ");
            }

        while (enterLoop && tokenizer.hasMoreTokens()) {

            String temp = tokenizer.nextToken();

            switch (state) {
            case 0:
                enterLoop = isIdentifier(temp);
                if (enterLoop)
                    state++;
                else
                    break;
                break;
            case 1:
                enterLoop = temp.equals("=");
                if (enterLoop)
                    state++;
                else
                    break;
                break;
            case 2:
                enterLoop = (isIdentifier(temp) || isInteger(temp) || isFloat(temp));
                if (enterLoop)
                    state++;
                else
                    break;
                break;
            case 3:
                enterLoop = temp.equals(";");
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


    public static void version1() {

        String str = null;
        int choice = 0, proceed = 0;
        boolean isValid = false;
        String output = null;

        do {
            System.out.print("Choose a function: \n1. Identifier\n2. Integer\n3. Float\n\nChoice: ");
            choice = in.nextInt();
            in.nextLine();

            for (int i = 0; i < 5; i++) {
                System.out.print("\nInput: ");
                str = in.nextLine();

                switch (choice) {
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

            System.out.print("\nContinue with Version 1.0 ? (1 or 0): ");
            proceed = in.nextInt();
            in.nextLine();
        } while (proceed != 0);

    }

    public static void version2() {
        String str = null;
        int proceed = 0;
        boolean isValid = false;
        String output = null;

        do {
            System.out.print("Is Valid Statement\n");

            for (int i = 0; i < 5; i++) {
                System.out.print("\nInput: ");
                str = in.nextLine();

                isValid = isValidAssignment(str);
                output = isValid ? "Valid" : "Invalid";
                System.out.println("Output: " + output);
            }

            System.out.print("\nContinue with Version 2.0 ? (1 or 0): ");
            proceed = in.nextInt();
            in.nextLine();
        } while (proceed != 0);
    }

    public static void main(String args[]) 
    {

        int choice = 0, proceed = 0;
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("Finite Automata\n");
            System.out
                    .print("Choose a Version: \n1. Version 1.0\n2. Version 2.0 \n3. Exit\nChoice: ");
            choice = in.nextInt();
            in.nextLine();
            switch (choice) {
            case 1:
                version1();
                break;
            case 2:
                System.out.print("Is Valid Statement");
                version2();
                break;
            }

        } while (proceed != 3);
        in.close();
    }

}