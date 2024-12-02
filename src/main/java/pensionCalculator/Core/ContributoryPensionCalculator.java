package pensionCalculator.Core;

import pensionCalculator.Models.PosostaAnaplirosis;

import java.util.HashMap;

public class ContributoryPensionCalculator
{
    private final PosostaAnaplirosis posostaAnaplirosis;

    public ContributoryPensionCalculator()
    {
        posostaAnaplirosis = new PosostaAnaplirosis();
    }

    public double getContributoryPensionCalculator(double medianSalary, int etiAsfalisis)
    {

        if(!posostaAnaplirosis.containsKey(etiAsfalisis))
        {
            return medianSalary * (50.01 + ((etiAsfalisis - 40) * 0.5)) / 100;
        }
        else
        {
            return medianSalary * (posostaAnaplirosis.get(etiAsfalisis)) / 100;
        }
    }

    public HashMap<Integer, Double> getPosostaAnaplirosis()
    {
        return posostaAnaplirosis;
    }
}
