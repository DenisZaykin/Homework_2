package org.zaykin.teamwork.abstractclass;

import org.zaykin.teamwork.enumeration.Gender;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Created by DHM on 6/29/2017.
 */
public abstract class AbstractEmployee {

    private final UUID employeeID;
    private String firstName;
    private String lastName;
    private final LocalDate hireDate;
    private final Gender sex;
    private BigDecimal salary;

    protected AbstractEmployee(String firstName, String lastName, String sex, float salary) {

        this.employeeID = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.hireDate = LocalDate.now();
        this.sex = Gender.valueOf(sex);
        this.salary = new BigDecimal(Float.toString(salary)); //BigDecimal constructor usage with a Float parameter can lead to precision problem; we use constructor with a String parameter instead

    }

    public UUID getEmployeeId() {
        return employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public Gender getSex() {
        return sex;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

}
