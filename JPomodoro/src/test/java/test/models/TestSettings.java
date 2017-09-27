package test.models;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import models.Settings;
 

public class TestSettings {
	
	
	private Settings s = null;
	
	@Before
	public void init() {
		s = new Settings();
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
	}
	
	
	@Test
	public void testCopyEquals() throws CloneNotSupportedException {
		 Settings sCopy = (Settings) s.clone();
		 assertEquals(s.getAlarm(), sCopy.getAlarm());
		 assertNotSame(s, sCopy);
	}
	
	@Test
	public void testCopyChangeAlarm() throws CloneNotSupportedException {
		 Settings sCopy = (Settings) s.clone();
		 assertEquals(s.getAlarm(), sCopy.getAlarm());
		 sCopy.setAlarm("alarmCopy");
		 assertNotEquals(s.getAlarm(), sCopy.getAlarm());
	}
	

	@Test
	public void testCopySounds() throws CloneNotSupportedException {
		Settings sCopy = (Settings) s.clone();
		assertNotEquals(s, sCopy);
		assertEquals(sCopy.getSounds(), s.getSounds());
		
		sCopy.getSounds().remove(1);
		sCopy.getSounds().set(0, "test");
		assertNotEquals(sCopy.getSounds(), s.getSounds());
		
	}
	
	@Test
	public void testCopyPomodoroLength() throws CloneNotSupportedException {
		Settings sCopy = (Settings) s.clone();
		assertNotEquals(s, sCopy);
		assertEquals(sCopy.getPomodoroLength(), s.getPomodoroLength());
		
		sCopy.setPomodoroLength(0);
		assertNotEquals(sCopy.getPomodoroLength(), s.getPomodoroLength());
	}
	
	@Test
	public void testCopyShortBreakLength() throws CloneNotSupportedException {
		Settings sCopy = (Settings) s.clone();
		assertNotEquals(s, sCopy);
		assertEquals(sCopy.getShortBreakLength(), s.getShortBreakLength());
		
		sCopy.setShortBreakLength(0);
		assertNotEquals(sCopy.getShortBreakLength(), s.getShortBreakLength());
	}
	
	@Test
	public void testCopyLongBreakLength() throws CloneNotSupportedException {
		Settings sCopy = (Settings) s.clone();
		assertNotEquals(s, sCopy);
		assertEquals(sCopy.getLongBreakLength(), s.getLongBreakLength());
		
		sCopy.setLongBreakLength(0);
		assertNotEquals(sCopy.getLongBreakLength(), s.getLongBreakLength());
	}

}
