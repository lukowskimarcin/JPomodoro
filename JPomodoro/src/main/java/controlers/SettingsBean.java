package controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import fxbase.AbstractModelView;
import fxbase.FXMLView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.Settings;
import services.SettingsService;
import utils.DialogsUtil; 

@Scope("prototype")
@FXMLView(fxml="/fxml/Settings.fxml", bundle="/bundle/messages")
public class SettingsBean extends AbstractModelView<Settings>{
	
	@FXML
    private Button bPlay;
	
	@FXML
    private Button bSave;
	
	@Autowired
	private SettingsService settingsService;
	 

    @FXML
    void onPlay(ActionEvent event) {
    	Media sound = new Media(getData().getAlarmPath());
    	MediaPlayer mediaPlayer = new MediaPlayer(sound);
    	mediaPlayer.play();
    }
    
    @FXML
    void onSave(ActionEvent event) {
    	try {
//    		Settings s = new Settings();
//    		s.setPomodoroLength(25);
//    		s.setLongBreakLength(15);
//    		s.setShortBreakLength(5);
//    		
//    		s.setAlarm("Buzzer.mp3");
//    		
//    		List<String> sounds = new ArrayList<>();
//    		sounds.add("Buzzer.mp3");
//    		sounds.add("LoudAlarmClockBuzzer.mp3");
//    		sounds.add("TempleBellBigger.mp3");
//    		s.setSounds(sounds);
//    		
    		
    		settingsService.save(getData());
    	}catch (Exception ex) {
			DialogsUtil.create().showException(ex);
		}

    }
	
}
