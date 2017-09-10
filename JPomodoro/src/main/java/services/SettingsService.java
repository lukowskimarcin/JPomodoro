package services;

import java.io.File;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.springframework.stereotype.Service;

import model.Settings;

@Service
public class SettingsService {

	public Settings load() throws Exception {
		Serializer serializer = new Persister();
		File source = new File("settings.xml");

		Settings settings = serializer.read(Settings.class, source);
		return settings;
	}

	public void save(Settings settings) throws Exception {
		Serializer serializer = new Persister();
		File result = new File("settings.xml");
		serializer.write(settings, result);
	}

}
