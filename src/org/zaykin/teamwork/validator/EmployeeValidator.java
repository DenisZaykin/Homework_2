package org.zaykin.teamwork.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zaykin.teamwork.enumeration.Gender;
import org.zaykin.teamwork.enumeration.JobPosition;

import java.util.EnumSet;

/**
 * Created by DHM on 6/29/2017.
 */
public class EmployeeValidator {


    private static final int ELEMENTS_COUNT=6;
    private static final int EMPLOYEE_TYPE_INDEX=0;
    private static final int GENDER_INDEX=3;
    private static final int SALARY_INDEX=4;
    private static final int JET_INDEX=5;

    private static final int TEAMLEAD_ELEMENT_COUNT = 6;
    private static final int CODEMONKEY_ELEMENT_COUNT = 5;

    private static final Logger LOGGER = LogManager.getLogger();

    public static boolean isValidParameters(String[] parameters) {

        boolean result = true;
        String tempString="";

        if (parameters == null || parameters.length ==0) {
            LOGGER.log(Level.WARN, "Empty list of parameters");
            result = false;
        }

        try {
            JobPosition.valueOf(parameters[EMPLOYEE_TYPE_INDEX].toUpperCase());
            Gender.valueOf(parameters[GENDER_INDEX].toUpperCase());

            if (JobPosition.valueOf(parameters[EMPLOYEE_TYPE_INDEX].toUpperCase()) == JobPosition.TEAMLEAD && parameters.length != TEAMLEAD_ELEMENT_COUNT
                    || JobPosition.valueOf(parameters[EMPLOYEE_TYPE_INDEX].toUpperCase()) == JobPosition.CODEMONKEY && parameters.length != CODEMONKEY_ELEMENT_COUNT) {
                LOGGER.log(Level.WARN, String.format("Wrong number of parameters. Expected: %d for %s, %d for %s; got: %d",TEAMLEAD_ELEMENT_COUNT, JobPosition.TEAMLEAD, CODEMONKEY_ELEMENT_COUNT, JobPosition.CODEMONKEY, parameters.length));
                result = false;
            }

        }
        catch (IllegalArgumentException e) {
            LOGGER.log(Level.WARN, String.format("Wrong employee or gender type. Expected: %s, %s got: %s, %s respectively", EnumSet.allOf(JobPosition.class), EnumSet.allOf(Gender.class), parameters[EMPLOYEE_TYPE_INDEX], parameters[GENDER_INDEX]));
            result = false;
        }


        try {
            for (int i=SALARY_INDEX; i<parameters.length; i++) {
                tempString = parameters[i]; //in case of exception will be used in a catch block
                Float.parseFloat(parameters[i]);

                if (Float.parseFloat(parameters[i]) <= 0) {
                    LOGGER.log(Level.WARN, String.format("%s cannot be equal or less than 0; got: %s", i==SALARY_INDEX?"Salary":"Jet price", parameters[i]));
                    result = false;
                }
            }

        }
        catch (NumberFormatException e) {
            LOGGER.log(Level.WARN, "%s is not a valid float number",tempString);
            result = false;
        }

        return result;

    }

    public static String[] normalizeParameters(String[] parameters) {
        String[] resultArray=new String[ELEMENTS_COUNT];
        resultArray[JET_INDEX] = "0";
        System.arraycopy(parameters, 0, resultArray, 0, parameters.length);
        resultArray[EMPLOYEE_TYPE_INDEX] = resultArray[EMPLOYEE_TYPE_INDEX].toUpperCase();
        resultArray[GENDER_INDEX] = resultArray[GENDER_INDEX].toUpperCase();
        return resultArray;
    }

}
