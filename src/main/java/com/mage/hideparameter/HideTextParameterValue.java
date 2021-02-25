package com.mage.hideparameter;

import org.kohsuke.stapler.DataBoundConstructor;

import hudson.model.TextParameterValue;


public class HideTextParameterValue extends TextParameterValue {

    private static final long serialVersionUID = 6926027508686211675L;

    @DataBoundConstructor
    public HideTextParameterValue(String name, String value) {
        super(name, value);
    }

    public HideTextParameterValue(String name, String value, String description) {
        super(name, value, description);
    }

    @Override
    public String toString() {
        return "(HideTextParameterValue) " + getName() + "='" + getValue() + "'";
    }
}
