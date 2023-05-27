public class LongNumber{
    public NumberUnit setNumberUnit(String number) 
    {
        int numberLength = number.length();
        if (numberLength == 1) {
            int value = Integer.parseInt(number);
            NumberUnit numberUnit = new NumberUnit(value, null);
            return numberUnit;
        }
        int value = Integer.parseInt(number.substring(numberLength - 1, numberLength));
        String numberSub = number.substring(0, numberLength - 1);
        NumberUnit numberUnit = new NumberUnit(value, setNumberUnit(numberSub));
        return numberUnit;
    }

    public String getNumberUnit(NumberUnit numberUnit) 
    {
        String number = "";
        if (numberUnit.next == null) {
            number = Integer.toString(numberUnit.value);
            return number;
        }
        number = getNumberUnit(numberUnit.next) + Integer.toString(numberUnit.value);
        return number;
    }


}
