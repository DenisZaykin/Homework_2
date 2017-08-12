package org.zaykin.teamwork.pattern;

import org.zaykin.teamwork.abstractclass.AbstractEmployee;
import org.zaykin.teamwork.entity.CodeMonkey;
import org.zaykin.teamwork.entity.TeamLead;
import org.zaykin.teamwork.exception.ParameterFormatException;

/**
 * Created by DHM on 6/29/2017.
 */

public class EmployeeFactory {
    public static AbstractEmployee makeEmployee (String employeeType, String firstName, String lastName, String sex, float salary, float jetCost) throws ParameterFormatException {
        AbstractEmployee abstractEmployee = null;

        switch (employeeType) {
            case "TEAMLEAD":
                abstractEmployee = new TeamLead(firstName, lastName, sex, salary, jetCost);
                break;
            case "CODEMONKEY":
                abstractEmployee = new CodeMonkey(firstName, lastName, sex, salary);
                break;
            default:
                throw new ParameterFormatException(String.format("Wrong object type has been passed to the factory method: %s", employeeType));
        }

        return abstractEmployee;

    }

}
