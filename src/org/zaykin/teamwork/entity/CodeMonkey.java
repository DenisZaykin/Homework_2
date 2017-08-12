package org.zaykin.teamwork.entity;

import org.zaykin.teamwork.abstractclass.AbstractEmployee;

import java.util.UUID;

/**
 * Created by DHM on 6/29/2017.
 */
public class CodeMonkey extends AbstractEmployee{

    private UUID teamLeadID;

    public CodeMonkey(String firstName, String lastName, String sex, float salary) {
        super(firstName, lastName, sex, salary);
    }

    public void setTeamLeadID(UUID teamLeadID) {
        this.teamLeadID = teamLeadID;
    }

    public UUID getTeamLeadID() {
        return teamLeadID;
    }

    @Override
    public String toString() {
        return String.format("Developer: %s %s, $%s",this.getFirstName(), this.getLastName(), this.getSalary().toPlainString());
    }

}
