package org.zaykin.teamwork.entity;

/**
 * Created by DHM on 6/29/2017.
 */
public class PrivateJet {

    private final float cost;

    public PrivateJet(float cost) {
        this.cost = cost;
    }

    public String noiseSound(){
        return "A plane says rrrrr";
    }

}
