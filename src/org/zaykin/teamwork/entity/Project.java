package org.zaykin.teamwork.entity;

import com.sun.org.apache.bcel.internal.classfile.Code;
import org.zaykin.teamwork.abstractclass.AbstractEmployee;
import org.zaykin.teamwork.comparator.EmployeeFirstNameComparator;
import org.zaykin.teamwork.comparator.EmployeeJobPositionComparator;
import org.zaykin.teamwork.comparator.EmployeeSalaryComparator;

import java.util.*;

/**
 * Created by DHM on 6/29/2017.
 */
public class Project {

    private String title;
    private int durationInMonths;

    //private Map<UUID, AbstractEmployee> team = new HashMap<>();
    private ArrayList<AbstractEmployee> team = new ArrayList<>();

    public Project(String title, int durationInDays) {
        this.title = title;
        this.durationInMonths = durationInDays;
    }

    public void setDurationInDays(int durationInMonths) {
        this.durationInMonths = durationInMonths;
    }

    public String getTitle() {
        return title;
    }

    public int getDurationInMonths() {
        return durationInMonths;
    }

    public ArrayList<AbstractEmployee> getTeam() {
        return new ArrayList<AbstractEmployee>(this.team);
    }

    public ArrayList<AbstractEmployee> getTeamReference() {
        return this.team;
    }

    public void addTeamMember(AbstractEmployee abstractEmployee) {
        team.add(abstractEmployee);
    }

    public void addProjectLead() {

        this.team.sort(new EmployeeJobPositionComparator().thenComparing(new EmployeeSalaryComparator()).reversed());

        if (!this.team.isEmpty() && this.team.get(0) instanceof TeamLead) {

            for (int i = 1; i < this.team.size(); i++) {
                if (this.team.get(i) instanceof CodeMonkey) {
                    ((CodeMonkey) this.team.get(i)).setTeamLeadID(this.team.get(0).getEmployeeId());
                }
            }
        }

    }

    public void removeTeamMember(AbstractEmployee abstractEmployee) {
        for (int i=0; i<this.team.size(); i++) {
            if (abstractEmployee.equals(this.team.get(i))) {
                this.team.remove(i);
                break;
            }
        }
    }

}
