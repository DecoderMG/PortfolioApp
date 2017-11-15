package com.dakota.gallimore.portfolio;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by Dakota on 10/26/2017.
 */

public class Education extends ExpandableGroup<ChildEducation> {

    public Education(String title, List<ChildEducation> items) {
        super(title, items);
    }


}
