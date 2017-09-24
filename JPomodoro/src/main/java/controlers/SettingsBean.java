package controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import fxbase.AbstractModelView;
import fxbase.FXMLView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import models.Settings;
import models.Task;
import services.SettingsService;
import services.TaskService;
import utils.DialogsUtil; 

@Scope("prototype")
@FXMLView(fxml="/fxml/Settings.fxml", bundle="/bundle/messages")
public class SettingsBean extends AbstractModelView<Settings>{
	
	
	@Autowired
	private SettingsService settingsService;
	
	 
    @FXML
    private Slider sliderPomodoroLength;

    @FXML
    private Label labelPomodoroLenght;

    @FXML
    private Label labelLongBreak;

    @FXML
    private Label labelShortBreak;

    @FXML
    private Slider sliderLongBreak;

    @FXML
    private Slider sliderShortBreak;

    @FXML
    private CheckBox checkBoxSound;

    @FXML
    private ChoiceBox<?> listSounds;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

    @Override
	public void bindToView(Settings settings) {
	}
	
	@Override
	public void unBindToView() {
	}
    
    
    @FXML
    void onCancel(ActionEvent event) {

    }

    @FXML
    void onSave(ActionEvent event) {
    	try {
			applay();
		} catch (Exception ex) {
			DialogsUtil.create().showException(ex);
		}
    }


	
}
