package com.tngtech.jgiven.examples.datatable;

import static com.tngtech.jgiven.annotation.Table.HeaderType.VERTICAL;
import static java.util.Arrays.asList;

import java.util.List;

import org.junit.Test;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Table;
import com.tngtech.jgiven.junit.SimpleScenarioTest;

public class DataTableExamples extends SimpleScenarioTest<DataTableExamples.DataTableStage> {

    static class DataTableStage extends Stage<DataTableStage> {

        public DataTableStage a_list_of_lists_is_used_as_parameter(
                @Table List<List<String>> table ) {
            return self();
        }

        public DataTableStage a_list_of_POJOs_is_used_as_parameters(
                @Table TestCustomer... testCustomer ) {
            return self();
        }

        public DataTableStage a_list_of_POJOs_is_used_as_parameters_with_header_type_VERTICAL(
                @Table( header = VERTICAL ) TestCustomer... testCustomer ) {
            return self();
        }

        public void some_action_happens() {

        }

        public void a_single_POJO_is_used_as_parameters(
                @Table( header = VERTICAL ) TestCustomer testCustomer ) {}
    }

    static class TestCustomer {
        String name;
        String email;

        public TestCustomer( String name, String email ) {
            this.name = name;
            this.email = email;
        }
    }

    @Test
    public void a_list_of_list_can_be_used_as_table_parameter() {
        given().a_list_of_lists_is_used_as_parameter(
            asList(
                asList( "Name", "Email" ),
                asList( "John Doe", "john@doe.com" ),
                asList( "Jane Roe", "jane@row.com" ) )
            );
    }

    @Test
    public void a_list_of_POJOs_can_be_represented_as_data_tables() {
        given().a_list_of_POJOs_is_used_as_parameters(
            new TestCustomer( "John Doe", "john@doe.com" ),
            new TestCustomer( "Jane Roe", "jane@row.com" )
            );
    }

    @Test
    public void a_list_of_POJOs_can_be_represented_as_a_data_table_with_a_vertical_header() {
        given().a_list_of_POJOs_is_used_as_parameters_with_header_type_VERTICAL(
            new TestCustomer( "John Doe", "john@doe.com" ),
            new TestCustomer( "Jane Roe", "jane@row.com" )
            );
    }

    @Test
    public void a_single_POJO_can_be_represented_as_a_data_table() {
        given().a_single_POJO_is_used_as_parameters(
            new TestCustomer( "Jane Roe", "jane@row.com" )
            );
    }
}
