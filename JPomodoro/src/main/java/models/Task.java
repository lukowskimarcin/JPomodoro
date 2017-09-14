package models;

import javax.persistence.Entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

	private LongProperty id;
	private StringProperty name;
	private StringProperty description;
	private SimpleObjectProperty<Integer> pomodors;

	public Task() {
		id = new SimpleLongProperty();
		name = new SimpleStringProperty();
		description = new SimpleStringProperty();
		pomodors = new SimpleObjectProperty<Integer>();
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
	public final  Integer getPomodors() {
		return pomodors.get();
	}

	public final  void setPomodors(Integer pomodors) {
		this.pomodors.set(pomodors);
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

	public SimpleObjectProperty<Integer> pomodorsProperty() {
		return pomodors;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
