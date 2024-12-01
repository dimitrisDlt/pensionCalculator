package org.example.Models;

public class NationalPensionData
{
    private int ageYears = 0;
    private int ageMonths = 0;
    private int residenceYears = 0;
    private int ensima = 0;
    private double disabilityPercentage = 0;
    
    public void setPensioDataByAge(int ageYears, int ageMonths, int residenceYears, int ensima)
    {
        this.ageYears = ageYears;
        this.ageMonths = ageMonths;
        this.residenceYears = residenceYears;
        this.ensima = ensima;
    }

    public void setPensioDataByDisability(double disabilityPercentage, int ensima)
    {
        this.disabilityPercentage = disabilityPercentage;
        this.ensima = ensima;
    }

    public int getAgeYears()
    {
        return ageYears;
    }

    public int getAgeMonths()
    {
        return ageMonths;
    }

    public int getResidenceYears()
    {
        return residenceYears;
    }

    public int getEnsima()
    {
        return ensima;
    }

    public double getDisabilityPercentage()
    {
        return disabilityPercentage;
    }
}
