package com.mage.hideparameter;

import hudson.model.StringParameterValue;

import org.kohsuke.stapler.DataBoundConstructor;


public class HideStringParameterValue extends StringParameterValue {

    private static final long serialVersionUID = 6926027508686211675L;

    @DataBoundConstructor
    public HideStringParameterValue(String name, String value) {
        super(name, value);
    }

    public HideStringParameterValue(String name, String value, String description) {
        super(name, value, description);
    }

    @Override
    public String toString() {
        return "(HideStringParameterValue) " + getName() + "='" + getValue() + "'";
    }
}
