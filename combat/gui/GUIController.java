package scripts.combat.gui;

import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import org.tribot.api.General;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSItem;
import org.tribot.api2007.types.RSTile;
import org.tribot.util.Util;

import com.allatori.annotations.DoNotRename;
import com.jfoenix.controls.JFXRadioButton;

import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import scripts.combat.data.Utils2;
import scripts.combat.data.Vars;
import scripts.dax_api.api_lib.models.RunescapeBank;
import scripts.utilty.EatUtil;
import scripts.utilty.PathingUtil;

@DoNotRename 
public class GUIController extends AbstractGUIController {

	public static final File FOLDER = new File(Util.getWorkingDirectory().getAbsolutePath(), "//Elon");

	public static final File IMAGE_FOLDER = new File(FOLDER.getAbsolutePath(), "//Images");

	private Properties prop;

	private boolean closeGui = true;

	private FileChooser openFileChooser;

	@FXML @DoNotRename 
	private AnchorPane rootPane, sidePane, mainAnchorPane, bottomPane;

	@FXML @DoNotRename 
	private Pane mainPane, miscPane, inventoryPane;

	@FXML @DoNotRename 
	private ImageView inventoryImage, miscImage, discordImage, smallStartImage, eatAtImage, insideInventoryImage,
			tribotImage, inventoryButtonImage, mainImage;

	@FXML @DoNotRename 
	private JFXRadioButton mainButton, inventoryButton, miscButton;

	@FXML @DoNotRename 
	private Button tribotButton, discordButton, smallPlayButton, loadButton, addItemButton, startButton, saveButton,
			AreaButton, getInventoryButton, removeInventoryButton;

   @FXML @DoNotRename 
   private ComboBox<RunescapeBank> bankComboBox;
	
	@FXML @DoNotRename 
	private Label title, targetLabel, combatAreaLabel, eatAtTitle, inventoryLabel, lootLabel, percentTitle,
			InventoryInfoLabel,bankLabel;

	@FXML @DoNotRename 
	private TextField saveTextField, targetTextField, combatAreaTextField, lootTextField, eatAtField, invItemField,
			amountTextField;

	@FXML @DoNotRename 
	private CheckBox enableABC2DelayCheckBox, bankPotionCheckBox;

	@FXML @DoNotRename 
	private TextArea lootTextArea;

	@FXML @DoNotRename 
	private Rectangle lootTextAreaBorder;



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		this.prop = new Properties();

		openFileChooser = new FileChooser();

		openFileChooser.setInitialDirectory(FOLDER);
	
		bankComboBox.setItems( FXCollections.observableArrayList( RunescapeBank.values()));
		
		inventoryImage.setImage(new Image("https://i.imgur.com/0o9U3cw.png"));

		discordImage.setImage(new Image("https://i.imgur.com/MzWqh1Z.png"));

		smallStartImage.setImage(new Image("https://i.imgur.com/oZZfNjo.png"));

		eatAtImage.setImage(new Image("https://i.imgur.com/ftIZmee.png"));

		insideInventoryImage.setImage(new Image("https://i.imgur.com/DUjk4j1.png"));

		tribotImage.setImage(new Image("https://i.imgur.com/KL7M0Ie.png"));

		inventoryButtonImage.setImage(new Image("https://i.imgur.com/7KnJqNm.png"));

		mainImage.setImage(new Image("https://i.imgur.com/OiqyMWX.png"));

