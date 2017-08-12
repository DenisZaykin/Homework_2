package org.zaykin.teamwork.enumeration;

/**
 * Created by DHM on 6/29/2017.
 */
public enum JobPosition {
    TEAMLEAD(Integer.valueOf(1)), CODEMONKEY(Integer.valueOf(2));

    private final Integer sortOrder;

    JobPosition (Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }
}
