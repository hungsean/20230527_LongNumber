public class Calculator 
{
    private NumberUnit add(NumberUnit numberUnit1, NumberUnit numberUnit2) 
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
            numberUnit = new NumberUnit(value, add(numberUnit0, numberUnit2.next));
            return numberUnit;
        }
        if (numberUnit2.next == null) 
        {
            numberUnit = new NumberUnit(value, add(numberUnit1.next, numberUnit0));
            return numberUnit;
        }
        numberUnit = new NumberUnit(value, add(numberUnit1.next, numberUnit2.next));
        return numberUnit;
    }

    private NumberUnit sub(NumberUnit numberUnit1, NumberUnit numberUnit2) 
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
            numberUnit = new NumberUnit(value, sub(numberUnit0, numberUnit2.next));
            return numberUnit;
        }
        if (numberUnit2.next == null) 
        {
            numberUnit = new NumberUnit(value, sub(numberUnit1.next, numberUnit0));
            return numberUnit;
        }
        numberUnit = new NumberUnit(value, sub(numberUnit1.next, numberUnit2.next));
        return numberUnit;
    }

    public NumberUnit addNumberUnit(NumberUnit numberUnit1, NumberUnit numberUnit2) 
    {
        NumberUnit numberUnit = add(numberUnit1, numberUnit2);
        numberUnit = fix(numberUnit);
        return numberUnit;
    }

    public NumberUnit subNumberUnit(NumberUnit numberUnit1, NumberUnit numberUnit2) 
    {
        NumberUnit numberUnit = sub(numberUnit1, numberUnit2);
        numberUnit = fix(numberUnit);
        return numberUnit;
    }

    public LongNumber addLongNumber(LongNumber longNumber1, LongNumber longNumber2) 
    {
        NumberUnit numberUnit = addNumberUnit(longNumber1.numberUnit, longNumber2.numberUnit);
        LongNumber longNumber = new LongNumber(numberUnit);
        return longNumber;
    }

    public LongNumber subLongNumber(LongNumber longNumber1, LongNumber longNumber2) 
    {
        NumberUnit numberUnit = subNumberUnit(longNumber1.numberUnit, longNumber2.numberUnit);
        LongNumber longNumber = new LongNumber(numberUnit);
        return longNumber;
    }

    public NumberUnit fix(NumberUnit numberUnit)
    {
        if(numberUnit.next == null)
        {
            return numberUnit;
        }
        int temp = numberUnit.value + numberUnit.next.value *10;
        numberUnit.value = temp % 10;
        if (temp < 0)
        {
            numberUnit.value *= -1;
        }
        numberUnit.next.value = temp / 10;
        numberUnit.next = fix(numberUnit.next);
        return numberUnit;
    }
}
