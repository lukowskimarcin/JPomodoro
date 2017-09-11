package controlers;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import fxbase.AbstractView;
import fxbase.FXMLView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import models.Settings;
import services.SettingsService;
import utils.DialogsUtil;

@FXMLView(fxml = "/fxml/Menu.fxml", bundle = "/bundle/messages")
public class MenuBean extends AbstractView {

	@Autowired
	private App app;

	@Autowired
	private MainBean main;

	@Autowired
	private AboutBean aboutBean;

	@Autowired
	private SettingsBean settingsBean;
	
	@Autowired
	private TaskListBean taskListBean;
	
	@Autowired
	private SettingsService settingsService;

	@FXML
	private MenuItem mTasks;

	@FXML
	private MenuItem mSettings;

	@FXML
	private MenuItem mClose;

	@FXML
	private MenuItem mAbout;

	@FXML
	void closeAction(ActionEvent event) {
		app.closeApplication();
	}

	@FXML
	void onAbout(ActionEvent event) throws FileNotFoundException {
		aboutBean.setTitle(bundle.getString("mAbout"));
		aboutBean.initOwner(app.getStage()).initModality(Modality.WINDOW_MODAL).center().showAndWait();
	}

	@FXML
	void onSettings(ActionEvent event) {
		try {
			Settings settings = settingsService.load();
			settingsBean.populate(settings); 
			main.setSettings(settings);
			main.setCenter(settingsBean);
		} catch (Exception ex) {
			DialogsUtil.create().showException(ex);
		}
	}

	@FXML
	void onTaskList(ActionEvent event) {
		main.setCenter(taskListBean);
	}

}
