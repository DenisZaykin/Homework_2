package org.zaykin.teamwork.entity;

import org.zaykin.teamwork.abstractclass.AbstractEmployee;

/**
 * Created by DHM on 6/29/2017.
 */
public class TeamLead extends AbstractEmployee{

    private PrivateJet privateJet;

    public TeamLead(String firstName, String lastName, String sex, float salary, float jetCost) {
        super(firstName, lastName, sex, salary);
        privateJet = new PrivateJet(jetCost);
    }

    public PrivateJet getPrivateJet() {
        return privateJet;
    }

    @Override
    public String toString() {
        return String.format("Team Lead: %s %s, $%s",this.getFirstName(), this.getLastName(), this.getSalary().toPlainString());
    }

}
