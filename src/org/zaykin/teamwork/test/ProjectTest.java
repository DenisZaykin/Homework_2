package org.zaykin.teamwork.test;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.zaykin.teamwork.abstractclass.AbstractEmployee;
import org.zaykin.teamwork.comparator.EmployeeLastNameComparator;
import org.zaykin.teamwork.comparator.EmployeeSalaryComparator;
import org.zaykin.teamwork.entity.Project;
import org.zaykin.teamwork.file.FileOperation;
import org.zaykin.teamwork.parser.DataParser;
import org.zaykin.teamwork.pattern.EmployeeFactory;
import org.zaykin.teamwork.validator.EmployeeValidator;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by DHM on 6/29/2017.
 */
public class ProjectTest {

    private static Project project;
    private static final String FILE_NAME = "data\\employees.txt";
    private static final String DELIMITER = ";";
    private static final String PROJECT_NAME="Project 1";
    private static final int PROJECT_DURATION=5;

    private static final int EMPLOYEE_TYPE_INDEX=0;
    private static final int FIRST_NAME_INDEX=1;
    private static final int LAST_NAME_INDEX=2;
    private static final int GENDER_INDEX=3;
    private static final int SALARY_INDEX=4;
    private static final int JET_PRICE_INDEX=5;

    private static final BigDecimal MIN_SALARY = new BigDecimal("900");
    private static final BigDecimal MAX_SALARY = new BigDecimal("1100");

    private static final Logger LOGGER = LogManager.getLogger();


    @BeforeClass
    public static void createProject() throws Exception {

        ArrayList<String> linesFromFile = FileOperation.readDataFromFile(FILE_NAME);
        project = new Project(PROJECT_NAME, PROJECT_DURATION);

        for (int lineNumber=0; lineNumber<linesFromFile.size(); lineNumber++) {
            String[] parsedLine = DataParser.parseLine(linesFromFile.get(lineNumber), DELIMITER, lineNumber+1);
            if (EmployeeValidator.isValidParameters(parsedLine)) {
                parsedLine = EmployeeValidator.normalizeParameters(parsedLine);
                AbstractEmployee tempAbstractFigure = EmployeeFactory.makeEmployee(parsedLine[EMPLOYEE_TYPE_INDEX], parsedLine[FIRST_NAME_INDEX], parsedLine[LAST_NAME_INDEX], parsedLine[GENDER_INDEX],Float.parseFloat(parsedLine[SALARY_INDEX]),Float.parseFloat(parsedLine[JET_PRICE_INDEX]));
                project.addTeamMember(tempAbstractFigure);
            }

        project.addProjectLead();
        }

        ArrayList<AbstractEmployee> teamMembers= project.getTeam();

        for (AbstractEmployee abstractEmployee : teamMembers) {
            System.out.println(abstractEmployee);
        }

        teamMembers.sort(new EmployeeLastNameComparator().thenComparing(new EmployeeSalaryComparator()));

        for (AbstractEmployee abstractEmployee : teamMembers) {
            if (MIN_SALARY.compareTo(abstractEmployee.getSalary()) <= 0 && MAX_SALARY.compareTo(abstractEmployee.getSalary())>=0) {
                LOGGER.log(Level.INFO,abstractEmployee);
            }
        }

    }

    @Test
    public void myTest() {
        Assert.assertEquals(4,project.getTeam().size(),0);
    }
}
