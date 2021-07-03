package com.draz.Exploration;

import joinery.DataFrame;

import java.awt.Color;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler.LegendPosition;


public class EDA {
	String filePath;
	List<Passenger> passengers = new ArrayList<Passenger>(); 
	public EDA(String filePath) throws IOException{
		this.filePath = filePath;
        DataFrame <Object> df =  DataFrame.readCsv("/home/draz/Downloads/java/Day5/Data_to_use/titanic.csv");
        
        for (int i=0;i<df.length();i++) {
        	Passenger passenger = new Passenger(String.valueOf(df.get(i, 0)),
        			String.valueOf(df.get(i, 1)),
        			String.valueOf(df.get(i, 2)),
        			String.valueOf(df.get(i, 3)),
        			(Double)df.get(i, 4),
        			String.valueOf(df.get(i, 5)),
        			String.valueOf(df.get(i, 6)),
        			String.valueOf(df.get(i, 7)),
        			(Double)df.get(i, 8),
        			String.valueOf(df.get(i, 8)),
        			String.valueOf(df.get(i, 9)),
        			String.valueOf(df.get(i, 10)),
        			String.valueOf(df.get(i, 11)),
        			String.valueOf(df.get(i, 12))); 
        	passengers.add(passenger);
        }   
	}
	
	public void getPassenger() {
		 this.passengers.stream()
		 .filter(x->x.getSurvived().equals("1"))
		 .forEach(x->System.out.println(x.getSurvived()));
	}
	
	public void graphPassengerAges() {
		//filter to get an array of passenger ages
		List<Double> pAges = passengers.stream ()
				.map (Passenger::getAge)
				.limit (8)
				.collect (Collectors.toList ());
		List<String> pNames = passengers.stream ()
				.map (Passenger::getName)
				.limit (8)
				.collect (Collectors.toList ());
		//Using XCart to graph the Ages 1.Create Chart
		CategoryChart chart = new CategoryChartBuilder ().width (1024).height(768)
				.title ("Age Histogram")
				.xAxisTitle ("Names")
				.yAxisTitle("Age")
				.build();
		// 2.Customize Chart
		chart.getStyler ().setLegendPosition (LegendPosition.InsideNW);
		chart.getStyler ().setHasAnnotations (true);
		chart.getStyler ().setStacked (true);
		// 3.Series
		chart.addSeries ("Passenger's Ages", pNames,pAges);
		// 4.Show it
		new SwingWrapper (chart).displayChart ();
	}
	
	public void graphPassengerClass() {
		Map<String, Long> result =
				passengers.stream().collect (
				Collectors.groupingBy(Passenger::getPclass, Collectors.counting()));
		// Create Chart
		PieChart chart = new PieChartBuilder ()
				.width (800).height (600)
				.title (getClass ().getSimpleName ())
				.build ();
		// Customize Chart
		Color[] sliceColors = new Color[]{new Color(180, 68, 50),
										  new Color (130, 105, 120),
										  new Color (80, 143, 160),
										  new Color (130, 80, 100)
										  };
		chart.getStyler ().setSeriesColors (sliceColors);

		// Series
		chart.addSeries ("First Class", result.get ("1"));
		chart.addSeries ("Second Class", result.get ("2"));
		chart.addSeries ("Third Class", result.get ("3"));

		// Show it
		new SwingWrapper (chart).displayChart ();
	}
	
	public void graphPassengersurvived() {
		Map<String, Long> result =
				passengers.stream ().collect (
				Collectors.groupingBy (Passenger::getSurvived, Collectors.counting () ) );
		// Create Chart
				PieChart chart = new PieChartBuilder ()
						.width (800).height (600)
						.title (getClass ().getSimpleName ())
						.build ();
				// Customize Chart
				Color[] sliceColors = new Color[]{new Color(180, 68, 50),
												  new Color (130, 105, 120),
												  };
				chart.getStyler ().setSeriesColors (sliceColors);

				// Series
				chart.addSeries ("Not Survived", result.get ("0"));
				chart.addSeries ("Survived", result.get ("1"));
				// Show it
				new SwingWrapper (chart).displayChart ();
	}
	
	public void graphPassengersurvivedGender() {
		Map<String, Long> result =
				passengers.stream ().filter(x->x.getSurvived().equals("1"))
				.collect(Collectors.groupingBy (Passenger::getSex, Collectors.counting () ) );
		// Create Chart
		PieChart chart = new PieChartBuilder ()
				.width (800).height (600)
				.title (getClass().getSimpleName())
				.build ();
		// Customize Chart
		Color[] sliceColors = new Color[]{new Color(180, 68, 50),
										  new Color (130, 105, 120),
										  };
		chart.getStyler ().setSeriesColors(sliceColors);

		// Series
		chart.addSeries ("Female Survived", result.get ("female"));
		chart.addSeries ("Male Survived", result.get ("male"));
		// Show it
		new SwingWrapper (chart).displayChart ();
	}
	
}
