package controlers;

import org.springframework.context.annotation.Scope;

import fxbase.AbstractSeparateView;
import fxbase.FXMLView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


@Scope("prototype")
@FXMLView(fxml="/fxml/About.fxml", bundle="/bundle/messages")
public class AboutControler extends AbstractSeparateView {

	public AboutControler() {
		System.out.println("Create AboutControler");
	}
	
    @FXML
    private Button bOk;

    @FXML
    void onAction(ActionEvent event) {
    	 close();
    }
    
}
