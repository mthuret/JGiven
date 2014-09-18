package com.tngtech.jgiven.report.model;

import java.util.List;

import com.google.common.collect.Lists;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.annotation.ScenarioStage;

public class GivenReportModels<SELF extends GivenReportModels<?>> extends Stage<SELF> {
    @ProvidedScenarioState
    protected List<ReportModel> reportModels = Lists.newArrayList();

    @ScenarioStage
    public GivenReportModel<?> givenReportModel;

    public SELF $_report_models( int n ) {
        for( int i = 0; i < n; i++ ) {
            a_report_model_with_name( "Test" + i );
        }

        return self();
    }

    public SELF a_report_model() {
        return a_report_model_with_name( "Test" );
    }

    public SELF a_report_model_with_name( String name ) {
        ReportModel reportModel = givenReportModel.a_report_model_with_name( name ).getReportModel();
        reportModels.add( reportModel );
        return self();
    }

    public SELF the_report_has_$_scenarios( int n ) {
        givenReportModel.the_report_has_$_scenarios( n );
        return self();
    }

    public SELF the_first_scenario_has_tag( String name ) {
        givenReportModel.the_first_scenario_has_tag( name );
        return self();
    }

    public SELF scenario_$_has_tag_$_with_value_$( int i, String name, String value ) {
        givenReportModel.scenario_$_has_tag_$_with_value_$( i, name, value );
        return self();
    }
}