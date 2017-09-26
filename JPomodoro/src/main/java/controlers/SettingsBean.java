package controlers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.sun.javafx.binding.BidirectionalBinding;

import fxbase.AbstractModelView;
import fxbase.FXMLView;
import fxbase.enums.ViewMode;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import models.Settings;
import services.SettingsService;
import utils.DialogsUtil; 

@Scope("prototype")
@FXMLView(fxml="/fxml/Settings.fxml", bundle="/bundle/messages")
public class SettingsBean extends AbstractModelView<Settings> implements Initializable{
	
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
    private ChoiceBox<String> listSounds;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;
    

    @Override
	public void bindToView() {
		Settings settings = getData();
		labelPomodoroLenght.textProperty()
				.bind(Bindings.concat(sliderPomodoroLength.valueProperty().asString("%3.0f"), " min"));
		labelShortBreak.textProperty()
				.bind(Bindings.concat(sliderShortBreak.valueProperty().asString("%3.0f"), " min"));
		labelLongBreak.textProperty().bind(Bindings.concat(sliderLongBreak.valueProperty().asString("%3.0f"), " min"));
		sliderPomodoroLength.valueProperty()
				.addListener((obs, oldval, newVal) -> sliderPomodoroLength.setValue(Math.round(newVal.doubleValue())));
		sliderLongBreak.valueProperty()
				.addListener((obs, oldval, newVal) -> sliderLongBreak.setValue(Math.round(newVal.doubleValue())));
		sliderShortBreak.valueProperty()
				.addListener((obs, oldval, newVal) -> sliderShortBreak.setValue(Math.round(newVal.doubleValue())));
		
		listSounds.visibleProperty().bind(checkBoxSound.selectedProperty());
		listSounds.setItems(settings.getSounds());

		sliderPomodoroLength.valueProperty().bindBidirectional(settings.pomodoroLengthProperty());
		sliderLongBreak.valueProperty().bindBidirectional(settings.longBreakLengthProperty());
		sliderShortBreak.valueProperty().bindBidirectional(settings.shortBreakLengthProperty());
		checkBoxSound.selectedProperty().bindBidirectional(settings.soundProperty());
		listSounds.valueProperty().bindBidirectional(settings.alarmProperty());
		
	}

	@Override
	public void unBindToView() {
		Settings settings = getData();
		
		sliderPomodoroLength.valueProperty().unbindBidirectional(settings.pomodoroLengthProperty());
		sliderLongBreak.valueProperty().unbindBidirectional(settings.longBreakLengthProperty());
		sliderShortBreak.valueProperty().unbindBidirectional(settings.shortBreakLengthProperty());
		checkBoxSound.selectedProperty().unbindBidirectional(settings.soundProperty());
		listSounds.valueProperty().unbindBidirectional(settings.alarmProperty());
	}
	
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("initialize");
    	try {
    		prepareToEdit(); //Domyslnie tryb edycji
    		bindToView();
		} catch (Exception ex) {
			DialogsUtil.create().showException(ex);
		}
    }
    
    @FXML
    void onCancel(ActionEvent event) {
    	System.out.println("onCancel");
    	try {
			cancel();
			prepareToEdit();
		} catch (Exception ex) {
			DialogsUtil.create().showException(ex);
		}
    }

    @FXML
    void onSave(ActionEvent event) {
    	System.out.println("onSave");
    	try {
			save();
			prepareToEdit();
		} catch (Exception ex) {
			DialogsUtil.create().showException(ex);
		}
    }
    
    @Override
    protected boolean performUpdate(Settings data) throws Exception {
    	settingsService.save(data);
    	return true;
    }
    
}
