package models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import fxbase.Dto;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Ustawienia aplikacji
 * 
 * @author Marcin
 *
 */

@XmlRootElement(name = "settings")
public class Settings extends Dto {
	private static final long serialVersionUID = -9131733979141926279L;

	private final IntegerProperty pomodoroLength = new SimpleIntegerProperty();

	private final IntegerProperty shortBreakLength = new SimpleIntegerProperty();

	private final IntegerProperty longBreakLength = new SimpleIntegerProperty();

	private final BooleanProperty sound = new SimpleBooleanProperty();

	private final StringProperty alarm = new SimpleStringProperty();

	private final ObservableList<String> sounds = FXCollections.observableList(new ArrayList<String>());

	public IntegerProperty pomodoroLengthProperty() {
		return pomodoroLength;
	}

	public Integer getPomodoroLength() {
		return pomodoroLength.get();
	}

	public void setPomodoroLength(Integer pomodoroLength) {
		this.pomodoroLength.set(pomodoroLength);
	}

	public IntegerProperty shortBreakLengthProperty() {
		return shortBreakLength;
	}

	public Integer getShortBreakLength() {
		return shortBreakLength.get();
	}

	public void setShortBreakLength(Integer shortBreakLength) {
		this.shortBreakLength.set(shortBreakLength);
	}

	public IntegerProperty longBreakLengthProperty() {
		return longBreakLength;
	}

	public Integer getLongBreakLength() {
		return longBreakLength.get();
	}

	public void setLongBreakLength(Integer longBreakLength) {
		this.longBreakLength.set(longBreakLength);
	}

	public BooleanProperty soundProperty() {
		return sound;
	}

	public Boolean getSound() {
		return sound.get();
	}

	public void setSound(Boolean sound) {
		this.sound.set(sound);
	}

	public StringProperty alarmProperty() {
		return alarm;
	}

	public String getAlarm() {
		return alarm.get();
	}

	public void setAlarm(String alarm) {
		this.alarm.set(alarm);
	}


	@XmlElementWrapper(name = "sounds")
	@XmlElement(name = "sound", type = String.class)
	public ObservableList<String> getSounds() {
		return sounds;
	}

	public void setSounds(List<String> list) {
		sounds.clear();
		sounds.addAll(list);
	}

	public String getAlarmPath() {
		String musicFile = this.getClass().getResource("/sounds/" +    alarm.get()  ).toExternalForm();
		return musicFile;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	@Override
	public Settings clone() throws CloneNotSupportedException {
		Settings copy = new Settings();

		if (getAlarm() != null) {
			copy.setAlarm(getAlarm());
		}

		List<String> copyList = new ArrayList<>();
		for (String s : getSounds()) {
			copyList.add(s);
		}
		copy.setSounds(copyList);

		if (getLongBreakLength() != null) {
			copy.setLongBreakLength(getLongBreakLength());
		}

		if (getShortBreakLength() != null) {
			copy.setShortBreakLength(getShortBreakLength());
		}

		if (getPomodoroLength() != null) {
			copy.setPomodoroLength(getPomodoroLength());
		}

		
		if (getSound() != null) {
			copy.setSound(getSound());
		}

		System.out.println("copy: " + copy);
		return copy;
	}
	
}
