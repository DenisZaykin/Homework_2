package org.zaykin.teamwork.calc;

import org.zaykin.teamwork.abstractclass.AbstractEmployee;
import org.zaykin.teamwork.entity.Project;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by DHM on 6/29/2017.
 */
public class ProjectCalc {

    private static final int WORKING_DAYS_IN_MONTH = 22;

    public static int manHours(Project project) {
        return WORKING_DAYS_IN_MONTH*project.getDurationInMonths()*project.getTeam().size();
    }

    public static BigDecimal cost (Project project) {

        BigDecimal totalCost = BigDecimal.ZERO;
        BigDecimal getDurationInMonths = BigDecimal.valueOf(project.getDurationInMonths());


        for (AbstractEmployee abstractEmployee : project.getTeam()) {
            totalCost = totalCost.add(abstractEmployee.getSalary().multiply(getDurationInMonths));
        }
        return totalCost;
    }

    public static ArrayList<AbstractEmployee> employeeWithSalaryInInterval(Project project, BigDecimal minSalary, BigDecimal maxSalary) {

        ArrayList<AbstractEmployee> employeeList = new ArrayList<>();

        for (AbstractEmployee tempEmployee : project.getTeam()) {

            if (tempEmployee.getSalary().compareTo(minSalary)>=0 && tempEmployee.getSalary().compareTo(maxSalary)<=0) {
                employeeList.add(tempEmployee);
            }

        }

        return employeeList;

    }


}
