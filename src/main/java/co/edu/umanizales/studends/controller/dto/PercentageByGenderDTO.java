package co.edu.umanizales.studends.controller.dto;

public class PercentageByGenderDTO {
    private float percentageWork;
    private double averageSalary;

    public PercentageByGenderDTO(float percentageWork, double averageSalary) {
        this.percentageWork = percentageWork;
        this.averageSalary = averageSalary;
    }

    public double getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(double averageSalary) {
        this.averageSalary = averageSalary;
    }

    public float getPercentageWork() {
        return percentageWork;
    }

    public void setPercentageWork(float percentageWork) {
        this.percentageWork = percentageWork;
    }
}
