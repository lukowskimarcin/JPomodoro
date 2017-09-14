package controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import fxbase.AbstractModelView;
import fxbase.FXMLView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
	
	@FXML
    private Button bPlay;
	
	@FXML
    private Button bSave;
	
	@Autowired
	private SettingsService settingsService;
	
	 @Autowired 	private TaskService taskService;
	 
	
	@Override
	public void bindToView(Settings settings) {
	}
	
	@Override
	public void unBindToView() {
	}
	

    @FXML
    void onPlay(ActionEvent event) {
    	Media sound = new Media(getData().getAlarmPath());
    	MediaPlayer mediaPlayer = new MediaPlayer(sound);
    	mediaPlayer.play();
    }
    
    @FXML
    void onSave(ActionEvent event) {
    	
    	Task t =  new Task();
    	t.setName("nazwa");
    	t.setDescription("opis");
    //	t.setPomodors(4);
    	
    	taskService.save(t);
    	List<Task> list = taskService.findAll();
    	
    	System.out.println("Task list: " + list.size());
    	for(Task tt : list) {
    		System.out.println("-> " + tt);	
    	}
    	
    	
    	try {
    		settingsService.save(getData());
    	}catch (Exception ex) {
			DialogsUtil.create().showException(ex);
		}

    }
	
}
