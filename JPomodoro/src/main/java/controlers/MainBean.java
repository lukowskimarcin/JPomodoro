package controlers;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import fxbase.AbstractView;
import fxbase.FXMLView;
import javafx.application.Platform;
import javafx.scene.layout.BorderPane;
import models.Settings;
import services.SettingsService;
import utils.DialogsUtil;

@FXMLView(fxml = "/fxml/Main.fxml", bundle = "/bundle/messages")
public class MainBean extends AbstractView {

	@Autowired
	private MenuBean menu;

	@Autowired
	private SettingsService settingsService;

	private Settings settings;

	@PostConstruct
	private void init() {
		setTitle(bundle.getString("title"));
		BorderPane pane = (BorderPane) getView();
		pane.setTop(menu.getView());
			 
		try {
			settings = settingsService.load();
			System.out.println(settings);
		} catch (Exception ex) {
			DialogsUtil.create().showException(ex);
		}
	}

	public void setCenter(AbstractView node) {
		BorderPane pane = (BorderPane) getView();
		pane.setCenter(node.getView());
	}
	
	public Settings getSettings() {
		return settings;
	}
	
	public void setSettings(Settings settings) {
		this.settings = settings;
	}
}
