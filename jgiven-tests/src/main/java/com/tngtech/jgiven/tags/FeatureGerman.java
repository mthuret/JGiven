package com.tngtech.jgiven.tags;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.tngtech.jgiven.annotation.IsTag;

@IsTag( type = "Feature", value = "German Scenarios", description = "Scenarios can be written in German" )
@Retention( RetentionPolicy.RUNTIME )
public @interface FeatureGerman {

}
