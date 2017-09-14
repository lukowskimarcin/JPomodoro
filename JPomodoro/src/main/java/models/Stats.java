package models;


import fxbase.Dto;
import javafx.beans.property.IntegerProperty;

public class Stats  extends Dto {
	
	private  IntegerProperty averageEstimatedPomodoros;
	private  IntegerProperty averageWorkedPomodoros;
	private  IntegerProperty averageEstimatedPomodorosPerDay;
	private  IntegerProperty averageWorkedPomodorosPerDay;
	private  IntegerProperty maxWorkedPomodorosPerDay;
	
}
