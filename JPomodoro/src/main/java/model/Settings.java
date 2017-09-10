package model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/**
 * Ustawienia aplikacji
 * 
 * @author Marcin
 *
 */

@Root
public class Settings {

	@Element
	private int pomodoroLength;
	
	@Element
	private int shortBreakLength;

	@Element
	private int longBreakLength;
	
	@Element
	private boolean sound;
	
	@Element
	private String alarm;
	
	@ElementList(entry="file")
	private List<String> alarms = new ArrayList<String>();

	public int getPomodoroLength() {
		return pomodoroLength;
	}

	public void setPomodoroLength(int pomodoroLength) {
		this.pomodoroLength = pomodoroLength;
	}

	public int getShortBreakLength() {
		return shortBreakLength;
	}

	public void setShortBreakLength(int shortBreakLength) {
		this.shortBreakLength = shortBreakLength;
	}

	public int getLongBreakLength() {
		return longBreakLength;
	}

	public void setLongBreakLength(int longBreakLength) {
		this.longBreakLength = longBreakLength;
	}

	public boolean isSound() {
		return sound;
	}

	public void setSound(boolean sound) {
		this.sound = sound;
	}

	public String getAlarm() {
		return alarm;
	}

	public void setAlarm(String alarm) {
		this.alarm = alarm;
	}

	public List<String> getAlarms() {
		return alarms;
	}

	public void setAlarms(List<String> alarms) {
		this.alarms = alarms;
	}
	
	
	 public String toString() {
		    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
		 }
}
