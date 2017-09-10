package services;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import model.Settings;

@Service
public class SettingsService {

	public Settings load() throws Exception {
		File file = new File("settings.xml");
		JAXBContext context = JAXBContext.newInstance(Settings.class);
		Unmarshaller um = context.createUnmarshaller();
		Settings settings = (Settings)um.unmarshal(file);
		
		return settings;
	}

	public void save(Settings settings) throws Exception {
		File result = new File("settings.xml");
		JAXBContext context = JAXBContext.newInstance(Settings.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(settings, result);
	}

}
