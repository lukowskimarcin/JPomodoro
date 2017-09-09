package controlers;

import org.springframework.context.annotation.Scope;

import fxbase.AbstractView;
import fxbase.FXMLView;

@Scope("prototype")
@FXMLView(fxml="/fxml/Settings.fxml", bundle="/bundle/messages")
public class SettingsControler extends AbstractView{

}
