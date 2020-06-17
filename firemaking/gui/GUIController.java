package scripts.firemaking.gui;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import org.tribot.api.General;
import org.tribot.util.Util;

import com.allatori.annotations.DoNotRename;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import scripts.firemaking.data.LogType;
import scripts.firemaking.data.Vars;

@DoNotRename
public class GUIController extends AbstractGUIController {

	public static final File FOLDER = new File(Util.getWorkingDirectory().getAbsolutePath(), "//Elon");

	public static final File IMAGE_FOLDER = new File(FOLDER.getAbsolutePath(), "//Images");

	private Properties prop;

	private boolean closeGui = true;

	private FileChooser openFileChooser;

	@FXML @DoNotRename
	private AnchorPane rootPane, mainAnchorPane, bottomPane;

	@FXML @DoNotRename
	private ImageView discordImage, tribotImage;

	@FXML @DoNotRename
	private Pane mainPane;

	@FXML @DoNotRename
	private Button saveButton, loadButton, startButton, addLogButton,clearListButton,discordButton, tribotButton;

	@FXML @DoNotRename
	private TextField saveTextField;

	@FXML @DoNotRename
	private ComboBox<LogType> logComboBox;

	@FXML @DoNotRename
	private Label logListLabel, supportLabel, logLabel, title, infoLabel;

	@FXML @DoNotRename
	private TextArea logTextArea;



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		this.prop = new Properties();

		openFileChooser = new FileChooser();

		openFileChooser.setInitialDirectory(FOLDER);

		logComboBox.setItems(FXCollections.observableArrayList(LogType.values()));

		discordImage.setImage(new Image("https://i.imgur.com/MzWqh1Z.png"));

		tribotImage.setImage(new Image("https://i.imgur.com/KL7M0Ie.png"));
	
		logComboBox.getSelectionModel().select(0);
	}


	@FXML @DoNotRename
	void addLogToLogList(ActionEvent event) {
		if (logComboBox.getValue() != null) {	
		if (logTextArea.getText().isEmpty()) {
			logTextArea.appendText(logComboBox.getValue().toString());
		}else {
			logTextArea.appendText("\n" + logComboBox.getValue().toString());
		}
	}
}

	 @FXML @DoNotRename
    void clearLogList(ActionEvent event) {
		 logTextArea.clear();
    }
	
	@FXML @DoNotRename
	public void discordButtonPressed() throws IOException, URISyntaxException {
		Desktop.getDesktop().browse(new URL("https://discord.gg/fRgDwkb").toURI());

	}

	@FXML
	@DoNotRename
	public void tribotButtonPressed() throws IOException, URISyntaxException {
		Desktop.getDesktop().browse(new URL("https://tribot.org/forums/profile/484380-elon/").toURI());

	}

	@FXML @DoNotRename
	void load() {
		File selectedFile = openFileChooser.showOpenDialog(null);
		if (selectedFile != null) {
			try {
				prop.load(new FileInputStream(selectedFile.getAbsoluteFile()));

				String saveText = prop.getProperty("saveTextField");
				if (saveText != null) {
					saveTextField.setText(saveText);
				}

				String combatAreaText = prop.getProperty("logTextArea");
				if (combatAreaText != null) {
					logTextArea.setText(combatAreaText);
				}

			} catch (Exception e2) {
				System.out.print("Unable to load settings");
				e2.printStackTrace();
			}
		}
	}


	@FXML @DoNotRename
	void save() {

		try {
			File file = new File(FOLDER.getAbsolutePath(), saveTextField.getText() + ".ini");

			prop.put("saveTextField", saveTextField.getText());
			prop.put("logTextArea", logTextArea.getText());
			prop.store(new FileOutputStream(file), saveTextField.getText());

			General.println(saveTextField.getText() + "Save succesful");

		} catch (Exception e1) {
			System.out.print("Error Saving Settings");
			e1.printStackTrace();
		}
	}


	@FXML @DoNotRename
	void start() {
		try {
			closeGui = true;

			if (logTextArea.getText().length() > 0) {		
				String[] logs = logTextArea.getText().split("\n");		
				for(String log : logs) {
					Vars.get().logToBurnList.add(LogType.valueOf(log));
				}				
			} else {			
				General.println("Please Add Logs To The Burn List");
				closeGui = false;
			}

			if (closeGui)
				this.getGUI().close();

		} catch (Exception e1) {
			System.out.print("Error Starting Gui");
			e1.printStackTrace();
		}
	}


}
