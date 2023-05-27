public class App {
    public static void main(String[] args) throws Exception {
        LongNumber longNumber = new LongNumber();
        NumberUnit numberUnit = longNumber.setNumberUnit("123456789012345678901234567890123456789012345678901234567890");
        System.out.println(longNumber.getNumberUnit(numberUnit));
    }
}
