package controlers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import fxbase.AbstractJavaFxApplication;
import javafx.scene.image.Image;

 

@Lazy
@ComponentScan(basePackages= { "controlers", "services"  })
@EnableJpaRepositories(basePackages={"repositories"})
@EntityScan(basePackages={"models"})
@SpringBootApplication
public class App extends AbstractJavaFxApplication {
	
	protected static final Logger log = Logger.getLogger(App.class.getName());   
	
	public static void main(String[] args) throws FileNotFoundException {
		loadIcons();
		addDefaultCSS("/css/app.css");
		setStartInTray(false);
		launchApp(App.class, MainBean.class, args);  
	}
	 
	private static void loadIcons() {
		try {
			InputStream img = new FileInputStream("src/main/resources/images/pomodoro.png");
			Image icon = new Image(img);
			setDefaultIcon(icon);
		} catch (Exception ex) {
			log.log(Level.SEVERE, ex.getMessage(), ex);
		}
	}
	
	@Override
	protected InputStream getTrayIcon() {
		InputStream is = null;
		try {
			is = new FileInputStream("src/main/resources/images/pomodoro.png");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return is;
	}
	 
}
