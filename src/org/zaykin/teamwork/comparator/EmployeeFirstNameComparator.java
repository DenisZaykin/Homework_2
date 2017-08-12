package org.zaykin.teamwork.comparator;

import org.zaykin.teamwork.abstractclass.AbstractEmployee;

import java.util.Comparator;

/**
 * Created by DHM on 6/29/2017.
 */
public class EmployeeFirstNameComparator implements Comparator<AbstractEmployee> {

    @Override
    public int compare(AbstractEmployee e1, AbstractEmployee e2) {
        return e1.getFirstName().compareTo(e2.getFirstName());
    }

}
