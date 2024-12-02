package org.example.Core;

public class NationalPensionCalculator
{
    public double getNationalPensionByAge(int ageYears, int ageMonths, int abidanceYears, int ensima, double currentPension)
    {
        double result = currentPension;

        //Εάν τα ετη ασφάλισης είναι 40 και πάνω, καταβάλλεται ολόκληρη η σύνταξη
        if (ensima >= 12000)
        {
            return result;
        }

        if(ensima > 6000)
        {
            ensima = 6000;
        }

        if(ensima < 4500)
        {
            ensima = 4500;
        }

        if(ageYears > 67 || (ageYears == 67 && ageMonths > 0))
        {
            ageYears = 67;
            ageMonths = 0;
        }

        if(ageYears < 62)
        {
            ageYears = 62;
            ageMonths = 0;
        }

        if(abidanceYears > 40)
        {
            abidanceYears = 40;
        }

        if(abidanceYears < 15)
        {
            abidanceYears = 15;
        }


        //Μείωση λόγω ετών ασφάλισης
        result -= currentPension * (20 - ((ensima / 300) - (ensima % 300))) * 2 / 100;

        //Μικρή αύξηση λόγω αναλογίας μηνών - ημερών
        result += currentPension * (ensima % 300) / 300 * 2 / 100;

        //Μείωση λόγω ετών διαμονής
        result -= result * (40 - abidanceYears) / 40;

        //Μείωση λόγω ορίου ηλικίας
        double tempResult = result;
        result -= result * (67 - ageYears) * 6 / 100;

        //Μικρή αύξηση λόγω αναλογίας μηνών
        result += tempResult * ageMonths * 1 / 200;

        return result;
    }

    public double getNationalPensionByDisability(double disablementPercentage, int ensima, double currentPension)
    {
        double result = currentPension;

        int disablementPercentageRounded = (int)disablementPercentage;

        //Μείωση λόγω ετών ασφάλισης
        result -= currentPension * (20 - ((ensima / 300) - (ensima % 300))) * 2 / 100;

        //Μικρή αύξηση λόγω αναλογίας μηνών - ημερών
        result += currentPension * (ensima % 300) / 300 * 2 / 100;

        switch ((0 <= disablementPercentageRounded && disablementPercentageRounded < 50) ? 1 :
                (50 <= disablementPercentageRounded && disablementPercentageRounded < 67) ? 2 :
                (67 <= disablementPercentageRounded && disablementPercentageRounded < 80) ? 3 : 4)
        {
            case 1:
                result = 0;
                break;
            case 2:
                result /= 2;
                break;
            case 3:
                result *= 0.75;
                break;
            case 4:
                break;
            default:
                result = 99.3333;
        }

        return result;
    }

    public double getNationalPensionByDeath(double deadRelativePension)
    {
        return deadRelativePension * 0.70;
    }

    public double getReductionByInsuranceYears(double pension, int ensima)
    {
        double result = pension;

        if (ensima >= 12000)
        {
            return 0;
        }

        if(ensima > 6000)
        {
            ensima = 6000;
        }

        if(ensima < 4500)
        {
            ensima = 4500;
        }

        result -= pension * (20 - ((ensima / 300) - (ensima % 300))) * 2 / 100;

        //Μικρή αύξηση λόγω αναλογίας μηνών - ημερών
        result += pension * (ensima % 300) / 300 * 2 / 100;

        return pension - result;

    }

    public double getReductionByResidenceYears(double pension, int residenceYears)
    {
        double result = pension;

        if(residenceYears > 40)
        {
            residenceYears = 40;
        }

        if(residenceYears < 15)
        {
            residenceYears = 15;
        }

        result -= pension * (40 - residenceYears) / 40;

        return pension - result;
    }

    public double getReductionByAge(double pension, int ageYears, int ageMonths)
    {
        double result = pension;
        if(ageYears > 67 || (ageYears == 67 && ageMonths > 0))
        {
            ageYears = 67;
            ageMonths = 0;
        }

        if(ageYears < 62)
        {
            ageYears = 62;
            ageMonths = 0;
        }

        double tempResult = result;
        result -= result * (67 - ageYears) * 6 / 100;

        //Μικρή αύξηση λόγω αναλογίας μηνών
        result += tempResult * ageMonths * 1 / 200;

        return pension - result;
    }

    public double getReductionByDisabilityPercentage(double pension, double disabilityPercentage)
    {
        double result = pension;

        switch ((0 <= disabilityPercentage && disabilityPercentage < 50) ? 1 :
                (50 <= disabilityPercentage && disabilityPercentage < 67) ? 2 :
                        (67 <= disabilityPercentage && disabilityPercentage < 80) ? 3 : 4)
        {
            case 1:
                result = 0;
                break;
            case 2:
                result /= 2;
                break;
            case 3:
                result *= 0.75;
                break;
            case 4:
                break;
            default:
                result = 99.3333;
        }

        return pension - result;
    }
}
