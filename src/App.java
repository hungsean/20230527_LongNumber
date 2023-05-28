public class App {
    public static void main(String[] args) throws Exception {
        while(true)
        {
            System.out.println("Welcome to Long Number Calculator!");
            System.out.println("Please enter the first number:");
            String number1 = System.console().readLine();
            System.out.println("Please enter the operator:(+,-)");
            String operator = System.console().readLine();
            System.out.println("Please enter the second number:");
            String number2 = System.console().readLine();
            LongNumber longNumber1 = new LongNumber(number1);
            LongNumber longNumber2 = new LongNumber(number2);
            Calculator calculator = new Calculator();
            LongNumber result = new LongNumber("0");
            if (operator.equals("+"))
            {
                result = calculator.addLongNumber(longNumber1, longNumber2);
            }
            else if (operator.equals("-"))
            {
                result = calculator.subLongNumber(longNumber1, longNumber2);
            }
            else
            {
                System.out.println("Invalid operator!");
                continue;
            }
            System.out.println("The result is:");
            System.out.println(result.getString());
            System.out.println("Do you want to continue?(y/n)");
            String answer = System.console().readLine();
            if (answer.equals("n"))
            {
                break;
            }

        }
    }
}
