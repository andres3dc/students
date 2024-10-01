package co.edu.umanizales.studends.service;

import co.edu.umanizales.studends.model.Student;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Data
@Service
public class StudentService {
    private ArrayList<Student> students;

    @PostConstruct
    public void init(){
        students = new ArrayList<>();
    }

    private int filterByGender(byte gender) {
        int countGender = 0;
        for (Student student : students) {
            if (student.getGender() == gender) {
                countGender++;
            }
        }
        return countGender;
    }

    private int filterByGenderWork(byte gender) {
        int countGender = 0;
        for (Student student : students) {
            if (student.getGender() == gender && student.getWork() == 1) {
                countGender++;
            }
        }
        return countGender;
    }

    private double getTotalSalaryByGender(byte gender) {
        double averageSalary = 0;
        for (Student student : students) {
            if (student.getGender() == gender && student.getWork() == 1) {
                averageSalary+= student.getSalary();
            }
        }
        return averageSalary;
    }

    private float filterByWorkByGender(byte gender) {
        int countGender = 0;
        for (Student student : students) {
            if (student.getGender() == gender && student.getWork() == 1) {
                countGender++;
            }
        }
        return countGender;
    }

    public double getAverageSalaryByGender(byte gender) {
        return getTotalSalaryByGender(gender) / filterByGenderWork(gender);
    }

    public float getPercentageWorkByGender(byte gender) {
        return filterByWorkByGender(gender) / filterByGender(gender);
    }

    public float getPercentageGender(byte gender) {
        return (float) filterByGender(gender) / students.size();
    }
}
