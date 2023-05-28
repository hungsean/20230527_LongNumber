public class App {
    public static void main(String[] args) throws Exception {
        Calculator Calculator = new Calculator();
        LongNumber longNumber = new LongNumber("123");
        LongNumber longNumber2 = new LongNumber("4560");
        LongNumber longNumberAdd = Calculator.addLongNumber(longNumber, longNumber2);
        LongNumber longNumberSub = Calculator.subLongNumber(longNumber, longNumber2);
        System.out.println(longNumberAdd.getString());
        System.out.println(longNumberSub.getString());
    }
}
