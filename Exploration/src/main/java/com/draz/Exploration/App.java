package com.draz.Exploration;

import java.awt.List;
import java.io.IOException;

import joinery.DataFrame;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        //DataFrame <Object> df =  DataFrame.readCsv("/home/draz/Downloads/java/Day5/Data_to_use/titanic.csv");
        /**************************************************/
        //System.out.println(df.col("survived"));
        //System.out.println("\t\t\t\t\tData Exploration");
        //System.out.println("DataFrame Columns:");
        //df.columns().stream().forEach(x->System.out.print(x+"\t"));
        //System.out.print("\n");
        //df.types().stream().forEach(x->System.out.print(x+"\n"));
        /************************************ Numerical Summaries **************************************/
        //System.out.println("\n\t\t\t\t\tNumerical Data Summaries.");
        //System.out.println(df.describe().transpose());
        /*********************************** ****************************************/
        //System.out.println(df.unique("sex"));
        //System.out.println(df.col("").u);
    	//Object x = 10;
    	//System.out.println(x);
    	EDA titanicEDA = new EDA("/home/draz/Downloads/java/Day5/Data_to_use/titanic.csv");
    	
    	titanicEDA.getPassenger();
    	titanicEDA.graphPassengerClass();
        titanicEDA.graphPassengersurvived();
        titanicEDA.graphPassengersurvivedGender();
        titanicEDA.graphPassengerAges();
    	System.out.println(titanicEDA.survivalSummary());
    	System.out.println(titanicEDA.genderSummary());
    	System.out.println(titanicEDA.ageSummary());
        System.out.println(titanicEDA.fareSummary());
    }
}
