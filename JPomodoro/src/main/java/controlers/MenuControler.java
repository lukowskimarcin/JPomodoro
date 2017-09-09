package controlers;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import fxbase.AbstractView;
import fxbase.FXMLView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;

@FXMLView(fxml = "/fxml/Menu.fxml", bundle = "/bundle/messages")
public class MenuControler extends AbstractView {

	@Autowired
	private App app;

	@Autowired
	private AboutControler aboutView;

	@Autowired
	private SettingsControler settingsView;

	@FXML
	void closeAction(ActionEvent event) {
		app.closeApplication();
	}

	@FXML
	void onAbout(ActionEvent event) throws FileNotFoundException {
		aboutView.setTitle(bundle.getString("mAbout"));
		aboutView.initOwner(app.getStage()).initModality(Modality.WINDOW_MODAL).center().showAndWait();
	}

	@FXML
	void onSettings(ActionEvent event) {
		settingsView.setTitle(bundle.getString("mSettings"));
		settingsView.initOwner(app.getStage()).initModality(Modality.WINDOW_MODAL).center().showAndWait();

	}

}
