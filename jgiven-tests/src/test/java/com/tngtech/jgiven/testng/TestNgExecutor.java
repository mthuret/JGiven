package com.tngtech.jgiven.testng;

import com.tngtech.jgiven.testframework.TestExecutionResult;
import com.tngtech.jgiven.testframework.TestExecutor;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import com.tngtech.jgiven.base.ScenarioTestBase;
import com.tngtech.jgiven.impl.Config;
import com.tngtech.jgiven.report.model.ReportModel;

public class TestNgExecutor extends TestExecutor {

    public static String methodName;

    @Override
    public TestExecutionResult execute( Class<?> testClass, String testMethod ) {
        TestNgExecutionResult result = new TestNgExecutionResult();
        ScenarioTestListenerAdapter testListenerAdapter = new ScenarioTestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses( new Class<?>[] { testClass } );
        if( testMethod != null ) {
            methodName = testMethod;
            testng.addMethodSelector( MethodSelector.class.getName(), 10 );
        }
        testng.addListener( testListenerAdapter );
        Config.config().setReportEnabled( false );
        testng.run();
        Config.config().setReportEnabled( true );
        result.reportModel = testListenerAdapter.reportModel;
        result.testResult = testListenerAdapter.testResult;
        return result;
    }

    @Override
    public TestExecutionResult execute( Class<?> testClass ) {
        return execute( testClass, null );
    }

    static class ScenarioTestListenerAdapter extends TestListenerAdapter {
        ReportModel reportModel;
        ITestResult testResult;

        @Override
        public void onTestSuccess( ITestResult tr ) {
            setTestResult( tr );
        }

        @Override
        public void onTestFailure( ITestResult tr ) {
            setTestResult( tr );
        }

        @Override
        public void onTestSkipped( ITestResult tr ) {
            setTestResult( tr );
        }

        @Override
        public void onStart( ITestContext testContext ) {
            // TODO Auto-generated method stub
            super.onStart( testContext );
        }

        private void setTestResult( ITestResult tr ) {
            testResult = tr;
            reportModel = ( (ScenarioTestBase<?, ?, ?>) tr.getInstance() ).getScenario().getModel();
        }
    }

}
