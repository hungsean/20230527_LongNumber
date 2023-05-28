public class LongNumber{

    NumberUnit numberUnit;
    LongNumber(String number) 
    {
        this.numberUnit = setNumberUnit(number);
    }

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

    public NumberUnit addNumberUnit(NumberUnit numberUnit1, NumberUnit numberUnit2) 
    {
        int value = numberUnit1.value + numberUnit2.value;
        NumberUnit numberUnit, numberUnit0 = new NumberUnit(0, null);
        if (numberUnit1.next == null && numberUnit2.next == null) 
        {
            numberUnit = new NumberUnit(value, null);
            return numberUnit;
        }
        if (numberUnit1.next == null) 
        {
            numberUnit = new NumberUnit(value, addNumberUnit(numberUnit0, numberUnit2.next));
            return numberUnit;
        }
        if (numberUnit2.next == null) 
        {
            numberUnit = new NumberUnit(value, addNumberUnit(numberUnit1.next, numberUnit0));
            return numberUnit;
        }

        if(value >= 10)
        {
            value -= 10;
            numberUnit1.next.value += 1;
        }
        numberUnit = new NumberUnit(value, addNumberUnit(numberUnit1.next, numberUnit2.next));
        return numberUnit;
    }

    public NumberUnit subNumberUnit(NumberUnit numberUnit1, NumberUnit numberUnit2) 
    {
        int value = numberUnit1.value - numberUnit2.value;
        NumberUnit numberUnit, numberUnit0 = new NumberUnit(0, null);
        if (numberUnit1.next == null && numberUnit2.next == null) 
        {
            numberUnit = new NumberUnit(value, null);
            return numberUnit;
        }
        if (numberUnit1.next == null) 
        {
            numberUnit = new NumberUnit(value, subNumberUnit(numberUnit0, numberUnit2.next));
            return numberUnit;
        }
        if (numberUnit2.next == null) 
        {
            numberUnit = new NumberUnit(value, subNumberUnit(numberUnit1.next, numberUnit0));
            return numberUnit;
        }

        if(value < 0)
        {
            value += 10;
            numberUnit1.next.value -= 1;
        }
        numberUnit = new NumberUnit(value, subNumberUnit(numberUnit1.next, numberUnit2.next));
        return numberUnit;
    }


}
