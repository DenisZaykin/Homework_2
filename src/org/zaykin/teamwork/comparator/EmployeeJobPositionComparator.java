package org.zaykin.teamwork.comparator;

import org.zaykin.teamwork.abstractclass.AbstractEmployee;
import org.zaykin.teamwork.enumeration.JobPosition;

import java.util.Comparator;

/**
 * Created by DHM on 6/29/2017.
 */
public class EmployeeJobPositionComparator implements Comparator<AbstractEmployee> {

    @Override
    public int compare(AbstractEmployee e1, AbstractEmployee e2) {

        return JobPosition.valueOf(e1.getClass().getSimpleName().toUpperCase()).getSortOrder().compareTo(JobPosition.valueOf(e2.getClass().getSimpleName().toUpperCase()).getSortOrder());

    }

}