package test.models;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import models.Settings;
 

public class TestSettings {

	@Test
	public void testClone() throws CloneNotSupportedException {
		 Settings s = new Settings();
		 s.setAlarm("alarm1");
		 s.setLongBreakLength(15);
		 s.setPomodoroLength(25);
		 s.setShortBreakLength(5);
		 s.setSound(false);
		 
		 List<String> sounds = new ArrayList<>();
		 sounds.add("alarm1");
		 sounds.add("alarm2");
		 sounds.add("alarm3");
		 s.setSounds(sounds);
		 
		 
		 Settings sCopy = (Settings) s.clone();
		 sCopy.setAlarm("alarmCopy");
		 
		 assertNotEquals(s.getAlarm(), sCopy.getAlarm());
		 assertEquals(s.getLongBreakLength(), sCopy.getLongBreakLength());
		 
		 assertNotEquals(s, sCopy);
	}

}