		miscImage.setImage(new Image("https://i.imgur.com/P9mPP15.png"));
	}



	@FXML @DoNotRename 
	void bringMainPageToFront() {
		mainPane.toFront();
	}


	@FXML @DoNotRename 
	void bringInventoryPaneToFront(ActionEvent event) {
		inventoryPane.toFront();
	}


	@FXML @DoNotRename 
	void bringMiscPageToFront() {
		miscPane.toFront();
	}


	@FXML @DoNotRename 
	void addItemToLootList(ActionEvent event) {
		lootTextArea.appendText("\n" + lootTextField.getText());
	}


	@FXML @DoNotRename 
	void areaButtonPressed(ActionEvent event) {
		RSTile tile = Player.getPosition();
		combatAreaTextField.setText(tile.getX() + "," + tile.getY() + "," + tile.getPlane());
	}


	@FXML @DoNotRename 
	public void discordButtonPressed() throws IOException, URISyntaxException {
		Desktop.getDesktop().browse(new URL("https://discord.gg/fRgDwkb").toURI());

	}

	@FXML @DoNotRename 
	public void tribotButtonPressed() throws IOException, URISyntaxException {
		Desktop.getDesktop().browse(new URL("https://tribot.org/forums/profile/484380-elon/").toURI());

	}


	@FXML @DoNotRename 
	void removeInventory(ActionEvent event) {
		insideInventoryImage.setImage(new Image("https://i.imgur.com/DUjk4j1.png"));
		amountTextField.clear();
		invItemField.clear();
	}


	@FXML @DoNotRename 
	void getInventory(ActionEvent event) {
		amountTextField.clear();
		invItemField.clear();

		insideInventoryImage.setImage(Utils2.cropImageInventory());
		RSItem[] inventory = Inventory.filterDuplicates(Inventory.getAll());

		if (inventory.length > 0) {
			for (RSItem item : inventory) {
				int itemCount = Inventory.getCount(item.getID());
				invItemField.appendText(item.getDefinition().getID() + ",");
				amountTextField.appendText(Integer.toString(itemCount) + ",");
			}
		}
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

				String targetText = prop.getProperty("targetTextFIeld");
				if (targetText != null) {
					targetTextField.setText(targetText);
				}

				String eatAtText = prop.getProperty("eatAtField");
				if (eatAtText != null) {
					eatAtField.setText(eatAtText);
				}

				String itemText = prop.getProperty("invItemField");
				if (itemText != null) {
					invItemField.setText(itemText);
				}

				String amountText = prop.getProperty("amountTextField");
				if (amountText != null) {
					amountTextField.setText(amountText);
				}

				String lootText = prop.getProperty("lootTextArea");
				if (lootText != null) {
					lootTextArea.setText(lootText);
				}

				String combatAreaText = prop.getProperty("combatAreaTextField");
				if (combatAreaText != null) {
					combatAreaTextField.setText(combatAreaText);
				}

				if (!invItemField.getText().isEmpty()) {
					File imageMagicFile = new File(IMAGE_FOLDER.getAbsolutePath(),
							saveTextField.getText() + "inventory.png");
					insideInventoryImage.setImage(new Image(imageMagicFile.toURI().toString()));
				}

				
				String bankText = prop.getProperty("bankComboBox");
				if (bankText != null) {
					bankComboBox.setValue(RunescapeBank.valueOf(bankText));
				}
				
					
				bankPotionCheckBox.setSelected(Boolean.valueOf(prop.getProperty("bankPotionCheckBox")));

				enableABC2DelayCheckBox.setSelected(Boolean.valueOf(prop.getProperty("disableDelayCheckBox")));

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

			if (!invItemField.getText().isEmpty()) {
				File outPutFile = new File(IMAGE_FOLDER.getAbsolutePath(), saveTextField.getText() + "inventory.png");
				BufferedImage image = SwingFXUtils.fromFXImage(insideInventoryImage.getImage(), null);
				ImageIO.write(image, "png", outPutFile);
			}

			prop.put("saveTextField", saveTextField.getText());
			prop.put("targetTextFIeld", targetTextField.getText());
			prop.put("eatAtField", eatAtField.getText());
			prop.put("invItemField", invItemField.getText());
			prop.put("amountTextField", amountTextField.getText());
			prop.put("lootTextArea", lootTextArea.getText());
			prop.put("combatAreaTextField", combatAreaTextField.getText());
			prop.put("disableDelayCheckBox", String.valueOf(enableABC2DelayCheckBox.isSelected()));
			prop.put("bankPotionCheckBox", String.valueOf(bankPotionCheckBox.isSelected()));
			prop.put("bankComboBox", String.valueOf(bankComboBox.getValue()));
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
			Vars.get().abc2Delay = enableABC2DelayCheckBox.isSelected();
		
			if (!combatAreaTextField.getText().contains("Click Combat Area") && combatAreaTextField.getText().length() > 0) {
				String[] text = combatAreaTextField.getText().split(",");
				Vars.get().combatTile = new RSTile(Integer.parseInt(text[0]), Integer.parseInt(text[1]),Integer.parseInt(text[2]));
				if (bankComboBox.getValue() == null)
				Vars.get().bankTile = PathingUtil.nearestBankTile(Vars.get().combatTile);		
				} else {
				General.println("Please Assign A Area");
				closeGui = false;
			}

			
			if (bankComboBox.getValue() != null) {
				Vars.get().bankTile = bankComboBox.getValue().getPosition();
			}else {
				General.println("No Bank Was Selected Automaticly Selecting One");
			}
			
							
			if (!targetTextField.getText().contains("Case Sensitive") && targetTextField.getText().length() > 0) {
				Vars.get().target = targetTextField.getText();
			} else {
				General.println("Please Assign A Target");
				closeGui = false;
			}


			if (lootTextArea.getText().length() > 0)
				Vars.get().itemsToLoot = lootTextArea.getText().split("\n");


			if (invItemField.getText().length() > 0 && amountTextField.getText().length() > 0) {
				String[] invText = invItemField.getText().split(",");
				String[] amountText = amountTextField.getText().split(",");
				for (int i = 0; i < invText.length; i++) {
					Vars.get().inventoryMap.put(Integer.parseInt(invText[i]), Integer.parseInt(amountText[i]));
				}
			} else {
				General.println("Please Setup Your Inventory");
				closeGui = false;
			}


			if (eatAtField.getText().length() > 0) {
				int eatAt = Integer.parseInt(eatAtField.getText().trim());
				Vars.get().eatAtHP = eatAt;
				General.println("Eating at " + Vars.get().eatAtHP);
			} else {
				General.println("Please Assign a Eat %");
				closeGui = false;
			}


			if (EatUtil.hasNoFood(Vars.get().inventoryMap)) {
				General.println("Please Add Food In Your Inventory Setup");
				closeGui = false;
			}

			if (Utils2.potionHandler(Vars.get().inventoryMap, Vars.get().potionNames)) {
				Vars.get().drinkPotions = true;
				Vars.get().bankPotion = bankPotionCheckBox.isSelected();
				General.println("Useing Potions");
			}


			if (closeGui)
				this.getGUI().close();

		} catch (Exception e1) {
			System.out.print("Error Starting Gui");
			e1.printStackTrace();
		}
	}


}
