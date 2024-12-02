package pensionCalculator.Models;

public class ContributoryPensionData
{
    private double allIncomeSince2002 = 0;
    private double workMonthsSince2002 = 0;
    private double medianSalary = 0;
    private int ensima = 0;
    private int parallelYears = 0;
    private double posostoExtraEisforas = 0;
    private int etiAsfalisis = 0;

    public void setDataSimple(double medianSalary, int ensima, int parallelYears, double posostoExtraEisforas)
    {
        this.medianSalary = medianSalary;
        this.ensima = ensima;
        this.parallelYears = parallelYears;
        this.posostoExtraEisforas = posostoExtraEisforas;
        this.etiAsfalisis = ensima / 300;
    }

    public double getAllIncomeSince2002()
    {
        return allIncomeSince2002;
    }

    public double getWorkMonthsSince2002()
    {
        return workMonthsSince2002;
    }

    public double getMedianSalary()
    {
        return medianSalary;
    }

    public int getEnsima()
    {
        return ensima;
    }

    public int getParallelYears()
    {
        return parallelYears;
    }

    public double getPosostoExtraEisforas()
    {
        return posostoExtraEisforas;
    }

    public int getEtiAsfalisis()
    {
        return etiAsfalisis;
    }

}
