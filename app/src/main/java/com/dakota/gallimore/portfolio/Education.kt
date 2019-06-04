package com.dakota.gallimore.portfolio

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup

/**
 * Created by Dakota on 10/26/2017.
 */

class Education(title: String, items: List<ChildEducation>) : ExpandableGroup<ChildEducation>(title, items)
