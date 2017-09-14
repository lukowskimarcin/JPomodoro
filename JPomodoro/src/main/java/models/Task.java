package models;

import javax.persistence.Entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import fxbase.Dto;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task extends Dto {
	private static final long serialVersionUID = 1L;
	private LongProperty id;
	private StringProperty name;										//nazwa 
	private StringProperty description;									//opis
	private SimpleObjectProperty<Integer> estimatedPomodors;			//przewidywane pomidory	
	private SimpleObjectProperty<Integer> usedPomodoro;					//zużyte pomidory
	private SimpleObjectProperty<Date> date;							//data zadania
	private BooleanProperty complete;									//wykonane zadanie
	

	public Task() {
		id = new SimpleLongProperty();
		name = new SimpleStringProperty();
		description = new SimpleStringProperty();
		estimatedPomodors = new SimpleObjectProperty<Integer>();
		usedPomodoro = new SimpleObjectProperty<Integer>();
		date = new SimpleObjectProperty<Date>(new Date());
		complete = new SimpleBooleanProperty();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public final  Long getId() {
		return id.get();
	}

	public final  void setId(Long id) {
		this.id.set(id);
	}

	@Column
	public final String getName() {
		return name.get();
	}

	public final  void setName(String name) {
		this.name.set(name);
	}

	@Column
	public final  String getDescription() {
		return description.get();
	}

	public final  void setDescription(String description) {
		this.description.set(description);
	}

	@Column
	public final  Integer getEstimatedPomodors() {
		return estimatedPomodors.get();
	}

	public final  void setEstimatedPomodors(Integer pomodors) {
		this.estimatedPomodors.set(pomodors);
	}
	
	@Column
	public final  Integer getUsedPomodoro() {
		return usedPomodoro.get();
	}

	public final  void setUsedPomodoro(Integer pomodors) {
		this.usedPomodoro.set(pomodors);
	}
	
	@Column
	public final  Date getDate() {
		return date.get();
	}

	public final  void setDate(Date date) {
		this.date.set(date);
	}
	
	@Column
	public final  Boolean getComplete() {
		return complete.get();
	}

	public final  void setComplete(Boolean complete) {
		this.complete.set(complete);
	}

	public LongProperty idProperty() {
		return id;
	}

	public StringProperty nameProperty() {
		return name;
	}

	public StringProperty descriptionProperty() {
		return description;
	}

	public SimpleObjectProperty<Integer> estimatedPomodorsProperty() {
		return estimatedPomodors;
	}
	
	public SimpleObjectProperty<Integer> usedPomodoroProperty() {
		return usedPomodoro;
	}
	
	public SimpleObjectProperty<Date> dateProperty() {
		return date;
	}
	
	public BooleanProperty descriptionComplete() {
		return complete;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
