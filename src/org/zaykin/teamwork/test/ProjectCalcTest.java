package org.zaykin.teamwork.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.zaykin.teamwork.calc.ProjectCalc;
import org.zaykin.teamwork.comparator.EmployeeSalaryComparator;
import org.zaykin.teamwork.entity.Project;
import org.zaykin.teamwork.pattern.EmployeeFactory;

import java.math.BigDecimal;

/**
 * Created by DHM on 7/4/2017.
 */
public class ProjectCalcTest {

    private static Project project;
    private static final String PROJECT_NAME="Project 2";
    private static final int PROJECT_DURATION=10;

    @BeforeClass
    public static void createProject() throws Exception {

        project = new Project(PROJECT_NAME, PROJECT_DURATION);
        project.addTeamMember(EmployeeFactory.makeEmployee("TEAMLEAD", "John", "Doe", "MALE", 100.0f, 100.0f));
        project.addTeamMember(EmployeeFactory.makeEmployee("CODEMONKEY", "Jane", "Doe", "FEMALE", 50.0f, 0.0f));
        project.addProjectLead();
        project.getTeamReference().sort(new EmployeeSalaryComparator());
    }

    @Test
    public void manHours() {
        Assert.assertEquals(440, ProjectCalc.manHours(project), 0);
    }

    @Test
    public void cost() {
        Assert.assertEquals( 1500, ProjectCalc.cost(project).floatValue(), 0);
    }

    @Test
    public void employeeWithSalaryInInterval() {
        Assert.assertEquals( project.getTeam().get(1).getEmployeeId().toString(), ProjectCalc.employeeWithSalaryInInterval(project, new BigDecimal("70"), new BigDecimal("110")).get(0).getEmployeeId().toString());
    }

}
