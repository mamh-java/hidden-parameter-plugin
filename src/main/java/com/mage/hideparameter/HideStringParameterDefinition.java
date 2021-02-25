package com.mage.hideparameter;

import net.sf.json.JSONObject;

import org.jenkinsci.Symbol;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

import javax.annotation.Nonnull;

import hudson.Extension;
import hudson.model.ParameterDefinition;
import hudson.model.ParameterValue;
import hudson.model.StringParameterDefinition;


public class HideStringParameterDefinition extends StringParameterDefinition {

    @DataBoundConstructor
    public HideStringParameterDefinition(String name, String defaultValue, String description, boolean trim) {
        super(name, defaultValue, description, trim);
    }

    @Nonnull
    public HideStringParameterDefinition(String name, String defaultValue, String description) {
        super(name, defaultValue, description);
    }

    public HideStringParameterDefinition(String name, String defaultValue) {
        super(name, defaultValue);
    }

    @Extension
    @Symbol({"hidestring", "hidestringParam"})
    public static class DescriptorImpl extends ParameterDescriptor {
        @Override
        public String getDisplayName() {
            return Messages.HideStringParameterDefinition_DisplayName();
        }

        @Override
        public String getHelpFile() {
            return "/help/parameter/string.html";
        }
    }

    @Override
    public ParameterDefinition copyWithDefaultValue(ParameterValue defaultValue) {
        if (defaultValue instanceof HideStringParameterValue) {
            HideStringParameterValue value = (HideStringParameterValue) defaultValue;
            return new HideStringParameterDefinition(getName(), value.getValue(), getDescription());
        } else {
            return this;
        }
    }

    @Override
    public HideStringParameterValue getDefaultParameterValue() {
        return new HideStringParameterValue(getName(), getDefaultValue(), getDescription());
    }


    public ParameterValue createValue(String str) {
        HideStringParameterValue value = new HideStringParameterValue(getName(), str, getDescription());
        if (isTrim()) {
            value.doTrim();
        }
        return value;
    }

    public ParameterValue createValue(StaplerRequest req, JSONObject jo) {
        HideStringParameterValue value = req.bindJSON(HideStringParameterValue.class, jo);
        value.setDescription(getDescription());
        return value;
    }

}
