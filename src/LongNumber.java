public class LongNumber{

    NumberUnit numberUnit;
    LongNumber(String number) 
    {
        this.numberUnit = set(number);
    }

    LongNumber(NumberUnit numberUnit) 
    {
        this.numberUnit = numberUnit;
    }

    public NumberUnit set(String number) 
    {
        int numberLength = number.length();
        int sign = 1;
        if (number.charAt(0) == '-') 
        {
            sign = -1;
            if (numberLength == 2) 
            {
                int value = Integer.parseInt(number);
                NumberUnit numberUnit = new NumberUnit(value, null);
                return numberUnit;
            }
        }
        if (numberLength == 1) 
        {
            int value = Integer.parseInt(number);
            NumberUnit numberUnit = new NumberUnit(value, null);
            return numberUnit;
        }
        int value = Integer.parseInt(number.substring(numberLength - 1, numberLength));
        value *= sign;
        String numberSub = number.substring(0, numberLength - 1);
        NumberUnit numberUnit = new NumberUnit(value, set(numberSub));
        return numberUnit;
    }

    public String get(NumberUnit numberUnit) 
    {
        String number = "";
        if (numberUnit.next == null) {
            number = Integer.toString(numberUnit.value);
            return number;
        }
        number = get(numberUnit.next) + Integer.toString(numberUnit.value);
        return number;
    }

    public String getString()
    {
        return get(this.numberUnit);
    }

    public NumberUnit getNumberUnit()
    {
        return this.numberUnit;
    }

    


}
