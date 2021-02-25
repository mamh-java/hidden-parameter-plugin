package com.mage.hideparameter;

import net.sf.json.JSONObject;

import org.jenkinsci.Symbol;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

import javax.annotation.Nonnull;

import hudson.Extension;
import hudson.model.ParameterValue;
import hudson.model.StringParameterDefinition;
import hudson.model.TextParameterDefinition;
import hudson.model.TextParameterValue;


public class HideTextParameterDefinition extends TextParameterDefinition {
    @DataBoundConstructor
    public HideTextParameterDefinition(String name, String defaultValue, String description) {
        super(name, defaultValue, description);
    }

    @Extension
    @Symbol({"hidetext", "hidetextParam"})
    public static class DescriptorImpl extends ParameterDescriptor {
        @Override
        public String getDisplayName() {
            return Messages.HideTextParameterDefinition_DisplayName();
        }

        @Override
        public String getHelpFile() {
            return "/help/parameter/string.html";
        }
    }

    @Override
    public ParameterValue createValue(StaplerRequest req, JSONObject jo) {
        HideTextParameterValue value = req.bindJSON(HideTextParameterValue.class, jo);
        value.setDescription(getDescription());
        return value;
    }

    @Override
    public ParameterValue createValue(String value) {
        return new HideTextParameterValue(getName(), value, getDescription());
    }

}
